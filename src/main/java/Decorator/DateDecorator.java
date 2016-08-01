/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import Soporte.Mensajes.Mensaje;
import Spring.Mensajes;
import javax.servlet.jsp.PageContext;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author ang_2
 */
public class DateDecorator implements DisplaytagColumnDecorator, Mensajes {

    @Override
    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
        if (columnValue != null) {
            DateTimeFormatter salida = DateTimeFormat.forPattern(mensajes.FECHAJSON);
            LocalDate fecha = (LocalDate) columnValue;
            return salida.print(fecha);
        } else {
            return "-";
        }
    }
}
