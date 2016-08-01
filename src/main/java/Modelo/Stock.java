/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Implementacion.ControladorNotificacion;
import java.util.HashSet;
import java.util.Set;
import org.joda.time.LocalDateTime;

/**
 *
 * @author ang_2
 */
public class Stock {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Stock.class);

    private int id;
    private float cantidadActual, cantidadMinima;
    private Set<DetalleStock> detalleStocks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<DetalleStock> getDetalleStocks() {
        return detalleStocks;
    }

    public void setDetalleStocks(Set<DetalleStock> detalleStocks) {
        this.detalleStocks = detalleStocks;
    }

    public float getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(float cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public float getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(float cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", cantidadActual=" + cantidadActual + ", cantidadMinima=" + cantidadMinima + '}';
    }

    /**
     * registra un descuento al stock del insumo y genera un detalle en el
     * historial.
     *
     * @param insumo
     * @param cantidadARestar cantidad positiva.
     */
    public void regitrarDescuento(Insumo insumo, float cantidadARestar) {
        this.cantidadActual -= cantidadARestar;
        DetalleStock venta = new DetalleStock(-cantidadARestar, cantidadActual, LocalDateTime.now(), TipoMovimiento.Venta);
        this.detalleStocks.add(venta);
        this.verificarStockBajo(insumo);
    }

    /**
     * registra una reposicion al stock del insumo y genera un detalle en el
     * historial.
     *
     * @param cantidadASumar cantidad positiva.
     */
    public void registrarReposicion(Insumo insumo, float cantidadASumar) {
        this.cantidadActual += cantidadASumar;
        DetalleStock aSumar = new DetalleStock(cantidadASumar, cantidadActual, LocalDateTime.now(), TipoMovimiento.Reposicion);
        this.detalleStocks.add(aSumar);
        this.verificarStockBajo(insumo);
    }

    /**
     * registra un ajuste al stock del insumo y genera un detalle en el
     * historial.
     *
     * @param insumo
     * @param cantidadAjuste positivo o negativo segun sea el ajuste.
     */
    public void registrarAjusteStock(Insumo insumo, float cantidadAjuste) {
        this.cantidadActual = cantidadAjuste;
        DetalleStock ajuste = new DetalleStock(cantidadAjuste, cantidadActual, LocalDateTime.now(), TipoMovimiento.Ajuste);
        this.detalleStocks.add(ajuste);
        this.verificarStockBajo(insumo);
    }

    /**
     * registra un detalle de stock del tipo Confeccion. si es un elaborado la
     * cantidad sera sumada del stock acutal, si es bruto la cantidad sera
     * restada del stock.
     *
     * @param insumo
     * @param cantidadConfeccionada
     */
    public void registrarConfeccion(Insumo insumo, float cantidadConfeccionada) {
        DetalleStock ajuste = null;
        if (insumo instanceof InsumoBruto) {
            this.cantidadActual -= cantidadConfeccionada;
            ajuste = new DetalleStock(-cantidadConfeccionada, cantidadActual, LocalDateTime.now(), TipoMovimiento.Confeccion);
        } else if (insumo instanceof InsumoElaborado) {
            this.cantidadActual += cantidadConfeccionada;
            ajuste = new DetalleStock(cantidadConfeccionada, cantidadActual, LocalDateTime.now(), TipoMovimiento.Confeccion);
        }
        this.detalleStocks.add(ajuste);
        this.verificarStockBajo(insumo);
    }

    /**
     * verifica si el stock actual esta debajo del minimo, si es el caso enviara
     * una notificacion a los responsables de stock.
     */
    private void verificarStockBajo(Insumo insumo) {
        LOGGER.info("Verificando Cantidad en Stock");
        if (this.cantidadActual - this.cantidadMinima <= 0) {
            LOGGER.info("Cantidad Verificada, Debajo del Minimo");
            ControladorNotificacion cn = new ControladorNotificacion();
            cn.notificarInsumoDebajoDelMinimo(insumo);
        }
    }

    /**
     * Crea un detalle stock con cantidad actual.
     */
    public void nuevoInsumo() {
        if (detalleStocks == null) {
            detalleStocks = new HashSet<>();
        }
        this.detalleStocks.add(new DetalleStock(this.cantidadActual, cantidadActual, new LocalDateTime(), TipoMovimiento.Ajuste));
    }
}
