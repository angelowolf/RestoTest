/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorReceta;
import Modelo.DetalleReceta;
import Modelo.Ingrediente;
import Modelo.Receta;
import Soporte.CommonsUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class ControladorReceta implements IControladorReceta {

    private static final Logger LOGGER = Logger.getLogger(ControladorReceta.class);

    @Override
    public List<Receta> getTodosByCategoriaByNombre(int idCategoria, String nombre, boolean activo) {
        if (StringUtils.isBlank(nombre) || nombre.equals("undefined")) {
            LOGGER.info("2");
            return RECETADAO.getTodosByCategoriaByNombre(idCategoria, null, activo);
        } else {
            LOGGER.info("4");
            return RECETADAO.getTodosByCategoriaByNombre(idCategoria, WordUtils.capitalize(nombre), activo);
        }
    }

    @Override
    public void guardar(Receta receta, List<Integer> idsIngredientes, List<Float> cantidadesIngredientes, List<Integer> opcionalIngredientesID, List<Integer> idsRecetas, List<Integer> opcionalRecetasID) {
        Set<Ingrediente> ingredientesSeleccionados = new HashSet<>();
        Set<DetalleReceta> recetasSeleccionados = new HashSet<>();
        Map<Integer, Integer> mapOpcionalesIngredientes = CommonsUtil.listToHash(opcionalIngredientesID);
        Map<Integer, Integer> mapOpcionalesRecetas = CommonsUtil.listToHash(opcionalRecetasID);
        if (idsIngredientes != null && !idsIngredientes.isEmpty()) {
            for (int i = 0; i < idsIngredientes.size(); i++) {
                Ingrediente cadaIngrediente = new Ingrediente(cantidadesIngredientes.get(i), controladorInsumo.buscar(idsIngredientes.get(i)), mapOpcionalesIngredientes.containsKey(idsIngredientes.get(i)));
                ingredientesSeleccionados.add(cadaIngrediente);
            }
        }
        if (idsRecetas != null && !idsRecetas.isEmpty()) {
            for (int i = 0; i < idsRecetas.size(); i++) {
                DetalleReceta cadaReceta = new DetalleReceta(getReceta(idsRecetas.get(i)), mapOpcionalesRecetas.containsKey(idsRecetas.get(i)));
                recetasSeleccionados.add(cadaReceta);
            }
        }
        receta.nueva(ingredientesSeleccionados, recetasSeleccionados);
        RECETADAO.guardar(receta);
    }

    @Override
    public void actualizar(Receta receta, List<Integer> idsIngredientes, List<Float> cantidadesIngredientes, List<Integer> opcionalIngredientesID, List<Integer> idsRecetas, List<Integer> opcionalRecetasID) {
        Set<Ingrediente> ingredientesSeleccionados = new HashSet<>();
        Set<DetalleReceta> recetasSeleccionados = new HashSet<>();
        Map<Integer, Integer> mapOpcionalesIngredientes = CommonsUtil.listToHash(opcionalIngredientesID);
        Map<Integer, Integer> mapOpcionalesRecetas = CommonsUtil.listToHash(opcionalRecetasID);
        if (idsIngredientes != null && !idsIngredientes.isEmpty()) {
            for (int i = 0; i < idsIngredientes.size(); i++) {
                Ingrediente cadaIngrediente = new Ingrediente(cantidadesIngredientes.get(i), controladorInsumo.buscar(idsIngredientes.get(i)), mapOpcionalesIngredientes.containsKey(idsIngredientes.get(i)));
                ingredientesSeleccionados.add(cadaIngrediente);
            }
        }
        if (idsRecetas != null && !idsRecetas.isEmpty()) {
            for (int i = 0; i < idsRecetas.size(); i++) {
                DetalleReceta cadaReceta = new DetalleReceta(getReceta(idsRecetas.get(i)), mapOpcionalesRecetas.containsKey(idsRecetas.get(i)));
                recetasSeleccionados.add(cadaReceta);
            }
        }
        Receta recetaEnBD = getReceta(receta.getId());
        recetaEnBD.actualizar(receta, ingredientesSeleccionados, recetasSeleccionados);
        RECETADAO.actualizar(recetaEnBD);
    }

    @Override
    public Receta getReceta(int id) {
        return RECETADAO.buscar(id);
    }

    @Override
    public boolean nombreDisponible(Receta receta) {
        Receta recetaBD = RECETADAO.buscar(receta.getNombre());
        if (recetaBD == null) {
            return true;
        }
        return recetaBD.getId() == receta.getId();
    }

    @Override
    public void eliminar(Receta receta) {
        Receta recetaBD = this.getReceta(receta.getId());
        recetaBD.darDeBaja();
        RECETADAO.actualizar(recetaBD);
    }

}
