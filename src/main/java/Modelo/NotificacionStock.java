/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Notificacion.TipoMensaje;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class NotificacionStock extends Notificacion {

    private Insumo insumo;

    public NotificacionStock() {
        setTipoMensaje(TipoMensaje.NOTIFICACION_STOCK);
    }

    public NotificacionStock(Insumo insumo, String mensaje, LocalDateTime fecha, Usuario usuario, boolean visto) {
        super(mensaje, fecha, usuario, visto, TipoMensaje.NOTIFICACION_STOCK);
        this.insumo = insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    @Override
    public String toString() {
        return super.toString() + " NotificacionStock{" + "insumo=" + insumo + '}';
    }

    @Override
    public int getIdInforme() {
        return insumo.getId();
    }
}
