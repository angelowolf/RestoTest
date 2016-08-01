/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorCategoriaInsumo;
import Controlador.Interface.IControladorCategoriaInsumo;
import Modelo.CategoriaInsumo;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class CategoriaInsumoAction extends Accion implements ModelDriven<CategoriaInsumo>, CRUD {

    private static final Logger LOGGER = Logger.getLogger(CategoriaInsumoAction.class);

    private CategoriaInsumo categoriaInsumo;
    private final IControladorCategoriaInsumo controladorCategoriaInsumo;
    private List<CategoriaInsumo> lista;

    public CategoriaInsumoAction() {
        lista = new ArrayList<>();
        categoriaInsumo = new CategoriaInsumo();
        controladorCategoriaInsumo = new ControladorCategoriaInsumo();
    }

    @Override
    public String getModificar() {
        categoriaInsumo = controladorCategoriaInsumo.getCategoria(categoriaInsumo.getId());
        return SUCCESS;
    }

    public void validar() {
        if (StringUtils.isBlank(categoriaInsumo.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorCategoriaInsumo.nombreDisponible(categoriaInsumo)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    public void validatePostModificar() {
        this.validar();
    }

    @Override
    public String postModificar() {
        controladorCategoriaInsumo.actualizar(categoriaInsumo);
        sesion.put("mensaje", mensajes.getModificada(mensajes.CATEGORIAINSUMO));
        return SUCCESS;
    }

    public void validateRegistrar() {
        this.validar();
    }

    @Override
    public String registrar() {
        controladorCategoriaInsumo.guardar(categoriaInsumo);
        sesion.put("mensaje", mensajes.getAgregada(mensajes.CATEGORIAINSUMO));
        return SUCCESS;
    }

    public void validateEliminar() {
        if (controladorCategoriaInsumo.enUso(categoriaInsumo)) {
            addActionError(mensajes.getUsadaPorUnDesvincular(mensajes.CATEGORIAINSUMO, mensajes.INSUMO));
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String eliminar() {
        controladorCategoriaInsumo.eliminar(categoriaInsumo);
        sesion.put("mensaje", mensajes.getEliminada(mensajes.CATEGORIAINSUMO));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = controladorCategoriaInsumo.buscar(nombreFiltro);
        return SUCCESS;
    }

    public List<CategoriaInsumo> getLista() {
        return lista;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public CategoriaInsumo getCategoriaInsumo() {
        return categoriaInsumo;
    }

    public void setCategoriaInsumo(CategoriaInsumo categoriaInsumo) {
        this.categoriaInsumo = categoriaInsumo;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public CategoriaInsumo getModel() {
        return categoriaInsumo;
    }

}
