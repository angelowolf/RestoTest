/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorCategoriaReceta;
import Controlador.Interface.IControladorReceta;
import Modelo.CategoriaReceta;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class ControladorCategoriaReceta implements IControladorCategoriaReceta {

    private static final Logger LOGGER = Logger.getLogger(ControladorCategoriaReceta.class);

    @Override
    public int guardar(CategoriaReceta categoria) {
        return CATEGORIARECETADAO.guardar(categoria);
    }

    @Override
    public List<CategoriaReceta> getTodos() {
        return CATEGORIARECETADAO.getTodos();
    }

    @Override
    public CategoriaReceta getCategoria(int id) {
        return CATEGORIARECETADAO.buscar(id);
    }

    @Override
    public void actualizar(CategoriaReceta categoria) {
        CategoriaReceta categoriaEnBD = this.getCategoria(categoria.getId());
        categoriaEnBD.actualizar(categoria);
        CATEGORIARECETADAO.actualizar(categoriaEnBD);
    }

    @Override
    public void eliminar(CategoriaReceta categoria) {
        CATEGORIARECETADAO.eliminar(categoria);
    }

    @Override
    public boolean nombreDisponible(CategoriaReceta categoria) {
        CategoriaReceta categoriaReceta = CATEGORIARECETADAO.buscar(categoria.getNombre());
        if (categoriaReceta == null) {
            return true;
        }
        return categoria.getId() == categoriaReceta.getId();
    }

    @Override
    public boolean enUso(CategoriaReceta categoria) {
        IControladorReceta cr = new ControladorReceta();
        return !cr.getTodosByCategoriaByNombre(categoria.getId(), null, false).isEmpty();
    }

    @Override
    public List<CategoriaReceta> buscar(String nombreFiltro) {
        if (StringUtils.isBlank(nombreFiltro)) {
            nombreFiltro = null;
        }
        return CATEGORIARECETADAO.buscarFiltro(nombreFiltro);
    }

}
