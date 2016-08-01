/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notificacion;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONException;
import org.json.JSONObject;

@ServerEndpoint(value = "/wsnotificacion")
public class NotificacionEndPoint {

    private final WSControlador ch = WSControlador.getControlador();

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(NotificacionEndPoint.class);

    @OnError
    public void onError(Throwable t) {
        LOGGER.debug(t.toString());
    }

    @OnOpen
    public void onOpen(final Session session) {
        LOGGER.debug("*******************ABRIENDO SESSION**************************");
        LOGGER.debug("*******************conexion abierta**************************");
    }

    @OnClose
    public void onClose(Session session) {
        int idUsuario = (int) session.getUserProperties().get("idUsuario");
        String key = (String) session.getUserProperties().get("key");
        ch.quitarUsuario(idUsuario, key);
        LOGGER.debug("********************************CERRANDO SESION*************************************");
        LOGGER.debug("********conexion cerrada para usuario: " + idUsuario + " sesion key: " + key + "***********");
    }

    @OnMessage
    public void onMessage(final Session session, String msg) throws IOException {
        LOGGER.debug("intentando logear con: " + msg + "key: " + session.getId());
        SesionWeb sesion = new SesionWeb(session);
        try {
            JSONObject objetoJSON = new JSONObject(msg);
            switch (getTipo(objetoJSON.getString("tipo"))) {
                /**
                 * Inciar sesion por parte del cliente.
                 */
                case LOGIN: {
                    this.logear(session, objetoJSON);
                }
                break;
                /**
                 * Cuando alguien toca el codigo js y el tipo mensaje no es uno
                 * de los posibles.
                 */
                case ERROR: {
                    sesion.notificarError("Okey... Que intentas hacer? :(");
                }
                break;
            }
        } catch (JSONException e) {
            LOGGER.error("Error de JSON", e);
            sesion.notificarError("Error de sintaxis JSON. Mira la consola.");
        }
    }

    private void logear(Session session, JSONObject objetoJSON) {
        ch.agregarUsuario(objetoJSON.getInt("idUsuario"), new SesionWeb(session));
    }

    private TipoMensaje getTipo(String tipo) {
        if (tipo.equals("LOGIN")) {
            return TipoMensaje.LOGIN;
        }
        return TipoMensaje.ERROR;
    }

}
