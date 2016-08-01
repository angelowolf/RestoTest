/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import Modelo.Rol;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.jsp.PageContext;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

/**
 *
 * @author ang_2
 */
public class RolDecorator implements DisplaytagColumnDecorator {

    @Override
    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
        Set<Rol> roles = (Set<Rol>) columnValue;
        StringBuilder sb = new StringBuilder();
        for (Iterator<Rol> iterator = roles.iterator(); iterator.hasNext();) {
            Rol next = iterator.next();
            sb.append(getRol(next));
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String getRol(Rol rol) {
        switch (rol) {
            case Usuario:
                return "Responsable de Usuario";
            case Mozo:
                return "Mozo";
            case Cocina:
                return "Responsable de Cocina";
            case Caja:
                return "Responsable de Caja";
            case Mesa:
                return "Responsable de Mesa";
            case Stock:
                return "Responsable de Stock";
            default:
                return "ERROR";
        }
    }

    public static String getRol(String sRol) {
        Rol rol = Rol.valueOf(sRol);
        switch (rol) {
            case Usuario:
                return "Responsable de Usuario";
            case Mozo:
                return "Mozo";
            case Cocina:
                return "Responsable de Cocina";
            case Caja:
                return "Responsable de Caja";
            case Mesa:
                return "Responsable de Mesa";
            case Stock:
                return "Responsable de Stock";
            default:
                return "ERROR";
        }
    }

}
