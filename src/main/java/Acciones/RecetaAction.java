/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorCategoriaReceta;
import Controlador.Implementacion.ControladorReceta;
import Controlador.Interface.IControladorCategoriaReceta;
import Controlador.Interface.IControladorReceta;
import Modelo.CategoriaReceta;
import Modelo.Receta;
import Soporte.AutoComplete;
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
public class RecetaAction extends Accion implements ModelDriven<Receta>, CRUD {

    private static final Logger LOGGER = Logger.getLogger(RecetaAction.class);
    private final IControladorCategoriaReceta controladorCategoriaReceta;
    private final IControladorReceta controladorReceta;
    private Receta receta;

    private List<Integer> idsIngredientes;
    private List<Float> cantidadesIngredientes;
    private List<Integer> opcionalIngredientesID;
    private List<Integer> idsRecetas;
    private List<Integer> opcionalRecetasID;

    private final List<CategoriaReceta> categorias;
    private List<Receta> lista;
    private List<AutoComplete> listaAC;
    private String term;
    private int categoriaRecetaFiltro;

    public RecetaAction() {
        controladorCategoriaReceta = new ControladorCategoriaReceta();
        controladorReceta = new ControladorReceta();
        lista = new ArrayList<>();
        categorias = controladorCategoriaReceta.getTodos();
        receta = new Receta();
    }

    public String postBuscarRecetaAutoComplete() {
        listaAC = new ArrayList<>();
        lista = controladorReceta.getTodosByCategoriaByNombre(-1, term, true);
        for (Receta cadaReceta : lista) {
            listaAC.add(AutoComplete.generarAC(cadaReceta));
        }
        return SUCCESS;
    }

    private void validar() {
        if (receta.getCategoriaReceta().getId() == -1) {
            addFieldError("categoriaReceta.id", mensajes.SELECCIONECATEGORIARECETA);
        }
        if (StringUtils.isBlank(receta.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorReceta.nombreDisponible(receta)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (idsIngredientes == null || idsIngredientes.isEmpty()) {
            addActionError(mensajes.INGRESEINSUMO);
        } else if (cantidadesIngredientes == null || cantidadesIngredientes.isEmpty()) {
            addActionError(mensajes.INGRESECANTIDADUTILIZAR);
        } else {
            for (Float cadaCantidad : cantidadesIngredientes) {
                if (cadaCantidad == null) {
                    addActionError(mensajes.INGRESECANTIDADUTILIZAR);
                    break;
                }
            }
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String getModificar() {
        receta = controladorReceta.getReceta(receta.getId());
        return SUCCESS;
    }

    public void validatePostModificar() {
        validar();
    }

    @Override
    public String postModificar() {
        controladorReceta.actualizar(receta, idsIngredientes, cantidadesIngredientes, opcionalIngredientesID, idsRecetas, opcionalRecetasID);
        sesion.put("mensaje", mensajes.getModificada(mensajes.RECETA));
        return SUCCESS;
    }

    public void validateRegistrar() {
        this.validar();
    }

    @Override
    public String registrar() {
        controladorReceta.guardar(receta, idsIngredientes, cantidadesIngredientes, opcionalIngredientesID, idsRecetas, opcionalRecetasID);
        sesion.put("mensaje", mensajes.getAgregada(mensajes.RECETA));
        return SUCCESS;
    }

    public void validateEliminar() {
        LOGGER.warn("VALIDAR AL ELIMINAR RECETA");
    }

    @Override
    public String eliminar() {
        controladorReceta.eliminar(receta);
        sesion.put("mensaje", mensajes.getBaja(mensajes.RECETA));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = controladorReceta.getTodosByCategoriaByNombre(categoriaRecetaFiltro, nombreFiltro, false);
        return SUCCESS;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Receta getModel() {
        return receta;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public List<CategoriaReceta> getCategorias() {
        return categorias;
    }

    public List<Receta> getLista() {
        return lista;
    }

    public List<AutoComplete> getListaAC() {
        return listaAC;
    }

    public void setIdsIngredientes(List<Integer> idsIngredientes) {
        this.idsIngredientes = idsIngredientes;
    }

    public void setCantidadesIngredientes(List<Float> cantidadesIngredientes) {
        this.cantidadesIngredientes = cantidadesIngredientes;
    }

    public void setOpcionalIngredientesID(List<Integer> opcionalIngredientesID) {
        this.opcionalIngredientesID = opcionalIngredientesID;
    }

    public void setIdsRecetas(List<Integer> idsRecetas) {
        this.idsRecetas = idsRecetas;
    }

    public void setOpcionalRecetasID(List<Integer> opcionalRecetasID) {
        this.opcionalRecetasID = opcionalRecetasID;
    }

    public int getCategoriaRecetaFiltro() {
        return categoriaRecetaFiltro;
    }

    public void setCategoriaRecetaFiltro(int categoriaRecetaFiltro) {
        this.categoriaRecetaFiltro = categoriaRecetaFiltro;
    }

}
