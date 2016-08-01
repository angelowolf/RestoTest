/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import javax.xml.transform.OutputKeys;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DocumentType;

/**
 *
 * @author ang_2
 */
class AccionCreador {

    private String nombreReal;
    private String nombreSinMayus;

    /**
     * Crea la clase Accion. si es True creara el xml de struts y lo agregara al
     * struts.xml
     *
     * @param nombreClase
     * @param modificarXML
     * @param namespace
     */
    void crear(String nombreClase, boolean modificarXML, String namespace) {
        this.nombreSinMayus = nombreClase;
        nombreReal = CommonsUtil.upFirstLetter(nombreClase);
        this.crearAccion();
        if (modificarXML) {
            this.crearStrutsXml(namespace);
            this.modificarStruts();
        }
    }

    private void crearAccion() {
        try {
            List<String> lines = Arrays.asList("package Acciones;\n",
                    "import Modelo." + nombreReal + ";",
                    "import Controlador.Interface.IControlador" + nombreReal + ";",
                    "import Controlador.Implementacion.Controlador" + nombreReal + ";",
                    "import Modelo." + nombreReal + ";",
                    "import Soporte.Mensaje;",
                    "import java.util.List;\n",
                    "public class " + nombreReal + "Action extends Accion implements CRUD {\n",
                    "    private final IControlador" + nombreReal + " controlador;",
                    "    public " + nombreReal + "Action() {",
                    "        controlador = new Controlador" + nombreReal + "();",
                    "    }",
                    "    @Override",
                    "    public String getModificar() {",
                    "        return SUCCESS;",
                    "    }",
                    "    public void validatePostModificar() {",
                    "        if (hasFieldErrors()) {",
                    "            codigo = 400;",
                    "        }",
                    "    }",
                    "    @Override",
                    "    public String postModificar() {",
                    "        sesion.put(\"mensaje\", Mensaje.getModificada(\"mensaje\"));",
                    "        return SUCCESS;",
                    "    }",
                    "    public void validateRegistrar() {",
                    "        if (hasFieldErrors()) {",
                    "            codigo = 400;",
                    "        }",
                    "    }",
                    "    @Override",
                    "    public String registrar() {",
                    "        sesion.put(\"mensaje\", Mensaje.getAgregada(\"mensaje\"));",
                    "        return SUCCESS;",
                    "    }",
                    "    public void validateEliminar() {",
                    "        if (hasFieldErrors()) {",
                    "            codigo = 400;",
                    "        }",
                    "    }",
                    "    @Override",
                    "    public String eliminar() {",
                    "        sesion.put(\"mensaje\", Mensaje.getEliminada(\"mensaje\"));",
                    "        return SUCCESS;",
                    "    }",
                    "    @Override",
                    "    public String listar() {",
                    "        return SUCCESS;",
                    "    }",
                    "}"
            );
            Path file = Paths.get("src/main/java/Acciones/" + nombreReal + "Action.java");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("Interface Creada");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearStrutsXml(String namespace) {
        try {
            List<String> lines = Arrays.asList(
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>",
                    "<!DOCTYPE struts PUBLIC",
                    "\"-//Apache Software Foundation//DTD Struts Configuration 2.0//EN\"",
                    "\"http://struts.apache.org/dtds/struts-2.0.dtd\">\n",
                    "<struts>",
                    "    <package name=\"" + nombreReal + "\" extends=\"json\" namespace=\"/" + namespace + "\">",
                    "        <action name=\"getModificar\" method=\"getModificar\" class=\"Acciones." + nombreReal + "Action\"/>",
                    "        <action name=\"postModificar\" method=\"postModificar\" class=\"Acciones." + nombreReal + "Action\"/>",
                    "        <action name=\"registrar\" method=\"registrar\" class=\"Acciones." + nombreReal + "Action\"/>",
                    "        <action name=\"eliminar\" method=\"eliminar\" class=\"Acciones." + nombreReal + "Action\"/>",
                    "        <action name=\"listar\" method=\"listar\" class=\"Acciones." + nombreReal + "Action\">",
                    "            <result name=\"success\" type=\"tiles\">/" + namespace + "/todos.tiles</result>",
                    "        </action>",
                    "        <action name=\"nuevo\">",
                    "            <result type=\"tiles\">/" + namespace + "/alta.tiles</result>",
                    "        </action>",
                    "    </package>",
                    "</struts>"
            );
            Path file = Paths.get("src/main/resources/Struts2/XML/struts-" + nombreSinMayus + ".xml");
            Files.write(file, lines, Charset.forName("UTF-8"));
            System.out.println("Struts XML Creado");
        } catch (IOException ex) {
            Logger.getLogger(PersistenciaCreador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modificarStruts() {
        try {
            Path file = Paths.get("src/main/resources/struts.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file.toFile());
            NodeList includes = doc.getElementsByTagName("include");
            Element include = doc.createElement("include");
            include.setAttribute("file", "Struts2/XML/struts-" + nombreSinMayus + ".xml");
            includes.item(0).getParentNode().insertBefore(include, includes.item(0));

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMImplementation domImpl = doc.getImplementation();
            DocumentType doctype = domImpl.createDocumentType("struts",
                    "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN",
                    "http://struts.apache.org/dtds/struts-2.0.dtd");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(file.toString()));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
