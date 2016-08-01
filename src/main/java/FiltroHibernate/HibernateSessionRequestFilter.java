package FiltroHibernate;

import Persistencia.ORM.Util.HibernateUtil;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class HibernateSessionRequestFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(HibernateSessionRequestFilter.class);
    private SessionFactory sf;

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @exception IOException,ServletException
     * @throws javax.servlet.ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            LOG.debug("Starting a database transaction");

            sf.getCurrentSession().beginTransaction();
            // Call the next filter (continue request processing)  
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);

            // Commit and cleanup  
            LOG.debug("Committing the database transaction");
            sf.getCurrentSession().getTransaction().commit();
        } catch (StaleObjectStateException staleEx) {
            LOG.error("This interceptor does not implement optimistic concurrency control!");
            LOG.error("Your application will not work until you add compensation actions!");
//             Rollback, close everything, possibly compensate for any permanent changes  
//             during the conversation, and finally restart business conversation. Maybe  
//             give the user of the application a chance to merge some of his work with  
//             fresh data... what you do here depends on your applications design.  
            throw staleEx;
        } catch (Throwable ex) {
            // Rollback only  
            ex.printStackTrace();
            try {
                if (sf.getCurrentSession().getTransaction().isActive()) {
                    LOG.info("Trying to rollback database transaction after exception");
                    sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable rbEx) {
                LOG.error("Could not rollback transaction after exception!", rbEx);
            }
            // Let others handle it... maybe another interceptor for exceptions?  
            throw new ServletException(ex);
        }
    }

    /**
     *
     * @param filterConfig
     * @exception ServletException
     */
    public void init(FilterConfig filterConfig) {
        try {
            LOG.info("Seesion Factory iniciada");
            sf = HibernateUtil.getSESSIONFACTORY();
        } catch (Exception e) {
            LOG.error("Error al iniciarlizar el filtro", e);
        }
    }

    public void destroy() {
        LOG.info("Cerrando Session Factory");
        closeSessionFactory(sf);
        try {
            java.sql.Driver mySqlDriver = DriverManager.getDriver("jdbc:mysql://localhost:3306/");
            DriverManager.deregisterDriver(mySqlDriver);
        } catch (SQLException ex) {
            LOG.error("Could not deregister driver:".concat(ex.getMessage()));
        }
    }

    private void closeSessionFactory(SessionFactory factory) {
        if (factory instanceof SessionFactoryImpl) {
            SessionFactoryImpl sf = (SessionFactoryImpl) factory;
            ConnectionProvider conn = sf.getConnectionProvider();
            if (conn instanceof C3P0ConnectionProvider) {
                ((C3P0ConnectionProvider) conn).close();
            }
        }
        factory.close();
    }
}//end HibernateSessionRequestFilter
