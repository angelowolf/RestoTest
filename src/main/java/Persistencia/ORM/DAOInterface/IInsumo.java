/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.Insumo;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IInsumo extends IGenericDAO<Insumo, Integer> {

    public List<Insumo> getTodos(boolean activo);

    public List<Insumo> getTodosByCategoriaByNombre(int idCategoria, String nombre, List<Integer> ids, boolean activo);

}
