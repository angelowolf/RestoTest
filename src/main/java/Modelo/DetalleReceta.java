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
public class DetalleReceta {

    private int id;
    private Receta receta;
    private boolean opcional;

    public DetalleReceta() {
    }

    public DetalleReceta(Receta receta, boolean opcional) {
        this.receta = receta;
        this.opcional = opcional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public boolean isOpcional() {
        return opcional;
    }

    public void setOpcional(boolean opcional) {
        this.opcional = opcional;
    }

    @Override
    public String toString() {
        return "DetalleReceta{" + "id=" + id + ", receta=" + receta + ", opcional=" + opcional + '}';
    }

    /**
     * actualiza si es opcional o no.
     *
     * @param detalleRecetaRequest
     */
    void actualizar(DetalleReceta detalleRecetaRequest) {
        this.setOpcional(detalleRecetaRequest.isOpcional());
    }

}
