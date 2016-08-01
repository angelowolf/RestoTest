/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Pedido;
import Persistencia.ORM.DAOImplementacion.PedidoDAO;
import Persistencia.ORM.DAOInterface.IPedido;

/**
 *
 * @author ang_2
 */
public interface IControladorPedido {

    final IPedido PEDIDODAO = new PedidoDAO();

    public int guardar(Pedido p);
}
