/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.Notificacion;
import Modelo.NotificacionStock;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface INotificacion extends IGenericDAO<Notificacion, Integer> {

    public List<Notificacion> getTodos(int idUsuario);

    /**
     * busca todas las notificaciones de tipo stock para un usuario y limita el
     * resultado. 0 busca todas.
     *
     * @param idUsuario
     * @param limit
     * @return
     */
    public List<Notificacion> getTodosStock(int idUsuario, int limit);

    /**
     * Busca una notificacion de un usuario sobre un insumo en particular.
     *
     * @param idUsuario
     * @param idInsumo
     * @return
     */
    public NotificacionStock getNotificacionStock(int idUsuario, int idInsumo);

    public int getCantidadNoVistas(int idUsuario);

}
