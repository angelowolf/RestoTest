/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import Modelo.Insumo;
import org.displaytag.decorator.TableDecorator;

/**
 *
 * @author ang_2
 */
public class RowInsumoIdDecorator extends TableDecorator {

    @Override
    public String addRowId() {
        Insumo i = (Insumo) getCurrentRowObject();
        return "" + i.getId();
    }

}
