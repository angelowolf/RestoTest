/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notificacion;

import Modelo.Notificacion;
import Modelo.NotificacionStock;
import Modelo.Usuario;
import java.io.IOException;
import javax.websocket.CloseReason;
import javax.websocket.Session;
import org.json.JSONObject;

/**
 *
 * @author ang_2
 */
public class SesionWeb implements ISesion {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SesionWeb.class);
    private final Session sesion;
    private String key;

    public SesionWeb(Session session) {
        this.sesion = session;
        key = session.getId();
    }

    @Override
    public void mandarMensaje(Notificacion notificacion) {
        try {
            if (sesion.isOpen()) {
                LOGGER.info(notificacion.toString());
                JSONObject json = new JSONObject();
                json.append("id", notificacion.getId());
                json.append("tipo", notificacion.getTipoMensaje());
                json.append("mensaje", notificacion.getMensaje());
                json.append("fecha", notificacion.getFecha2());
                switch (notificacion.getTipoMensaje()) {
                    case NOTIFICACION_STOCK: {
                        NotificacionStock ns = (NotificacionStock) notificacion;
                        json.append("id_insumo", ns.getInsumo().getId());
                    }
                    break;
                    default: {
                        this.notificarError("Le falta el tipo de notificacion a esta notificacion.");
                    }
                    break;
                }
                sesion.getBasicRemote().sendText(json.toString());
                LOGGER.info("Notificacion mandada con exito.");
            }
        } catch (IOException ex) {
            LOGGER.error("Error al mandar notificacion.", ex);
        }
    }

    @Override
    public void exitoAlLogear(Usuario usuario) {
        try {
            if (sesion.isOpen()) {
                sesion.getUserProperties().put("idUsuario", usuario.getId());
                sesion.getUserProperties().put("key", sesion.getId());
                JSONObject objetoJSON = new JSONObject();
                objetoJSON.append("tipo", "OK");
                sesion.getBasicRemote().sendText(objetoJSON.toString());
            }
        } catch (IOException ex) {
            LOGGER.error("Error al mandar notificacion.", ex);
        }
    }

    @Override
    public void notificarError(String mensaje) {
        try {
            JSONObject o = new JSONObject();
            o.append("tipo", "" + TipoMensaje.ERROR);
            o.append("mensaje", mensaje);
            sesion.getBasicRemote().sendText(o.toString());
            sesion.close(new CloseReason(CloseReason.CloseCodes.VIOLATED_POLICY, "Algo salio muy mal... o no tan mal(como login mal viste..)"));
        } catch (IOException ex) {
            LOGGER.error("Error al mandar notificacion.", ex);
        }
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

}
