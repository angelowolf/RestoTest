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
public class SingletonEstadoPedidoCancelada {

    private static SingletonEstadoPedidoCancelada singleton;
    private static EstadoPedido estado;

    private SingletonEstadoPedidoCancelada() {
        EstadoPedidoDAO estadoPedidoDAO = new EstadoPedidoDAO();
        estado = estadoPedidoDAO.buscar("cancelada");
    }

    public EstadoPedido getEstadoPedidoCancelada() {
        return estado;
    }

    public static SingletonEstadoPedidoCancelada getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoPedidoCancelada();
        }
        return singleton;
    }
}
