/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorUsuario;
import Modelo.Insumo;
import Modelo.Notificacion;
import Modelo.NotificacionStock;
import Modelo.Rol;
import Modelo.Usuario;
import Notificacion.WSControlador;
import Persistencia.ORM.DAOImplementacion.NotificacionDAO;
import Persistencia.ORM.DAOImplementacion.NotificacionStockDAO;
import Persistencia.ORM.DAOInterface.INotificacion;
import Persistencia.ORM.DAOInterface.INotificacionStock;
import Spring.Mensajes;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class ControladorNotificacion implements Mensajes {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(ControladorNotificacion.class);

    private static ControladorNotificacion instancia = null;
    private final IControladorUsuario controladorUsuario = new ControladorUsuario();
    private final INotificacion DAONotificacion = new NotificacionDAO();
    private final INotificacionStock DAONotificacionStock = new NotificacionStockDAO();

    /**
     * Notifica a todos los usuarios logeados con el rol Responsable Stock sobre
     * este insumo, crea y guarda para todos los usuarios la notificacion.
     *
     * @param insumo.
     */
    public void notificarInsumoDebajoDelMinimo(Insumo insumo) {
        List<Rol> rolStock = new ArrayList<>();
        rolStock.add(Rol.Stock);
        List<Usuario> usuariosStock = controladorUsuario.buscar(null, null, rolStock);
        for (Usuario cadaUsuario : usuariosStock) {
            if (DAONotificacion.getNotificacionStock(cadaUsuario.getId(), insumo.getId()) == null) {
                NotificacionStock notificacionStock = new NotificacionStock(insumo, mensajes.getNotificacionInsumo(insumo.getNombre()), new LocalDateTime(), cadaUsuario, false);
                LOGGER.info("Guardando notificacion para usuario: " + cadaUsuario.getId());
                DAONotificacion.guardar(notificacionStock);
                WSControlador.getControlador().mandarNotificacion(cadaUsuario.getId(), notificacionStock);
            } else {
                LOGGER.info("El usuario " + cadaUsuario.getId() + " ya posee notificacion.Se cancela el envio y guardado.");
            }
        }
    }

    /**
     * Busca todas las notificaciones de un usuario.
     *
     * @param idUsuario
     * @return
     */
    public List<Notificacion> buscar(int idUsuario) {
        return DAONotificacion.getTodos(idUsuario);
    }

    /**
     * Busca todas las notificaciones de insumos que seran mostradas en un
     * panel.
     *
     * @param idUsuario
     * @return
     */
    public List<Notificacion> buscarNotificacionInsumo(int idUsuario) {
        return DAONotificacion.getTodosStock(idUsuario, 5);
    }

    /**
     * Elimina una notificacion de la BD.
     *
     * @param notificacion
     */
    public void eliminar(Notificacion notificacion) {

        switch (DAONotificacion.buscar(notificacion.getId()).getTipoMensaje()) {
            case NOTIFICACION_STOCK:
                NotificacionStock ns = new NotificacionStock();
                ns.setId(notificacion.getId());
                DAONotificacionStock.eliminar(ns);
                break;
            default:
                LOGGER.error("NO SE PUDO ELIMINAR EL OBJETO NOTIFICACIOn");
        }

    }

    /**
     * Actualiza una notificacion como vista en la BD.
     *
     * @param notificacion
     */
    public void marcarComoVisto(Notificacion notificacion) {
        Notificacion nBD = DAONotificacion.buscar(notificacion.getId());
        nBD.setVisto(true);
        DAONotificacion.actualizar(nBD);
    }

    /**
     * Devuelve la cantidad de notificaciones sin ver de este usuario
     *
     * @param idUsuario
     * @return
     */
    public int getCantidadNoVistas(int idUsuario) {
        return DAONotificacion.getCantidadNoVistas(idUsuario);
    }

    /**
     * Busca una notificacion
     *
     * @param id
     * @return
     */
    public Notificacion buscarNotificacion(int id) {
        return DAONotificacion.buscar(id);
    }

}
