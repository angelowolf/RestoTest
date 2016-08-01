/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soporte;

import Modelo.InsumoBruto;

/**
 *
 * @author ang_2
 */
public class InsumoBrutoVista extends InsumoBruto {

    private float cantidadDescontar;

    public InsumoBrutoVista() {
    }

    public InsumoBrutoVista(InsumoBruto ib, float cantidadDescontar) {
        super(ib);
        this.cantidadDescontar = cantidadDescontar;
    }

    public float getCantidadDescontar() {
        return cantidadDescontar;
    }

    public void setCantidadDescontar(float cantidadDescontar) {
        this.cantidadDescontar = cantidadDescontar;
    }

}
