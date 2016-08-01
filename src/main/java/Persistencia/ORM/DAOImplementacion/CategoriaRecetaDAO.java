/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Modelo.CategoriaReceta;
import java.util.List;
import Persistencia.ORM.DAOInterface.ICategoriaReceta;
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
public class CategoriaRecetaDAO extends GenericDAO<CategoriaReceta, Integer> implements ICategoriaReceta {

    private static final Logger LOG = Logger.getLogger(CategoriaRecetaDAO.class);

    @Override
    public List<CategoriaReceta> getTodos() {
        Session session = getHibernateTemplate();
        List<CategoriaReceta> objetos = new ArrayList<>();
        try {
            String sql = "from CategoriaReceta order by nombre";
            objetos = session.createQuery(sql).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las categorias.", e);
        }
        return objetos;
    }

    @Override
    public CategoriaReceta buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<CategoriaReceta> objetos = new ArrayList<>();
        try {
            String sql = "from CategoriaReceta where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar categoria receta", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }


    @Override
    public List<CategoriaReceta> buscarFiltro(String nombreFiltro) {
        Session session = getHibernateTemplate();
        List<CategoriaReceta> objetos = new ArrayList<>();
        try {
            Criteria criterio = session.createCriteria(CategoriaReceta.class);
            criterio.add(Restrictions.neOrIsNotNull("id", null));
            if (nombreFiltro != null) {
                criterio.add(Restrictions.like("nombre", nombreFiltro + "%"));
            }
            criterio.addOrder(Order.asc("nombre"));
            objetos = criterio.list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las categorias insumo.", e);
        }
        return objetos;
    }
}
