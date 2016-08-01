/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Modelo.Rol;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 *
 * @author ang_2
 */
public class RolConverter extends StrutsTypeConverter {

    private static final Logger log = Logger.getLogger(RolConverter.class);

    @Override
    public Rol convertFromString(Map context, String[] values, Class toClass) {
        log.info("****************************Enum rol****************************");
        Rol r = null;
        if (values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
            String value = values[0];
            try {
                r = Rol.valueOf(Rol.class, value.trim());
                log.debug("Enum creado " + r.toString());
            } catch (Exception e) {
                log.error("Error al convertir rol", e);
            }
        }
        return r;
    }

    @Override
    public String convertToString(Map context, Object o) {
        log.debug("Enum rol");
        if (o instanceof Rol) {
            Rol r = (Rol) o;
            return r.name();
        }
        return "";
    }

}
