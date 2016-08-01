/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author ang_2
 */
public class DetalleInsumoElaborado {

    private int id;
    private InsumoBruto insumoBruto;
    private float cantidad;

    public DetalleInsumoElaborado() {
    }

    public DetalleInsumoElaborado(InsumoBruto insumo, float cantidad) {
        this.insumoBruto = insumo;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InsumoBruto getInsumoBruto() {
        return insumoBruto;
    }

    public void setInsumoBruto(InsumoBruto insumoBruto) {
        this.insumoBruto = insumoBruto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleInsumoElaborado{" + "id=" + id + ", insumoBruto=" + insumoBruto + ", cantidad=" + cantidad + '}';
    }

    /**
     * Calcula la cantidad de este insumo bruto que es usado segun la cantidad
     * confeccionada del insumo elaborado, y registra un detalle stock
     * actualizando esa cantidad.
     *
     * @param cantidadConfeccionarInsumo
     */
    public void registrarConfeccion(float cantidadConfeccionarInsumo) {
        this.getInsumoBruto().registrarConfeccion(cantidadConfeccionarInsumo * cantidad);
    }

}
