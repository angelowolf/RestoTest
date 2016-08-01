/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.CategoriaReceta;
import Persistencia.ORM.DAOImplementacion.CategoriaRecetaDAO;
import Persistencia.ORM.DAOInterface.ICategoriaReceta;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorCategoriaReceta {

    final ICategoriaReceta CATEGORIARECETADAO = new CategoriaRecetaDAO();

    public int guardar(CategoriaReceta categoria);

    public List<CategoriaReceta> getTodos();

    public CategoriaReceta getCategoria(int id);

    public void actualizar(CategoriaReceta categoria);

    public void eliminar(CategoriaReceta categoria);

    public boolean nombreDisponible(CategoriaReceta categoria);

    public boolean enUso(CategoriaReceta categoriaInsumo);

    public List<CategoriaReceta> buscar(String nombreFiltro);

}
