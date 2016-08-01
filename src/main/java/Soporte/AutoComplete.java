/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import Modelo.Insumo;
import Modelo.Receta;

/**
 *
 * @author ang_2
 */
public class AutoComplete {

    private int id;
    private Object value, label;

    public AutoComplete(int id, Object value, Object label) {
        this.id = id;
        this.value = value;
        this.label = label;
    }

    public AutoComplete() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public static AutoComplete generarAC(Insumo insumo) {
        return new AutoComplete(insumo.getId(), insumo.getNombre(), insumo.getNombre());
    }

    public static AutoComplete generarAC(Receta receta) {
        return new AutoComplete(receta.getId(), receta.getNombre(), receta.getNombre());
    }
}
