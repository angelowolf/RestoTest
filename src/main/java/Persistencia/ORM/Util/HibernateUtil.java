package Persistencia.ORM.Util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:25 p.m.
 */
public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORY;
    private static final Logger LOG = Logger.getLogger(HibernateUtil.class);

    static {
        try {
            SESSIONFACTORY = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException he) {
            LOG.error("Ocurrió un error en la inicialización de la SessionFactory: ", he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSESSIONFACTORY() {
        return SESSIONFACTORY;
    }
}//end HibernateUtil
