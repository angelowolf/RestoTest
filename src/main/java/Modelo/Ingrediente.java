/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ang_2
 */
public class Ingrediente {

    private int id;
    private float cantidad;
    private Insumo insumo;
    private boolean opcional;

    public Ingrediente() {
    }

    public Ingrediente(float cantidad, Insumo insumo, boolean opcional) {
        this.cantidad = cantidad;
        this.insumo = insumo;
        this.opcional = opcional;
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

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "id=" + id + ", cantidad=" + cantidad + ", insumo=" + insumo + ", opcional=" + opcional + '}';
    }

    /**
     * Actualiza la cantidad y si es opcional.
     *
     * @param ingredienteRequest
     */
    void actualizar(Ingrediente ingredienteRequest) {
        this.setCantidad(ingredienteRequest.getCantidad());
        this.setOpcional(ingredienteRequest.isOpcional());
    }

}
