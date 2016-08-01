/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import Spring.Mensajes;
import javax.servlet.jsp.PageContext;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author ang_2
 */
public class DateTimeDecorator implements DisplaytagColumnDecorator, Mensajes {

    @Override
    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
        if (columnValue != null) {
            DateTimeFormatter salida = DateTimeFormat.forPattern(mensajes.FECHAHORAJSON);
            LocalDateTime fecha = (LocalDateTime) columnValue;
            return salida.print(fecha);
        } else {
            return "-";
        }
    }

}
