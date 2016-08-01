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
class PersistenciaCreador {

    private String nombre;

    /**
     * Crea la interface y el dao.
     *
     * @param nombreClase
     */
    void crear(String nombreClase) {
        nombre = CommonsUtil.upFirstLetter(nombreClase);
        this.crearInterface();
        this.crearDAO();
    }

    private void crearDAO() {
        try {
            List<String> lines = Arrays.asList("package Persistencia.ORM.DAOImplementacion;\n",
                    "import Modelo." + nombre + ";",
                    "import Persistencia.ORM.DAOInterface.I" + nombre + ";",
                    "import Persistencia.ORM.Util.GenericDAO;",
                    "import java.util.ArrayList;",
                    "import org.apache.log4j.Logger;",
                    "import org.hibernate.Criteria;",
                    "import org.hibernate.Session;",
                    "import org.hibernate.criterion.Order;",
                    "import org.hibernate.criterion.Restrictions;",
                    "import java.util.List;\n",
                    "public class " + nombre + "DAO extends GenericDAO<" + nombre + ", Integer> implements I" + nombre + " {\n",
                    "    private static final Logger LOG = Logger.getLogger(" + nombre + "DAO.class);\n",
                    "    @Override",
                    "    public List<" + nombre + "> getTodos() {",
                    "        Session session = getHibernateTemplate();",
                    "        List<" + nombre + "> objetos = new ArrayList<>();",
                    "        try {",
                    "            Criteria criterio = session.createCriteria(" + nombre + ".class);",
                    "            criterio.add(Restrictions.neOrIsNotNull(\"id\", null));",
                    "            criterio.addOrder(Order.asc(\"nombre\"));",
                    "            objetos = criterio.list();",
                    "        } catch (RuntimeException e) {",
                    "            LOG.error(\"Error al buscar las " + nombre + "s.\", e);",
                    "        }",
                    "        return objetos;",
                    "    }\n",
                    "    @Override",
                    "    public " + nombre + " buscar(String nombreFiltro) {",
                    "        Session session = getHibernateTemplate();",
                    "        List<" + nombre + "> objetos = new ArrayList<>();",
                    "        try {",
                    "            Criteria criterio = session.createCriteria(" + nombre + ".class);",
                    "            criterio.add(Restrictions.neOrIsNotNull(\"id\", null));",
                    "            if (nombreFiltro != null) {",
                    "                criterio.add(Restrictions.like(\"nombre\", nombreFiltro + \"%\"));",
                    "            }",
                    "            criterio.addOrder(Order.asc(\"nombre\"));",
                    "            objetos = criterio.list();",
                    "        } catch (RuntimeException e) {",
                    "            LOG.error(\"Error al buscar la " + nombre + ".\", e);",
                    "        }",
                    "        if (!objetos.isEmpty()) {",
                    "            return objetos.get(0);",
                    "        } else {",
                    "            return null;",
                    "        }",
                    "    }\n",
                    "    @Override",
                    "    public List<" + nombre + "> buscarFiltro(String nombreFiltro) {",
                    "        Session session = getHibernateTemplate();",
                    "        List<" + nombre + "> objetos = new ArrayList<>();",
                    "        try {",
                    "            Criteria criterio = session.createCriteria(" + nombre + ".class);",
                    "            criterio.add(Restrictions.neOrIsNotNull(\"id\", null));",
                    "            if (nombreFiltro != null) {",
                    "                criterio.add(Restrictions.like(\"nombre\", nombreFiltro + \"%\"));",
                    "            }",
                    "            criterio.addOrder(Order.asc(\"nombre\"));",
                    "            objetos = criterio.list();",
                    "        } catch (RuntimeException e) {",
                    "            LOG.error(\"Error al buscar las " + nombre + "s.\", e);",
                    "        }",
                    "        return objetos;",
                    "    }\n",
                    "}"
            );
            Path file = Paths.get("src/main/java/Persistencia/ORM/DAOImplementacion/" + nombre + "DAO.java");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("DAO Creado");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearInterface() {
        try {
            List<String> lines = Arrays.asList("package Persistencia.ORM.DAOInterface;\n",
                    "import Modelo." + nombre + ";",
                    "import Persistencia.ORM.Util.IGenericDAO;",
                    "import java.util.List;\n",
                    "public interface I" + nombre + " extends IGenericDAO<" + nombre + ", Integer> {\n",
                    "    public List<" + nombre + "> getTodos();\n",
                    "    public " + nombre + " buscar(String nombre);\n",
                    "    public List<" + nombre + "> buscarFiltro(String nombreFiltro);\n",
                    "}"
            );
            Path file = Paths.get("src/main/java/Persistencia/ORM/DAOInterface/I" + nombre + ".java");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("Interface DAO Creada");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
