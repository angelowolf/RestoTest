/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Spring.Mensajes;
import org.apache.struts2.json.annotations.JSON;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class DetalleStock implements Mensajes{
    private int id;
    private float cantidad, total;
    private LocalDateTime fecha;
    private TipoMovimiento tipoMovimiento;
    private String f;

    public DetalleStock() {
    }

    public DetalleStock(float cantidad, float total, LocalDateTime fecha, TipoMovimiento tipoMovimiento) {
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getf() {
        if (null == fecha) {
            return null;
        }
        return fecha.toString(mensajes.FECHAJSON);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getF() {
        if (null == fecha) {
            return null;
        }
        return fecha.toString(mensajes.FECHAJSON);
    }

    @JSON(serialize = false)
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

}
