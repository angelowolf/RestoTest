/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.EstadoPedido;

import Persistencia.ORM.DAOImplementacion.EstadoPedidoDAO;

/**
 *
 * @author ang_2
 */
public class SingletonEstadoPedidoEntregada {

    private static SingletonEstadoPedidoEntregada singleton;
    private static EstadoPedido estado;

    private SingletonEstadoPedidoEntregada() {
        EstadoPedidoDAO estadoPedidoDAO = new EstadoPedidoDAO();
        estado = estadoPedidoDAO.buscar("entregada");
    }

    public EstadoPedido getEstadoPedidoEntregada() {
        return estado;
    }

    public static SingletonEstadoPedidoEntregada getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoPedidoEntregada();
        }
        return singleton;
    }
}
