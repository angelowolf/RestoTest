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
public class SingletonEstadoPedidoIniciada {

    private static SingletonEstadoPedidoIniciada singleton;
    private static EstadoPedido estado;

    private SingletonEstadoPedidoIniciada() {
        EstadoPedidoDAO estadoPedidoDAO = new EstadoPedidoDAO();
        estado = estadoPedidoDAO.buscar("iniciada");
    }

    public EstadoPedido getEstadoPedidoIniciada() {
        return estado;
    }

    public static SingletonEstadoPedidoIniciada getInstancia() {
        if (singleton == null) {
            singleton = new SingletonEstadoPedidoIniciada();
        }
        return singleton;
    }
}
