/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorNotificacion;
import Modelo.Notificacion;

/**
 *
 * @author ang_2
 */
public class InformeAction extends Accion {

    private int id;
    private final ControladorNotificacion cn = new ControladorNotificacion();

    public String ver() {
        Notificacion n = cn.buscarNotificacion(id);
        switch (n.getTipoMensaje()) {
            case NOTIFICACION_STOCK:
                id = n.getIdInforme();
                return "stock";
            default:
                return ERROR;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

}
