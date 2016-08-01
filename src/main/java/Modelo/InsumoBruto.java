/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public class InsumoBruto extends Insumo {

    private float precioUnidad;

    public InsumoBruto(InsumoBruto ib) {
        super(ib.getCategoriaInsumo(), ib.getFechaAlta(), ib.getFechaBaja(), ib.getNombre(), ib.getStock(), ib.getUnidadMedida());
        super.setId(id);
        this.precioUnidad = ib.getPrecioUnidad();
    }

    public InsumoBruto() {
    }

    public InsumoBruto(float precioUnidad, CategoriaInsumo categoriaInsumo, LocalDate fechaAlta, LocalDate fechaBaja, String nombre, Stock stock, UnidadMedida unidadMedida) {
        super(categoriaInsumo, fechaAlta, fechaBaja, nombre, stock, unidadMedida);
        this.precioUnidad = precioUnidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @Override
    public void actualizar(Insumo insumo) {
        if (insumo instanceof InsumoBruto) {
            InsumoBruto insumo2 = (InsumoBruto) insumo;
            this.precioUnidad = insumo2.getPrecioUnidad();
            super.actualizar(insumo);
        } else {
            throw new ClassCastException("Error al castear un objeto a insumobruto");
        }
    }

    /**
     * actualiza el stock con esa cantidad. manda notificacion si es el caso.
     *
     * @param f
     */
    public void registrarConfeccion(float f) {
        stock.registrarConfeccion(this, f);
    }
}
