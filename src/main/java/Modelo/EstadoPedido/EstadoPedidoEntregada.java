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
public class EstadoPedidoEntregada extends EstadoPedido {

    private String nombre = "entregada";

    @Override
    public boolean esEntregada() {
        return true;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void cancelarPedido(Pedido pedido) {
        //logica de negocio y cambio de estado
//        pedido.setEstadoPedido(SingletonEstadoPedidoCancelada.getInstancia().getEstadoPedidoCancelada());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
