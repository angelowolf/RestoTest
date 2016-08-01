/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Soporte.CommonsUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang_2
 */
class ControladorCreador {

    private String nombre;

    /**
     * Crea la interface y un controlador que la implementa.
     *
     * @param nombreClase
     */
    void crear(String nombreClase) {
        nombre = CommonsUtil.upFirstLetter(nombreClase);
        this.crearInterface();
        this.crearControlador();
    }

    private void crearControlador() {
        try {
            List<String> lines = Arrays.asList("package Controlador.Implementacion;\n",
                    "import Controlador.Interface.IControlador" + nombre + ";",
                    "import Modelo." + nombre + ";",
                    "import java.util.List;",
                    "import org.apache.commons.lang.StringUtils;",
                    "import org.apache.log4j.Logger;\n",
                    "public class Controlador" + nombre + " implements IControlador" + nombre + " {\n",
                    "    private static final Logger LOGGER = Logger.getLogger(Controlador" + nombre + ".class);\n",
                    "    @Override",
                    "    public int guardar(" + nombre + " entidad) {",
                    "        return DAO.guardar(entidad);",
                    "    }\n",
                    "    @Override",
                    "    public List<" + nombre + "> getTodos() {",
                    "        return DAO.getTodos();",
                    "    }\n",
                    "    @Override",
                    "    public " + nombre + " get" + nombre + "(int id) {",
                    "        return DAO.buscar(id);",
                    "    }\n",
                    "    @Override",
                    "    public void actualizar(" + nombre + " entidad) {",
                    "        DAO.actualizar(entidad);",
                    "    }\n",
                    "    @Override",
                    "    public void eliminar(" + nombre + " entidad) {",
                    "    }\n",
                    "    @Override",
                    "    public boolean nombreDisponible(" + nombre + " entidad) {",
                    "        " + nombre + " entidadBD= DAO.buscar(entidad.getNombre());",
                    "        if (entidadBD == null) {",
                    "            return true;",
                    "        }",
                    "        return entidad.getId() == entidadBD.getId();",
                    "    }\n",
                    "    @Override",
                    "    public boolean enUso(" + nombre + " entidad) {",
                    "        return false;",
                    "    }\n",
                    "}"
            );
            Path file = Paths.get("src/main/java/Controlador/Implementacion/Controlador" + nombre + ".java");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("Controlador Creado");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearInterface() {
        try {
            List<String> lines = Arrays.asList("package Controlador.Interface;\n",
                    "import Modelo." + nombre + ";",
                    "import Persistencia.ORM.DAOImplementacion." + nombre + "DAO;",
                    "import Persistencia.ORM.DAOInterface.I" + nombre + ";",
                    "import java.util.List;\n",
                    "public interface IControlador" + nombre + " {\n",
                    "    final I" + nombre + " DAO = new " + nombre + "DAO();\n",
                    "    public int guardar(" + nombre + " entidad);\n",
                    "    public List<" + nombre + "> getTodos();\n",
                    "    public " + nombre + " get" + nombre + "(int id);\n",
                    "    public void actualizar(" + nombre + " entidad);\n",
                    "    public void eliminar(" + nombre + " entidad);\n",
                    "    public boolean nombreDisponible(" + nombre + " entidad);\n",
                    "    public boolean enUso(" + nombre + " entidad);\n",
                    "}"
            );
            Path file = Paths.get("src/main/java/Controlador/Interface/IControlador" + nombre + ".java");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("Interface Controlador Creada");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
