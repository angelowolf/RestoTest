/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Modelo.Rol;
import Modelo.UnidadMedida;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 *
 * @author ang_2
 */
public class floatC extends StrutsTypeConverter {

    private static final Logger log = Logger.getLogger(floatC.class);

    @Override
    public Float convertFromString(Map context, String[] values, Class toClass) {
        log.debug("****************************FLOAT CONEVERTER****************************");
        Float objeto = null;
        if (values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
            String value = values[0];
            try {
                objeto = Float.valueOf(value.trim());
                log.debug("FLOAT creado " + objeto);
            } catch (Exception e) {
                log.error("Error al convertir FLOAT", e);
            }
        }
        return objeto;
    }

    @Override
    public String convertToString(Map context, Object o) {
        return Float.toString((float) o);
    }

}
