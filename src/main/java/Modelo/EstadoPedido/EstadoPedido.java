/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.EstadoPedido;

import Modelo.Pedido;

/**
 *
 * @author ang_2
 */
public abstract class EstadoPedido {

    protected int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    /**
     * SE TIENE QUE PONER ES, ya que si se le coloca IS, Struts al mapear el
     * objteo a JSON lo considerara como un atributo de la clase, Struts mapea
     * el json con los geters de la clase.
     *
     * @return true si es cancelada.
     */
    public boolean esCancelada() {
        return false;
    }

    public boolean esIniciada() {
        return false;
    }

    public boolean esPreparando() {
        return false;
    }

    public boolean esTerminada() {
        return false;
    }

    public boolean esRetirada() {
        return false;
    }

    public boolean esEntregada() {
        return false;
    }

    public abstract void cancelarPedido(Pedido pedido);

}
