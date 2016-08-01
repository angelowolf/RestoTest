/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.CategoriaInsumo;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface ICategoriaInsumo extends IGenericDAO<CategoriaInsumo, Integer> {

    public List<CategoriaInsumo> getTodos();

    public CategoriaInsumo buscar(String nombre);

    public List<CategoriaInsumo> categoriaInsumosEnUso(CategoriaInsumo categoriaInsumo);

    public List<CategoriaInsumo> buscarFiltro(String nombreFiltro);

    public List<CategoriaInsumo> buscarFiltroTodos(String nombreFiltro);
}
