/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Modelo.InsumoBruto;
import java.util.List;
import Modelo.InsumoElaborado;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import Persistencia.ORM.DAOInterface.IInsumoElaborado;
import org.hibernate.criterion.Order;

/**
 *
 * @author ang_2
 */
public class InsumoElaboradoDAO extends GenericDAO<InsumoElaborado, Integer> implements IInsumoElaborado {

    private static final Logger LOG = Logger.getLogger(InsumoElaboradoDAO.class);

    @Override
    public List<InsumoElaborado> getTodosStockMinimo() {
        Session session = getHibernateTemplate();
        List<InsumoElaborado> objetos = new ArrayList<>();
        try {
            String sql = "select * from insumo insumo inner join stock stock on insumo.id_stock = stock.id inner join insumoelaborado insumoelaborado on insumo.id = insumoelaborado.id where insumo.fechaBaja is null and stock.cantidadActual <= stock.cantidadMinima order by nombre";
            objetos = session.createSQLQuery(sql).addEntity(InsumoElaborado.class).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

    @Override
    public List<InsumoElaborado> getTodosByNombreSinEstos(String nombreInsumo, List<Integer> ids, boolean activo) {
        Session session = getHibernateTemplate();
        List<InsumoElaborado> objetos = new ArrayList<>();
        try {
            Criteria criterio = session.createCriteria(InsumoElaborado.class);
            criterio.add(Restrictions.neOrIsNotNull("id", null));

            if (nombreInsumo != null) {
                criterio.add(Restrictions.like("nombre", nombreInsumo + "%"));
            }
            if (activo) {
                criterio.add(Restrictions.isNull("fechaBaja"));
            }
            if (ids != null && !ids.isEmpty()) {
                criterio.add(Restrictions.not(Restrictions.in("id", ids)));
            }
            criterio.addOrder(Order.asc("nombre"));
            objetos = criterio.list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

    @Override
    public InsumoElaborado buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<InsumoElaborado> objetos = new ArrayList<>();
        try {
            String sql = "from InsumoElaborado where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar  insumo", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<InsumoElaborado> insumoEnUso(InsumoBruto insumo) {
        Session session = getHibernateTemplate();
        List<InsumoElaborado> objetos = new ArrayList<>();
        try {
            String sql = "select * from Insumo insumo inner join DetalleInsumoElaborado die ON insumo.id = die.id_InsumoElaborado inner join Insumo insumobruto ON insumobruto.id = die.id_insumoBruto WHERE insumobruto.id = :id and insumo.fechaBaja is null  ";
            objetos = session.createSQLQuery(sql).addEntity(InsumoElaborado.class).setParameter("id", insumo.getId()).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

}
