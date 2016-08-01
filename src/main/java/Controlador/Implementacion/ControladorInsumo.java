/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorInsumo;
import Modelo.Insumo;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class ControladorInsumo implements IControladorInsumo {

    private static final Logger LOGGER = Logger.getLogger(ControladorInsumo.class);

    @Override
    public List<Insumo> getTodos(boolean activo) {
        return INSUMODAO.getTodos(activo);
    }

    @Override
    public List<Insumo> getTodosByCategoriaByNombreSinEstos(int idCategoria, String nombre, List<Integer> ids, boolean activo) {
        if (StringUtils.isBlank(nombre) || nombre.equals("undefined")) {
            LOGGER.info("2");
            return INSUMODAO.getTodosByCategoriaByNombre(idCategoria, null, ids, activo);
        } else {
            LOGGER.info("4");
            return INSUMODAO.getTodosByCategoriaByNombre(idCategoria, WordUtils.capitalize(nombre), ids, activo);
        }
    }

    @Override
    public Insumo buscar(int id) {
        return INSUMODAO.buscar(id);
    }

}
