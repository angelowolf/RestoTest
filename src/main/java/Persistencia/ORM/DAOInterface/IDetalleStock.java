/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.DetalleStock;
import Modelo.TipoMovimiento;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IDetalleStock extends IGenericDAO<DetalleStock, Integer> {

    /**
     * Busca toodos los movimientos de stock para un insumo, y un tipo de
     * movimiento, si el tipo de movimiento es null busca TODOS.
     *
     * @param id
     * @param tm
     * @return
     */
    public List<DetalleStock> getTodos(int id, TipoMovimiento tm);

}
