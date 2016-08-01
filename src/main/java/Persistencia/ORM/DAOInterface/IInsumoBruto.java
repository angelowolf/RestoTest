/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.InsumoBruto;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IInsumoBruto extends IGenericDAO<InsumoBruto, Integer> {

    /**
     * busca todos los insumos brutos que esten activos y por debajo del minimo.
     *
     * @return
     */
    public List<InsumoBruto> getTodosStockMinimo();

    public List<InsumoBruto> getTodosByCategoriaByNombreSinEstos(int idCategoria, String capitalize, List<Integer> ids, boolean activo);

    public InsumoBruto buscar(String nombre);

}
