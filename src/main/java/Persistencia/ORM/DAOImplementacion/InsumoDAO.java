/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import java.util.List;
import Modelo.Insumo;
import Persistencia.ORM.DAOInterface.IInsumo;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ang_2
 */
public class InsumoDAO extends GenericDAO<Insumo, Integer> implements IInsumo {

    private static final Logger LOG = Logger.getLogger(InsumoDAO.class);

    @Override
    public List<Insumo> getTodos(boolean activo) {
        Session session = getHibernateTemplate();
        List<Insumo> objetos = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder("from Insumo");
            if (activo) {
                sql.append(" where fechaBaja is null");
            }
            sql.append(" order by nombre");
            objetos = session.createQuery(sql.toString()).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

    @Override
    public List<Insumo> getTodosByCategoriaByNombre(int idCategoria, String nombreInsumo, List<Integer> ids, boolean activo) {
        Session session = getHibernateTemplate();
        List<Insumo> objetos = new ArrayList<>();
        try {
            Criteria criterio = session.createCriteria(Insumo.class);
            criterio.add(Restrictions.neOrIsNotNull("id", null));

            if (nombreInsumo != null) {
                criterio.add(Restrictions.like("nombre", nombreInsumo + "%"));
            }
            if (idCategoria > 0) {
                criterio.add(Restrictions.eq("categoriaInsumo.id", idCategoria));
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
}
