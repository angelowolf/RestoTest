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
public class SingletonEstadoPedidoRetirada {

    private static SingletonEstadoPedidoRetirada singleton;
    private static EstadoPedido estado;

    private SingletonEstadoPedidoRetirada() {
        EstadoPedidoDAO estadoPedidoDAO = new EstadoPedidoDAO();
        estado = estadoPedidoDAO.buscar("retirada");
    }

    public EstadoPedido getEstadoPedidoRetirada() {
        return estado;
    }

    public static SingletonEstadoPedidoRetirada getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoPedidoRetirada();
        }
        return singleton;
    }
}
