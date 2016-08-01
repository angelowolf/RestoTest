/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.EstadoPedido.EstadoPedido;
import Modelo.EstadoPedido.SingletonEstadoPedidoIniciada;

/**
 *
 * @author ang_2
 */
public class Pedido {

    private EstadoPedido estadoPedido;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    /**
     * indica si el pedido es cancelado. SE TIENE QUE PONER ES, ya que si se le
     * coloca IS, Struts al mapear el objteo a JSON lo considerara como un
     * atributo de la clase, Struts mapea el json con los geters de la clase.
     *
     *
     * @return
     */
    public boolean esCancelada() {
        return this.estadoPedido.esCancelada();
    }

    public boolean esIniciada() {
        return this.estadoPedido.esIniciada();
    }

    public boolean esPreparando() {
        return this.estadoPedido.esPreparando();
    }

    public boolean esTerminada() {
        return this.estadoPedido.esTerminada();
    }

    public boolean esRetirada() {
        return this.estadoPedido.esRetirada();
    }

    public boolean esEntregada() {
        return this.estadoPedido.esEntregada();
    }

    public void registrarCancelacion() {
        this.estadoPedido.cancelarPedido(this);
    }

    public void crearPedido() {
        this.setEstadoPedido(SingletonEstadoPedidoIniciada.getInstancia().getEstadoPedidoIniciada());
    }
}
