/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorCategoriaReceta;
import Controlador.Interface.IControladorCategoriaReceta;
import Modelo.CategoriaReceta;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class CategoriaRecetaAction extends Accion implements ModelDriven<CategoriaReceta>, CRUD {

    private List<CategoriaReceta> lista;
    private CategoriaReceta categoria;
    private final IControladorCategoriaReceta ccr;

    public CategoriaRecetaAction() {
        lista = new ArrayList<>();
        categoria = new CategoriaReceta();
        ccr = new ControladorCategoriaReceta();
    }

    @Override
    public String getModificar() {
        categoria = ccr.getCategoria(categoria.getId());
        return SUCCESS;
    }

    public void validar() {
        if (StringUtils.isBlank(categoria.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!ccr.nombreDisponible(categoria)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    public void valdiatePostModificar() {
        this.validar();
    }

    @Override
    public String postModificar() {
        ccr.actualizar(categoria);
        sesion.put("mensaje", mensajes.getModificada(mensajes.CATEGORIARECETA));
        return SUCCESS;
    }

    public void validateRegistrar() {
        this.validar();
    }

    @Override
    public String registrar() {
        ccr.guardar(categoria);
        sesion.put("mensaje", mensajes.getAgregada(mensajes.CATEGORIAINSUMO));
        return SUCCESS;
    }

    public void validateEliminar() {
        if (ccr.enUso(categoria)) {
            addActionError(mensajes.getUsadaPorUnDesvincular(mensajes.CATEGORIARECETA, mensajes.RECETA));
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String eliminar() {
        ccr.eliminar(categoria);
        sesion.put("mensaje", mensajes.getEliminada(mensajes.CATEGORIARECETA));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = ccr.buscar(nombreFiltro);
        return SUCCESS;
    }

    @Override
    public CategoriaReceta getModel() {
        return categoria;
    }

    public List<CategoriaReceta> getLista() {
        return lista;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public CategoriaReceta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaReceta categoria) {
        this.categoria = categoria;
    }

}
