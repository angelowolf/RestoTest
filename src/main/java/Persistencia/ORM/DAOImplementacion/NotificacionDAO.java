/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import java.util.List;
import Modelo.Notificacion;
import Modelo.NotificacionStock;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import Persistencia.ORM.DAOInterface.INotificacion;

/**
 *
 * @author ang_2
 */
public class NotificacionDAO extends GenericDAO<Notificacion, Integer> implements INotificacion {

    private static final Logger LOG = Logger.getLogger(NotificacionDAO.class);

    @Override
    public List<Notificacion> getTodos(int idUsuario) {
        Session session = getHibernateTemplate();
        List<Notificacion> objetos = new ArrayList<>();
        try {
            String sql = "from Notificacion where id_usuario = :id_usuario order by fecha";
            objetos = session.createQuery(sql).setParameter("id_usuario", idUsuario).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las notificaciones.", e);
        }
        return objetos;
    }

    @Override
    public List<Notificacion> getTodosStock(int idUsuario, int limit) {
        Session session = getHibernateTemplate();
        List<Notificacion> objetos = new ArrayList<>();
        try {
            StringBuilder sb = new StringBuilder("select * from Notificacion notificacion inner join NotificacionStock stock on notificacion.id = stock.id where notificacion.id_usuario = :id_usuario");
            sb.append(" order by notificacion.fecha desc");
            if (limit > 0) {
                sb.append(" limit ");
                sb.append(limit);
            }
            objetos = session.createSQLQuery(sb.toString()).addEntity(NotificacionStock.class).setParameter("id_usuario", idUsuario).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las notificaciones.", e);
        }
        return objetos;
    }

    @Override
    public NotificacionStock getNotificacionStock(int idUsuario, int idInsumo) {
        Session session = getHibernateTemplate();
        List<NotificacionStock> objetos = new ArrayList<>();
        try {
            StringBuilder sb = new StringBuilder("select * from Notificacion notificacion inner join NotificacionStock stock on notificacion.id = stock.id where notificacion.id_usuario = :id_usuario");
            sb.append(" and stock.id_insumo = :id_insumo");
            objetos = session.createSQLQuery(sb.toString()).addEntity(NotificacionStock.class).setParameter("id_usuario", idUsuario).setParameter("id_insumo", idInsumo).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las notificaciones.", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int getCantidadNoVistas(int idUsuario) {
        Session session = getHibernateTemplate();
        long cnt = 0;
        try {
            String sb = "select count(id) from Notificacion where id_usuario = :id_usuario and visto = 0";
            cnt = (long) session.createQuery(sb).setParameter("id_usuario", idUsuario).uniqueResult();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar las notificaciones.", e);
        }
        return (int) cnt;
    }
}
