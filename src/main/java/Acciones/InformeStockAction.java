/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorInsumo;
import Controlador.Implementacion.ControladorStock;
import Controlador.Interface.IControladorInsumo;
import Controlador.Interface.IControladorStock;
import Modelo.DetalleStock;
import Modelo.Insumo;
import Modelo.InsumoBruto;
import Modelo.TipoMovimiento;
import Soporte.InformeDateBasedData;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author ang_2
 */
public class InformeStockAction extends Accion implements ModelDriven<Insumo> {

    private static final Logger LOGGER = Logger.getLogger(InformeStockAction.class);
    private Insumo insumo;
    private final List<List> listaDatos;
    private final List<TipoMovimiento> movimientos;
    private final IControladorInsumo ci;
    private final IControladorStock cs;

    public InformeStockAction() {
        insumo = new InsumoBruto();
        cs = new ControladorStock();
        ci = new ControladorInsumo();
        movimientos = Arrays.asList(TipoMovimiento.values());
        listaDatos = new ArrayList();

    }

    public String ver() {
        insumo = ci.buscar(insumo.getId());
        return SUCCESS;
    }

    private List agregar(List<DetalleStock> l) {
        List temp = new ArrayList();
        for (DetalleStock detalleStock : l) {
            temp.add(new InformeDateBasedData(detalleStock.getF(), detalleStock.getTotal()));
        }
        return temp;
    }

    public String getMovimientoStock() {
        this.listaDatos.add(this.agregar(cs.getDetalles(insumo.getId())));
        this.listaDatos.add(this.agregar(cs.getDetalles(insumo.getId(), TipoMovimiento.Venta)));
        this.listaDatos.add(this.agregar(cs.getDetalles(insumo.getId(), TipoMovimiento.Reposicion)));
        this.listaDatos.add(this.agregar(cs.getDetalles(insumo.getId(), TipoMovimiento.Ajuste)));
        this.listaDatos.add(this.agregar(cs.getDetalles(insumo.getId(), TipoMovimiento.Confeccion)));
        return SUCCESS;
    }

    public List<List> getListaDatos() {
        return listaDatos;
    }

    public List<TipoMovimiento> getMovimientos() {
        return movimientos;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public Insumo getModel() {
        return insumo;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

}
