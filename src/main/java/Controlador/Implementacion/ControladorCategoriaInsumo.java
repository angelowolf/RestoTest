/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorCategoriaInsumo;
import Modelo.CategoriaInsumo;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class ControladorCategoriaInsumo implements IControladorCategoriaInsumo {

    private static final Logger LOGGER = Logger.getLogger(ControladorCategoriaInsumo.class);

    @Override
    public int guardar(CategoriaInsumo categoriaInsumo) {
        return CATEGORIAINSUMODAO.guardar(categoriaInsumo);
    }

    @Override
    public List<CategoriaInsumo> getTodos() {
        return CATEGORIAINSUMODAO.getTodos();
    }

    @Override
    public CategoriaInsumo getCategoria(int id) {
        return CATEGORIAINSUMODAO.buscar(id);
    }

    @Override
    public void actualizar(CategoriaInsumo categoriaInsumo) {
        CategoriaInsumo categoriaEnBD = this.getCategoria(categoriaInsumo.getId());
        categoriaEnBD.actualizar(categoriaInsumo);
        CATEGORIAINSUMODAO.actualizar(categoriaEnBD);
    }

    @Override
    public void eliminar(CategoriaInsumo categoriaInsumo) {
        CATEGORIAINSUMODAO.eliminar(categoriaInsumo);
    }

    @Override
    public boolean nombreDisponible(CategoriaInsumo categoria) {
        CategoriaInsumo categoriaInsumo = CATEGORIAINSUMODAO.buscar(categoria.getNombre());
        if (categoriaInsumo == null) {
            return true;
        }
        return categoria.getId() == categoriaInsumo.getId();
    }

    @Override
    public boolean enUso(CategoriaInsumo categoriaInsumo) {
        return !CATEGORIAINSUMODAO.categoriaInsumosEnUso(categoriaInsumo).isEmpty();
    }

    @Override
    public List<CategoriaInsumo> buscar(String nombreFiltro) {
        if (StringUtils.isBlank(nombreFiltro)) {
            nombreFiltro = null;
        }
        return CATEGORIAINSUMODAO.buscarFiltro(nombreFiltro);
    }

    @Override
    public List<CategoriaInsumo> buscarTodos(String nombreFiltro) {
        if (StringUtils.isBlank(nombreFiltro)) {
            nombreFiltro = null;
        }
        return CATEGORIAINSUMODAO.buscarFiltroTodos(nombreFiltro);
    }

}
