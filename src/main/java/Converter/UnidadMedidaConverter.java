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
public class UnidadMedidaConverter extends StrutsTypeConverter {

    private static final Logger log = Logger.getLogger(UnidadMedidaConverter.class);

    @Override
    public UnidadMedida convertFromString(Map context, String[] values, Class toClass) {
        log.debug("****************************Enum Unidad Medida****************************");
        UnidadMedida objeto = null;
        if (values.length > 0 && values[0] != null && values[0].trim().length() > 0) {
            String value = values[0];
            try {
                objeto = UnidadMedida.valueOf(UnidadMedida.class, value.trim());
                log.debug("Enum creado " + objeto.toString());
            } catch (Exception e) {
                log.error("Error al convertir Unidad Medida", e);
            }
        }
        return objeto;
    }

    @Override
    public String convertToString(Map context, Object o) {
        log.debug("Enum Unidad Medida");
        if (o instanceof UnidadMedida) {
            UnidadMedida objeto = (UnidadMedida) o;
            return objeto.name();
        }
        return "";
    }

}
