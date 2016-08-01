/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Notificacion.TipoMensaje;
import Spring.Mensajes;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class Notificacion implements Mensajes{

    private int id;
    private String mensaje;
    private LocalDateTime fecha;
    private Usuario usuario;
    private boolean visto;
    private TipoMensaje tipoMensaje;

    public String getFecha2() {
        if (fecha != null) {
            return mensajes.getFechaHumana(fecha);
        }
        return null;
    }

    public Notificacion() {
    }

    public Notificacion(int id) {
        this.id = id;
    }

    public Notificacion(String mensaje, LocalDateTime fecha, Usuario usuario, boolean visto, TipoMensaje tipoMensaje) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.usuario = usuario;
        this.visto = visto;
        this.tipoMensaje = tipoMensaje;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoMensaje getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(TipoMensaje tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    @Override
    public String toString() {
        return "Notificacion{ HUMANO" + getFecha2() + "id=" + id + ", mensaje=" + mensaje + ", fecha=" + fecha + ", usuario=" + usuario + ", visto=" + visto + ", tipoMensaje=" + tipoMensaje + '}';
    }

    public int getIdInforme() {
        return 0;
    }
}
