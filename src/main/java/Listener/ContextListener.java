/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listener;

import Soporte.Mensajes.MensajeEnglish;
import Soporte.Mensajes.MensajeSpanish;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author ang_2
 */
public class ContextListener implements ServletContextListener {

    private ServletContext contexto;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Iniciado contexto");
        contexto = sce.getServletContext();
        contexto.setAttribute("mensaje", new MensajeSpanish());
        System.out.println("Contexto iniciado.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Destruyendo contexto");
        contexto.removeAttribute("mensaje");
        System.out.println("Contexto eliminado");
    }

}
