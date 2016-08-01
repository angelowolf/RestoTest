/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorCategoriaInsumo;
import Controlador.Implementacion.ControladorInsumoBruto;
import Controlador.Interface.IControladorCategoriaInsumo;
import Modelo.CategoriaInsumo;
import Modelo.Insumo;
import Modelo.InsumoBruto;
import Modelo.UnidadMedida;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import Controlador.Interface.IControladorInsumoBruto;
import Soporte.AutoComplete;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

/**
 *
 * @author ang_2
 */
public class InsumoBrutoAction extends Accion implements ModelDriven<Insumo>, CRUD {

    private static final Logger LOGGER = Logger.getLogger(InsumoBrutoAction.class);

    private InsumoBruto insumo;
    private final IControladorInsumoBruto controladorInsumo;
    private List<InsumoBruto> lista;
    private final List<CategoriaInsumo> categorias;
    private final List<UnidadMedida> unidades;
    private int categoriaInsumoFiltro;

    private List<AutoComplete> listaAC;
    private int idCategoria;
    private String nombreInsumo, term;
    private List<Integer> ids;

    public InsumoBrutoAction() {
        unidades = Arrays.asList(UnidadMedida.values());
        IControladorCategoriaInsumo controladorCategoriaInsumo = new ControladorCategoriaInsumo();
        categorias = controladorCategoriaInsumo.getTodos();
        lista = new ArrayList<>();
        ids = new ArrayList<>();
        insumo = new InsumoBruto();
        controladorInsumo = new ControladorInsumoBruto();
    }

    public String postBuscarInsumo() {
        lista = controladorInsumo.getTodosByCategoriaByNombreSinEstos(idCategoria, nombreInsumo, ids, true);
        return SUCCESS;
    }

    public String postBuscarInsumoBrutoAutoComplete() {
        listaAC = new ArrayList<>();
        lista = controladorInsumo.getTodosByCategoriaByNombreSinEstos(-1, term, null, true);
        for (InsumoBruto insumoBruto : lista) {
            listaAC.add(AutoComplete.generarAC(insumoBruto));
        }
        return SUCCESS;
    }

    @Override
    public String getModificar() {
        insumo = controladorInsumo.getInsumo(insumo.getId());
        return SUCCESS;
    }

    public void validatePostModificar() {
        if (StringUtils.isBlank(insumo.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorInsumo.nombreDisponible(insumo)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (insumo.getUnidadMedida() == null) {
            addFieldError("unidad", mensajes.SELECCIONEUNIDADMEDIDA);
        }
        if (insumo.getPrecioUnidad() <= 0) {
            addFieldError("precioUnidad", mensajes.INGRESEVALORPOSITIVO);
        }
        if (insumo.getStock().getCantidadActual() < 0) {
            addFieldError("stock.cantidadActual", mensajes.INGRESEVALORPOSITIVO);
        }
        if (insumo.getStock().getCantidadMinima() < 0) {
            addFieldError("stock.cantidadMinima", mensajes.INGRESEVALORPOSITIVO);
        }
        this.clearMessages();
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String postModificar() {
        controladorInsumo.actualizar(insumo);
        sesion.put("mensaje", mensajes.getModificado(mensajes.INSUMO));
        return SUCCESS;
    }

    public void validateRegistrar() {
        if (insumo.getCategoriaInsumo().getId() == -1) {
            addFieldError("categoriaInsumo.id", mensajes.SELECCIONECATEGORIAINSUMO);
        }
        if (StringUtils.isBlank(insumo.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorInsumo.nombreDisponible(insumo)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (insumo.getUnidadMedida() == null) {
            addFieldError("unidad", mensajes.OBLIGATORIO);
        }
        if (insumo.getPrecioUnidad() < 0) {
            addFieldError("precioUnidad", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumo.getPrecioUnidad() == 0) {
            addFieldError("precioUnidad", mensajes.OBLIGATORIO);
        }

        if (insumo.getStock().getCantidadActual() < 0) {
            addFieldError("stock.cantidadActual", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumo.getStock().getCantidadActual() == 0) {
            addFieldError("stock.cantidadActual", mensajes.OBLIGATORIO);
        }

        if (insumo.getStock().getCantidadMinima() < 0) {
            addFieldError("stock.cantidadMinima", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumo.getStock().getCantidadMinima() == 0) {
            addFieldError("stock.cantidadMinima", mensajes.OBLIGATORIO);
        }
        this.clearMessages();
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String registrar() {
        controladorInsumo.guardar(insumo);
        sesion.put("mensaje", mensajes.getAgregado(mensajes.INSUMO));
        return SUCCESS;
    }

    public void validateEliminar() {
        switch (controladorInsumo.enUso(insumo)) {
            case 1:
                addActionError(mensajes.getUsadoPorUnAmbos(mensajes.INSUMO, mensajes.INSUMOELABORADO));
                break;
            case 2:
                addActionError(mensajes.getUsadoPorUnaAmbos(mensajes.INSUMO, mensajes.RECETA));
                break;
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String eliminar() {
        controladorInsumo.eliminar(insumo);
        sesion.put("mensaje", mensajes.getBajo(mensajes.INSUMO));
        return SUCCESS;
    }

    public String recuperar() {
        controladorInsumo.recuperar(insumo);
        sesion.put("mensaje", mensajes.getRecuperado(mensajes.INSUMO));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = controladorInsumo.buscar(nombreFiltro, categoriaInsumoFiltro);
        return SUCCESS;
    }

    public List<CategoriaInsumo> getCategorias() {
        return categorias;
    }

    public List<InsumoBruto> getLista() {
        return lista;
    }

    public InsumoBruto getInsumo() {
        return insumo;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public void setInsumo(InsumoBruto insumo) {
        this.insumo = insumo;
    }

    public List<UnidadMedida> getUnidades() {
        return unidades;
    }

    public int getCategoriaInsumoFiltro() {
        return categoriaInsumoFiltro;
    }

    public void setCategoriaInsumoFiltro(int categoriaInsumoFiltro) {
        this.categoriaInsumoFiltro = categoriaInsumoFiltro;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Insumo getModel() {
        return insumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<AutoComplete> getListaAC() {
        return listaAC;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
