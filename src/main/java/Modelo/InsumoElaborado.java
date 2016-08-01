/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public class InsumoElaborado extends Insumo {

    private Set<DetalleInsumoElaborado> detalleInsumoElaborados;

    public InsumoElaborado() {
    }

    public InsumoElaborado(Set<DetalleInsumoElaborado> detalleInsumoElaborados, CategoriaInsumo categoriaInsumo, LocalDate fechaAlta, LocalDate fechaBaja, String nombre, Stock stock, UnidadMedida unidadMedida) {
        super(categoriaInsumo, fechaAlta, fechaBaja, nombre, stock, unidadMedida);
        this.detalleInsumoElaborados = detalleInsumoElaborados;
    }

    public Set<DetalleInsumoElaborado> getDetalleInsumoElaborados() {
        return detalleInsumoElaborados;
    }

    public void setDetalleInsumoElaborados(Set<DetalleInsumoElaborado> detalleInsumoElaborados) {
        this.detalleInsumoElaborados = detalleInsumoElaborados;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "detalleInsumoElaborados=" + detalleInsumoElaborados;
    }

    public void agregarInsumoBruto(InsumoBruto ib, Float get) {
        DetalleInsumoElaborado die = new DetalleInsumoElaborado(ib, get);
        if (this.getDetalleInsumoElaborados() != null) {
            this.getDetalleInsumoElaborados().add(die);
        } else {
            this.detalleInsumoElaborados = new HashSet<>();
            this.getDetalleInsumoElaborados().add(die);
        }
    }

    public void actualizar(InsumoElaborado insumoElaborado, List<InsumoBruto> insumosRequest, List<Float> cantidades) {
        super.actualizar(insumoElaborado);
        for (Iterator<DetalleInsumoElaborado> iterator = this.detalleInsumoElaborados.iterator(); iterator.hasNext();) {
            DetalleInsumoElaborado insumoElaboradoBD = iterator.next();
            boolean flag = false;
            for (InsumoBruto insumoBrutoRquest : insumosRequest) {
                if (insumoElaboradoBD.getInsumoBruto().getId() == insumoBrutoRquest.getId()) {
                    //Si el insumo que esta en la bd, no esta en el request hay que eliminarlo
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //Elimino este dettale de insumo.
                iterator.remove();
            }
        }

        for (int i = 0; i < insumosRequest.size(); i++) {
            InsumoBruto insumoBrutoRequest = insumosRequest.get(i);
            boolean flag = false;
            for (DetalleInsumoElaborado detalleInsumoElaboradoBD : this.detalleInsumoElaborados) {
                if (detalleInsumoElaboradoBD.getInsumoBruto().getId() == insumoBrutoRequest.getId()) {
                    //Si los ids son iguales actualizo
                    detalleInsumoElaboradoBD.setCantidad(cantidades.get(i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                //si no son iguales es un alta
                this.agregarInsumoBruto(insumoBrutoRequest, cantidades.get(i));
                System.out.println("agregando " + insumoBrutoRequest.toString() + "cnt " + cantidades.get(i));
            }
        }
        System.out.println("al final");
        for (DetalleInsumoElaborado detalleInsumoElaborado : this.detalleInsumoElaborados) {
            System.out.println(detalleInsumoElaborado.toString());
        }
    }

    /**
     * Confecciona una cantdad de este insumo elaborado, descuenta las
     * cantidades de su receta. verifica si esta por debajo del stock y manda
     * notificacion.
     *
     * @param cantidadConfeccionarInsumo
     */
    public void confeccionar(float cantidadConfeccionarInsumo) {
        for (DetalleInsumoElaborado cadaDetalle : detalleInsumoElaborados) {
            cadaDetalle.registrarConfeccion(cantidadConfeccionarInsumo);
        }
        this.stock.registrarConfeccion(this, cantidadConfeccionarInsumo);
    }

}
