/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Spring.Mensajes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author ang_2
 */
public abstract class Accion extends ActionSupport implements Mensajes {

    protected final Map<String, Object> sesion = ActionContext.getContext().getSession();
    protected int codigo = 200;
    protected String nombreFiltro;
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }

    public void setNombreFiltro(String nombreFiltro) {
        this.nombreFiltro = nombreFiltro;
    }

}
