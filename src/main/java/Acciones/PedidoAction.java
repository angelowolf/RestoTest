/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorPedido;
import Controlador.Interface.IControladorPedido;
import Modelo.Pedido;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang_2
 */
public class PedidoAction extends Accion implements ModelDriven<Pedido> {

    private Pedido pedido;
    private final IControladorPedido controladorPedido;

    public PedidoAction() {
        controladorPedido = new ControladorPedido();
        pedido = new Pedido();
    }

    public String test() {
        controladorPedido.guardar(pedido);
        return SUCCESS;
        }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Pedido getModel() {
        return pedido;
    }

}
