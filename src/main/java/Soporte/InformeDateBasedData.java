/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

/**
 *
 * @author ang_2
 */
public class InformeDateBasedData {

    private Object date, value;

    public InformeDateBasedData() {
    }

    public InformeDateBasedData(Object date, Object value) {
        this.date = date;
        this.value = value;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InformeDateBasedData{ date=" + date + ", value=" + value + '}';
    }

}
