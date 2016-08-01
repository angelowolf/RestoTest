/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notificacion;

/**
 *
 * @author ang_2
 */
public enum TipoMensaje {
    LOGIN, NOTIFICACION_STOCK, ERROR;

    public String getIcono() {
        switch (this) {
            case NOTIFICACION_STOCK:
                return "shopping-basket";
            default:
                throw new IllegalArgumentException();
        }
    }
}
