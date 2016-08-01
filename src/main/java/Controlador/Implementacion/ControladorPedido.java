/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorPedido;
import Modelo.Pedido;

/**
 *
 * @author ang_2
 */
public class ControladorPedido implements IControladorPedido {

    @Override
    public int guardar(Pedido p) {
        p.crearPedido();
        return PEDIDODAO.guardar(p);
    }

}
