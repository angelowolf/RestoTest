/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Modelo.EstadoPedido.EstadoPedido;
import Persistencia.ORM.DAOInterface.IEstadadoPedido;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 *
 * @author ang_2
 */
public class EstadoPedidoDAO extends GenericDAO<EstadoPedido, Integer> implements IEstadadoPedido {

    private static final Logger LOG = Logger.getLogger(EstadoPedidoDAO.class);

    public EstadoPedido buscar(String nombre) {
        Session session = getHibernateTemplate();
        List<EstadoPedido> objetos = new ArrayList<>();
        try {
            String sql = "from EstadoPedido where nombre = :nombre";
            objetos = session.createQuery(sql).setParameter("nombre", nombre).list();
        } catch (RuntimeException e) {
            LOG.error("Error al guardar", e);
        }
        return objetos.get(0);
    }

}
