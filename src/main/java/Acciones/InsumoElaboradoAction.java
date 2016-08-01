/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorInsumoElaborado;
import Controlador.Interface.IControladorInsumoElaborado;
import Modelo.InsumoElaborado;
import Modelo.UnidadMedida;
import Soporte.AutoComplete;
import Soporte.InsumoBrutoVista;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author ang_2
 */
public class InsumoElaboradoAction extends Accion implements ModelDriven<InsumoElaborado>, CRUD {

    private InsumoElaborado insumoElaborado;
    private List<InsumoElaborado> lista;
    private final IControladorInsumoElaborado controladorInsumoElaborado;
    private final List<UnidadMedida> unidades;
    private String term;
    private List<AutoComplete> listaAC;
    private List<Integer> idUtilizar;
    private List<Float> cantidadUtilizar;
    private List<InsumoBrutoVista> brutos;
    private float cantidadConfeccionarInsumo;

    public InsumoElaboradoAction() {
        unidades = Arrays.asList(UnidadMedida.values());
        insumoElaborado = new InsumoElaborado();
        lista = new ArrayList<>();
        controladorInsumoElaborado = new ControladorInsumoElaborado();
    }

    public void validateConfeccionar() {
        if (cantidadConfeccionarInsumo <= 0) {
            addFieldError("cantidadConfeccionarInsumo", mensajes.INGRESECANTIDADCONFECCIONAR);
            codigo = 400;
        }

    }

    public String confeccionar() {
        controladorInsumoElaborado.confeccionar(insumoElaborado, cantidadConfeccionarInsumo);
        sesion.put("mensaje", mensajes.CONFECCIONREGISTRADA);
        return SUCCESS;
    }

    public String postBuscarInsumoElaboradoAutoComplete() {
        listaAC = new ArrayList<>();
        lista = controladorInsumoElaborado.buscar(term);
        for (InsumoElaborado cadaInsumo : lista) {
            listaAC.add(AutoComplete.generarAC(cadaInsumo));
        }
        return SUCCESS;
    }

    @Override
    public String getModificar() {
        insumoElaborado = controladorInsumoElaborado.getInsumo(insumoElaborado.getId());
        return SUCCESS;
    }

    public void validatePostModificar() {
        if (StringUtils.isBlank(insumoElaborado.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorInsumoElaborado.nombreDisponible(insumoElaborado)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (insumoElaborado.getUnidadMedida() == null) {
            addFieldError("unidad", mensajes.OBLIGATORIO);
        }
        if (insumoElaborado.getStock().getCantidadMinima() < 0) {
            addFieldError("stock.cantidadMinima", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumoElaborado.getStock().getCantidadMinima() == 0) {
            addFieldError("stock.cantidadMinima", mensajes.OBLIGATORIO);
        }

        if (idUtilizar == null || idUtilizar.isEmpty()) {
            addActionError(mensajes.INGRESEINSUMO);
        } else if (cantidadUtilizar == null || cantidadUtilizar.isEmpty()) {
            addActionError(mensajes.INGRESECANTIDADCOMPRADA);
        } else {
            for (Float cadaCantidad : cantidadUtilizar) {
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
    public String postModificar() {
        controladorInsumoElaborado.actualizar(insumoElaborado, idUtilizar, cantidadUtilizar);
        sesion.put("mensaje", mensajes.getModificado(mensajes.INSUMOELABORADO));
        return SUCCESS;
    }

    public void validateRegistrar() {

        if (StringUtils.isBlank(insumoElaborado.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        } else if (!controladorInsumoElaborado.nombreDisponible(insumoElaborado)) {
            addFieldError("nombre", mensajes.getExiste(mensajes.NOMBRE));
        }
        if (insumoElaborado.getUnidadMedida() == null) {
            addFieldError("unidad", mensajes.OBLIGATORIO);
        }
        if (insumoElaborado.getStock().getCantidadActual() < 0) {
            addFieldError("stock.cantidadActual", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumoElaborado.getStock().getCantidadActual() == 0) {
            addFieldError("stock.cantidadActual", mensajes.OBLIGATORIO);
        }
        if (insumoElaborado.getStock().getCantidadMinima() < 0) {
            addFieldError("stock.cantidadMinima", mensajes.INGRESEVALORPOSITIVO);
        } else if (insumoElaborado.getStock().getCantidadMinima() == 0) {
            addFieldError("stock.cantidadMinima", mensajes.OBLIGATORIO);
        }

        if (idUtilizar == null || idUtilizar.isEmpty()) {
            addActionError(mensajes.INGRESEINSUMO);
        } else if (cantidadUtilizar == null || cantidadUtilizar.isEmpty()) {
            addActionError(mensajes.INGRESECANTIDADCOMPRADA);
        } else {
            for (Float cadaCantidad : cantidadUtilizar) {
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
    public String registrar() {
        controladorInsumoElaborado.guardar(insumoElaborado, idUtilizar, cantidadUtilizar);
        sesion.put("mensaje", mensajes.getAgregado(mensajes.INSUMOELABORADO));
        return SUCCESS;
    }

    @Override
    public String eliminar() {
        controladorInsumoElaborado.eliminar(insumoElaborado);
        sesion.put("mensaje", mensajes.getBajo(mensajes.INSUMOELABORADO));
        return SUCCESS;
    }

    public String recuperar() {
        controladorInsumoElaborado.recuperar(insumoElaborado);
        sesion.put("mensaje", mensajes.getRecuperado(mensajes.INSUMOELABORADO));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = controladorInsumoElaborado.buscar(nombreFiltro);
        return SUCCESS;
    }
    
    public InsumoElaborado getInsumoElaborado() {
        return insumoElaborado;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public void setInsumoElaborado(InsumoElaborado insumoElaborado) {
        this.insumoElaborado = insumoElaborado;
    }

    public List<InsumoElaborado> getLista() {
        return lista;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public InsumoElaborado getModel() {
        return insumoElaborado;
    }

    public List<UnidadMedida> getUnidades() {
        return unidades;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<AutoComplete> getListaAC() {
        return listaAC;
    }

    public void setIdUtilizar(List<Integer> idUtilizar) {
        this.idUtilizar = idUtilizar;
    }

    public void setCantidadUtilizar(List<Float> cantidadUtilizar) {
        this.cantidadUtilizar = cantidadUtilizar;
    }

    public void setCantidadConfeccionarInsumo(float cantidadConfeccionarInsumo) {
        this.cantidadConfeccionarInsumo = cantidadConfeccionarInsumo;
    }

    public List<InsumoBrutoVista> getBrutos() {
        return brutos;
    }

}
