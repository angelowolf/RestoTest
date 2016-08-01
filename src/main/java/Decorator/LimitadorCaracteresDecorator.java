/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import javax.servlet.jsp.PageContext;
import org.apache.commons.lang.StringUtils;
import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

/**
 *
 * @author ang_2
 */
public class LimitadorCaracteresDecorator implements DisplaytagColumnDecorator {

    @Override
    public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
        if (columnValue != null && StringUtils.isNotBlank((String) columnValue)) {
            String descripcion = (String) columnValue;
            StringBuilder sb = new StringBuilder();
            sb.append(descripcion.substring(0, Math.min(20, descripcion.length())));
            if (descripcion.length() >= 20) {
                sb.append("...");
            }
            return sb.toString();
        } else {
            return "-";
        }
    }

}
