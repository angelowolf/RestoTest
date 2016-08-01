/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ang_2
 */
public class CreadorClase {

    public static void main(String[] args) {
        PersistenciaCreador pc = new PersistenciaCreador();
        ControladorCreador cc = new ControladorCreador();
        AccionCreador ac = new AccionCreador();

        Set<String> clases = new HashSet<>();
        clases.add("cliente");
        clases.add("auto");
        clases.add("mascota");
        clases.add("alumno");
        clases.add("persona");

        for (String nombreClase : clases) {
            pc.crear(nombreClase);
            cc.crear(nombreClase);
            ac.crear(nombreClase, true, "prueba");
        }

    }
}
