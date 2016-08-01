/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Controlador.Implementacion.ControladorInsumo;
import Modelo.Receta;
import Persistencia.ORM.DAOImplementacion.RecetaDAO;
import Persistencia.ORM.DAOInterface.IReceta;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorReceta {

    IReceta RECETADAO = new RecetaDAO();
    IControladorInsumo controladorInsumo = new ControladorInsumo();

    public List<Receta> getTodosByCategoriaByNombre(int idCategoria, String nombre, boolean activo);

    public void guardar(Receta receta, List<Integer> idsIngredientes, List<Float> cantidadesIngredientes, List<Integer> opcionalIngredientesID, List<Integer> idsRecetas, List<Integer> opcionalRecetasID);

    public Receta getReceta(int id);

    public boolean nombreDisponible(Receta receta);

    public void actualizar(Receta receta, List<Integer> idsIngredientes, List<Float> cantidadesIngredientes, List<Integer> opcionalIngredientesID, List<Integer> idsRecetas, List<Integer> opcionalRecetasID);

    public void eliminar(Receta receta);
}
