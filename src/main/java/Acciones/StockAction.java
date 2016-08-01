/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorCategoriaInsumo;
import Controlador.Implementacion.ControladorInsumo;
import Controlador.Implementacion.ControladorInsumoBruto;
import Controlador.Implementacion.ControladorStock;
import Controlador.Interface.IControladorCategoriaInsumo;
import Controlador.Interface.IControladorInsumo;
import Controlador.Interface.IControladorStock;
import Modelo.CategoriaInsumo;
import java.util.ArrayList;
import java.util.List;
import Controlador.Interface.IControladorInsumoBruto;
import Modelo.Insumo;
import Modelo.InsumoBruto;

/**
 *
 * @author ang_2
 */
public class StockAction extends Accion {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(StockAction.class);
    private List<InsumoBruto> lista;
    private List<Insumo> listaTodos;
    private List<CategoriaInsumo> categorias;
    private final IControladorStock controladorStock;
    private final IControladorInsumoBruto controladorInsumoBruto;
    private final IControladorInsumo controladorInsumo;
    private final IControladorCategoriaInsumo controladorCategoriaInsumo;

    private List<Integer> ids;
    private List<Float> cantidad;
    private List<Float> precio;

    public StockAction() {
        controladorCategoriaInsumo = new ControladorCategoriaInsumo();
        controladorInsumoBruto = new ControladorInsumoBruto();
        controladorInsumo = new ControladorInsumo();
        controladorStock = new ControladorStock();
        lista = new ArrayList<>();
        categorias = new ArrayList<>();
    }

    public String getListaCompra() {
        lista = controladorInsumoBruto.getTodosStockMinimo();
        return SUCCESS;
    }

    public String getCargarCompra() {
        lista = controladorInsumoBruto.getTodosStockMinimo();
        categorias = controladorCategoriaInsumo.getTodos();
        return SUCCESS;
    }

    public void validatePostCargarCompra() {
        if (ids == null || ids.isEmpty()) {
            addActionError(mensajes.SELECCIONEINSUMO);
        } else {
            if (cantidad == null || cantidad.isEmpty()) {
                addActionError(mensajes.INGRESECANTIDADCOMPRADA);
            } else {
                for (Float cadaCantidad : cantidad) {
                    if (cadaCantidad == null) {
                        addActionError(mensajes.INGRESECANTIDADCOMPRADA);
                        break;
                    }
                }
            }
            if (precio == null || precio.isEmpty()) {
                addActionError(mensajes.INGRESEPRECIO);
            } else {
                for (Float cadaPrecio : precio) {
                    if (cadaPrecio == null) {
                        addActionError(mensajes.INGRESEPRECIO);
                        break;
                    }
                }
            }
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    public String postCargarCompra() {
        controladorStock.registrarCompraInsumoBruto(ids, cantidad, precio);
        sesion.put("mensaje", mensajes.COMPRAREGISTRADA);
        return SUCCESS;
    }

    public void validatePostAjusteStock() {
        if (ids == null || ids.isEmpty()) {
            addActionError(mensajes.SELECCIONEINSUMO);
        } else if (cantidad == null || cantidad.isEmpty()) {
            addActionError(mensajes.INGRESECANTIDADAJUSTADA);
        } else {
            for (Float integer : cantidad) {
                if (integer == null) {
                    addActionError(mensajes.INGRESECANTIDADAJUSTADA);
                    break;
                }
            }
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    public String postAjusteStock() {
        controladorStock.registrarAjuste(ids, cantidad);
        sesion.put("mensaje", mensajes.AJUSTEREALIZADO);
        return SUCCESS;
    }

    public String getAjusteStock() {
        listaTodos = controladorInsumo.getTodos(true);
        categorias = controladorCategoriaInsumo.getTodos();
        return SUCCESS;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    public List<InsumoBruto> getLista() {
        return lista;
    }

    public List<Insumo> getListaTodos() {
        return listaTodos;
    }

    public List<CategoriaInsumo> getCategorias() {
        return categorias;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public void setCantidad(List<Float> cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(List<Float> precio) {
        this.precio = precio;
    }

}
