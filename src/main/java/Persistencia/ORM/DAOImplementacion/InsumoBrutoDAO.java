/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import java.util.List;
import Modelo.InsumoBruto;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import Persistencia.ORM.DAOInterface.IInsumoBruto;
import org.hibernate.criterion.Order;

/**
 *
 * @author ang_2
 */
public class InsumoBrutoDAO extends GenericDAO<InsumoBruto, Integer> implements IInsumoBruto {

    private static final Logger LOG = Logger.getLogger(InsumoBrutoDAO.class);

    @Override
    public List<InsumoBruto> getTodosStockMinimo() {
        Session session = getHibernateTemplate();
        List<InsumoBruto> objetos = new ArrayList<>();
        try {
            String sql = "select * from insumo insumo inner join stock stock on insumo.id_stock = stock.id inner join insumobruto insumobruto on insumo.id = insumobruto.id where insumo.fechaBaja is null and stock.cantidadActual <= stock.cantidadMinima order by nombre";
            objetos = session.createSQLQuery(sql).addEntity(InsumoBruto.class).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

    @Override
    public List<InsumoBruto> getTodosByCategoriaByNombreSinEstos(int idCategoria, String nombreInsumo, List<Integer> ids, boolean activo) {
        Session session = getHibernateTemplate();
        List<InsumoBruto> objetos = new ArrayList<>();
        try {
            Criteria criterio = session.createCriteria(InsumoBruto.class);
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

    @Override
    public InsumoBruto buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<InsumoBruto> objetos = new ArrayList<>();
        try {
            String sql = "from Insumo where nombre = :nombre";
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

}
