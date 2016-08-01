/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Soporte.Mensajes.Mensaje;
import Spring.Mensajes;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author ang_2
 */
public class LocalDateConverter extends StrutsTypeConverter implements Mensajes {

    @Override
    public LocalDate convertFromString(Map context, String[] values, Class toClass) {
        LocalDate d = null;
        if (values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
            d = LocalDate.parse(values[0], DateTimeFormat.forPattern(mensajes.FECHAJSON));
        }
        return d;
    }

    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof LocalDate) {
            return ((LocalDate) o).toString(mensajes.FECHAJSON);
        }
        return "";
    }

}
