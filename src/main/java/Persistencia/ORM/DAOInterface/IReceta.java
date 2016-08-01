/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.InsumoBruto;
import Modelo.Receta;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IReceta extends IGenericDAO<Receta, Integer> {

    public List<Receta> getTodosByCategoriaByNombre(int idCategoria, String object, boolean activo);

    public Receta buscar(String nombre);

    public List<Receta> insumoEnUsoPorReceta(InsumoBruto insumo);
}
