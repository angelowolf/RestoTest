/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.CategoriaReceta;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface ICategoriaReceta extends IGenericDAO<CategoriaReceta, Integer> {

    public List<CategoriaReceta> getTodos();

    public CategoriaReceta buscar(String nombre);

    public List<CategoriaReceta> buscarFiltro(String nombreFiltro);
}
