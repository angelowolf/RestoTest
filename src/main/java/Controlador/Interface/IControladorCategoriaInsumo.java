/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.CategoriaInsumo;
import Persistencia.ORM.DAOImplementacion.CategoriaInsumoDAO;
import Persistencia.ORM.DAOInterface.ICategoriaInsumo;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorCategoriaInsumo {

    final ICategoriaInsumo CATEGORIAINSUMODAO = new CategoriaInsumoDAO();

    public int guardar(CategoriaInsumo categoria);

    public List<CategoriaInsumo> getTodos();

    public CategoriaInsumo getCategoria(int id);

    public void actualizar(CategoriaInsumo categoria);

    public void eliminar(CategoriaInsumo categoria);

    public boolean nombreDisponible(CategoriaInsumo categoria);

    public boolean enUso(CategoriaInsumo categoriaInsumo);

    public List<CategoriaInsumo> buscar(String nombreFiltro);

    public List<CategoriaInsumo> buscarTodos(String nombreFiltro);
}
