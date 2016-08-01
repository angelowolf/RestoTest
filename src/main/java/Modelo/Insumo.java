/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Spring.Mensajes;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import org.apache.commons.lang.WordUtils;
import org.apache.struts2.json.annotations.JSON;
import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public abstract class Insumo implements Mensajes {

    protected int id;
    protected CategoriaInsumo categoriaInsumo;
    protected LocalDate fechaAlta, fechaBaja;
    protected String nombre, fAlta, fBaja;
    protected Stock stock;
    protected UnidadMedida unidadMedida;

    public Insumo() {
    }

    public Insumo(CategoriaInsumo categoriaInsumo, LocalDate fechaAlta, LocalDate fechaBaja, String nombre, Stock stock, UnidadMedida unidadMedida) {
        this.categoriaInsumo = categoriaInsumo;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.nombre = nombre;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
    }

    public String getfAlta() {
        if (null == fechaAlta) {
            return null;
        }
        return fechaAlta.toString(mensajes.FECHAJSON);
    }

    public String getfBaja() {
        if (null == fechaBaja) {
            return null;
        }
        return fechaBaja.toString(mensajes.FECHAJSON);
    }

    @JSON(serialize = false)
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @StringLengthFieldValidator(maxLength = "100", message = "La cantidad máxima de carácter es de 100", fieldName = "nombre")
    public void setNombre(String nombre) {
        this.nombre = WordUtils.capitalize(nombre);
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @JSON(serialize = false)
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CategoriaInsumo getCategoriaInsumo() {
        return categoriaInsumo;
    }

    public void setCategoriaInsumo(CategoriaInsumo categoriaInsumo) {
        this.categoriaInsumo = categoriaInsumo;
    }

    public void actualizar(Insumo insumo) {
        this.nombre = insumo.getNombre();
        this.unidadMedida = insumo.getUnidadMedida();
        this.categoriaInsumo = insumo.getCategoriaInsumo();
        this.stock.setCantidadMinima(insumo.getStock().getCantidadMinima());
    }

    public void darDeBaja() {
        fechaBaja = LocalDate.now();
    }

    public void recuperar() {
        fechaBaja = null;
    }

    public void regitrarDescuentoPorVenta(float cantidadARestar) {
        this.stock.regitrarDescuento(this, cantidadARestar);
    }

    public void registrarReposicion(float cantidadASumar) {
        this.stock.registrarReposicion(this, cantidadASumar);
    }

    public void registrarAjusteStock(float cantidadAjuste) {
        this.stock.registrarAjusteStock(this, cantidadAjuste);
    }

    @Override
    public String toString() {
        return "Insumo{" + "id=" + id + ", categoriaInsumo=" + categoriaInsumo + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", nombre=" + nombre + ", stock=" + stock + ", unidadMedida=" + unidadMedida + '}';
    }

}
