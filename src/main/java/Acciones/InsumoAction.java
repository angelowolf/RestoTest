/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorInsumo;
import Controlador.Interface.IControladorInsumo;
import Modelo.Insumo;
import Modelo.InsumoBruto;
import Soporte.AutoComplete;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class InsumoAction extends Accion implements ModelDriven<Insumo> {

    private static final Logger LOGGER = Logger.getLogger(InsumoAction.class);
    private final IControladorInsumo controladorInsumo = new ControladorInsumo();
    private List<Insumo> lista;
    private List<AutoComplete> listaAC;
    private String term;
    private Insumo insumo;

    public InsumoAction() {
        insumo = new InsumoBruto();
        lista = new ArrayList<>();
        listaAC = new ArrayList<>();
    }

    public String listar() {
        lista = controladorInsumo.getTodos(true);
        return SUCCESS;
    }

    public String postBuscarInsumo() {
        insumo = controladorInsumo.buscar(insumo.getId());
        LOGGER.info("POST");
        return SUCCESS;
    }

    public String postBuscarInsumoAutoComplete() {
        listaAC = new ArrayList<>();
        lista = controladorInsumo.getTodosByCategoriaByNombreSinEstos(-1, term, null, true);
        for (Insumo cadaInsumo : lista) {
            listaAC.add(AutoComplete.generarAC(cadaInsumo));
        }
        LOGGER.info("AC");
        return SUCCESS;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Insumo> getLista() {
        return lista;
    }

    public List<AutoComplete> getListaAC() {
        return listaAC;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Insumo getModel() {
        return insumo;
    }

}
