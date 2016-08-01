/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Controlador.Implementacion.ControladorUsuario;
import Controlador.Interface.IControladorUsuario;
import Modelo.Rol;
import Modelo.Usuario;
import Soporte.Encriptar;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public class UsuarioAction extends Accion implements ModelDriven<Usuario>, CRUD {

    private static final Logger LOGGER = Logger.getLogger(UsuarioAction.class);
    private Usuario usuario;
    private List<Usuario> lista;
    private final IControladorUsuario controladorUsuario;
//filtro
    private List<Rol> rolesSeleccionados;
    private final List<Rol> rolesTodos;
    private String apellidoFiltro;

    public UsuarioAction() {
        lista = new ArrayList<>();
        rolesTodos = Arrays.asList(Rol.values());
        rolesSeleccionados = new ArrayList<>();
        usuario = new Usuario();
        controladorUsuario = new ControladorUsuario();
    }

    public String blanquear() {
        controladorUsuario.blanquear(usuario);
        sesion.put("mensaje", mensajes.CLAVERESETEADA);
        return SUCCESS;
    }

    public void validateRegistrar() {
        if (usuario.getFechaNacimiento() != null) {
            if (usuario.getFechaNacimiento().isAfter(new LocalDate()) || usuario.getFechaNacimiento().isBefore(new LocalDate(1900, 1, 1))) {
                addFieldError("fechaNacimiento", mensajes.FECHAINVALIDA);
            }
        }
        if (StringUtils.isBlank(usuario.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        }
        if (StringUtils.isBlank(usuario.getApellido())) {
            addFieldError("apellido", mensajes.OBLIGATORIO);
        }
        if (usuario.getRoles() == null) {
            addFieldError("rol", mensajes.OBLIGATORIO);
        }
        if (StringUtils.isBlank(usuario.getNick())) {
            addFieldError("nick", mensajes.OBLIGATORIO);
        } else if (!controladorUsuario.nickDisponible(usuario)) {
            addFieldError("nick", mensajes.getExiste("nombre de usuario"));
        }
        if (usuario.getDocumento() == 0) {
            addFieldError("documento", mensajes.OBLIGATORIO);
        }
        if (usuario.getDocumento() < 0) {
            addFieldError("documento", mensajes.INGRESEVALORPOSITIVO);
        } else if (usuario.getDocumento() != 0 && !controladorUsuario.documentoDisponible(usuario)) {
            addFieldError("documento", mensajes.getExiste("número de documento"));
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String registrar() {
        controladorUsuario.guardar(usuario);
        sesion.put("mensaje", mensajes.getAgregado(mensajes.USUARIO));
        return SUCCESS;
    }

    public void validatePostModificar() {
        if (usuario.getFechaNacimiento() != null) {
            if (usuario.getFechaNacimiento().isAfter(new LocalDate()) || usuario.getFechaNacimiento().isBefore(new LocalDate(1900, 1, 1))) {
                addFieldError("fechaNacimiento", mensajes.FECHAINVALIDA);
            }
        }
        if (StringUtils.isBlank(usuario.getNombre())) {
            addFieldError("nombre", mensajes.OBLIGATORIO);
        }
        if (StringUtils.isBlank(usuario.getApellido())) {
            addFieldError("apellido", mensajes.OBLIGATORIO);
        }
        if (usuario.getRoles() == null) {
            addFieldError("rol", mensajes.OBLIGATORIO);
        }
        if (StringUtils.isBlank(usuario.getNick())) {
            addFieldError("nick", mensajes.OBLIGATORIO);
        } else if (!controladorUsuario.nickDisponible(usuario)) {
            addFieldError("nick", mensajes.getExiste("nombre de usuario"));
        }
        if (usuario.getDocumento() == 0) {
            addFieldError("documento", mensajes.OBLIGATORIO);
        }
        if (usuario.getDocumento() < 0) {
            addFieldError("documento", mensajes.INGRESEVALORPOSITIVO);
        } else if (usuario.getDocumento() != 0 && !controladorUsuario.documentoDisponible(usuario)) {
            addFieldError("documento", mensajes.getExiste("número de documento"));
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    @Override
    public String postModificar() {
        controladorUsuario.actualizar(usuario);
        sesion.put("mensaje", mensajes.getModificado(mensajes.USUARIO));
        return SUCCESS;
    }

    @Override
    public String eliminar() {
        controladorUsuario.eliminar(usuario);
        sesion.put("mensaje", mensajes.getBajo(mensajes.USUARIO));
        return SUCCESS;
    }

    public String recuperar() {
        controladorUsuario.recuperar(usuario);
        sesion.put("mensaje", mensajes.getRecuperado(mensajes.USUARIO));
        return SUCCESS;
    }

    @Override
    public String listar() {
        lista = controladorUsuario.buscar(nombreFiltro, apellidoFiltro, rolesSeleccionados);
        return SUCCESS;
    }

    @Override
    public String getModificar() {
        usuario = controladorUsuario.getUsuario(usuario.getId());
        return SUCCESS;
    }

    public void validatePostModificarPerfil() {
        if (usuario.getFechaNacimiento() != null) {
            if (usuario.getFechaNacimiento().isAfter(new LocalDate()) || usuario.getFechaNacimiento().isBefore(new LocalDate(1900, 1, 1))) {
                addFieldError("fechaNacimiento", mensajes.FECHAINVALIDA);
            }
        }
        if (StringUtils.isBlank(usuario.getNick())) {
            addFieldError("nick", mensajes.OBLIGATORIO);
        } else if (!controladorUsuario.nickDisponible(usuario)) {
            addFieldError("nick", mensajes.getExiste("nombre de usuario"));
        }
        if (StringUtils.isNotBlank(usuario.getClave()) || StringUtils.isNotBlank(usuario.getClave2())) {
            if (StringUtils.isBlank(usuario.getClave())) {
                addFieldError("clave", mensajes.INGRESECLAVE);
            }
            if (StringUtils.isBlank(usuario.getClave2())) {
                addFieldError("clave2", mensajes.REPITACLAVE);
            }
            if (StringUtils.isNotBlank(usuario.getClave()) && StringUtils.isNotBlank(usuario.getClave2())) {
                if (!usuario.getClave().equals(usuario.getClave2())) {
                    addFieldError("clave2", mensajes.CLAVENOCOINCIDE);
                }
            }
        }
        Usuario original = controladorUsuario.getUsuario((int) sesion.get("idUsuario"));
        if (StringUtils.isBlank(usuario.getClaveOriginal())) {
            addFieldError("claveOriginal", mensajes.INGRESECLAVEACTUAL);
        } else if (!Encriptar.encriptaEnMD5(usuario.getClaveOriginal()).equals(original.getClave())) {
            addFieldError("claveOriginal", mensajes.CLAVEINGRESADAMAL);
            usuario.setClaveOriginal("");
        }
        if (StringUtils.isBlank(usuario.getRespuestaSecreta())) {
            addFieldError("respuestaSecreta", mensajes.OBLIGATORIO);
        }
        if (StringUtils.isBlank(usuario.getPreguntaSecreta())) {
            addFieldError("preguntaSecreta", mensajes.OBLIGATORIO);
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    public String postModificarPerfil() {
        if (StringUtils.isBlank(usuario.getClave())) {
            controladorUsuario.actualizarMisDatos(usuario, false);
        } else {
            controladorUsuario.actualizarMisDatos(usuario, true);
        }
        return SUCCESS;
    }

    public String getModificarPerfil() {
        if (!sesion.containsKey("idUsuario")) {
            return LOGIN;
        }
        usuario = controladorUsuario.getUsuario((int) sesion.get("idUsuario"));
        return SUCCESS;
    }

    public void validateLogin() {
        if (StringUtils.isBlank(usuario.getNick()) || StringUtils.isBlank(usuario.getClave())) {
            addActionError(mensajes.ERRORVALIDAR);
        }
        if (hasErrors()) {
            codigo = 400;
        } else if (!controladorUsuario.iniciarSesion(controladorUsuario.getUsuario(usuario.getNick()), usuario.getClave())) {
            Usuario us = controladorUsuario.getUsuario(usuario.getNick());
            if (us != null && !us.esActivo()) {
                addActionError(mensajes.getBajo(mensajes.USUARIO));
            } else {
                addActionError(mensajes.ERRORVALIDAR);
            }
            codigo = 400;
        }
    }

    public String login() {
        sesion.remove("primeraVez");
        Usuario u = controladorUsuario.getUsuario(usuario.getNick());
        sesion.put("idUsuario", u.getId());
        sesion.put("nombreCompletoUsuario", String.format("%s %s", u.getNombre(), u.getApellido()));
        sesion.put("rolUsuario", u.esResponsableUsuario());
        sesion.put("rolMozo", u.esMozo());
        sesion.put("rolCocina", u.esResponsableCocina());
        sesion.put("rolStock", u.esResponsableStock());
        sesion.put("rolCaja", u.esResponsableCaja());
        sesion.put("rolMesa", u.esResponsableMesa());
        if (u.esPrimerLogin()) {
            sesion.put("primeraVez", true);
            return "primeravez";
        } else {
            return SUCCESS;
        }
    }

    public String logout() {
        sesion.remove("idUsuario");
        sesion.remove("rolUsuario");
        sesion.remove("rolMozo");
        sesion.remove("rolCocina");
        sesion.remove("rolStock");
        sesion.remove("rolMesa");
        sesion.remove("rolCaja");
        sesion.remove("mensaje");
        sesion.remove("primeraVez");
        sesion.remove("nombreCompletoUsuario");
        return SUCCESS;
    }

    public String home() {
        return SUCCESS;
    }

    public void validatePrimerLogin() {
        if (StringUtils.isBlank(usuario.getPreguntaSecreta())) {
            addFieldError("preguntaSecreta", mensajes.SELECCIONEPREGUNTA);
        }
        if (StringUtils.isBlank(usuario.getRespuestaSecreta())) {
            addFieldError("respuestaSecreta", mensajes.INGRESERESPUESTA);
        }
        if (hasFieldErrors()) {
            codigo = 400;
        }
    }

    public String primerLogin() {
        controladorUsuario.actualizar((int) sesion.get("idUsuario"), usuario.getPreguntaSecreta(), usuario.getRespuestaSecreta());
        sesion.remove("primeraVez");
        return SUCCESS;
    }

    public void validateRecuperarClave() {
        if (sesion.containsKey("respuesta_respondida") && (boolean) sesion.get("respuesta_respondida")) {
            if (StringUtils.isBlank(usuario.getClave())) {
                addFieldError("clave", mensajes.INGRESECLAVE);
            }
            if (StringUtils.isBlank(usuario.getClave2())) {
                addFieldError("clave2", mensajes.REPITACLAVE);
            }
            if (StringUtils.isNotBlank(usuario.getClave()) && StringUtils.isNotBlank(usuario.getClave2())) {
                if (!usuario.getClave().equals(usuario.getClave2())) {
                    addFieldError("clave2", mensajes.CLAVENOCOINCIDE);
                }
            }
        } else {
            addFieldError("clave2", "Responda la pregunta secreta... -.- ");
        }
        if (hasErrors()) {
            codigo = 400;
        }
    }

    public String recuperarClave() {
        controladorUsuario.actualizarClave(usuario.getId(), usuario.getClave());
        sesion.remove("respuesta_respondida");
        sesion.put("mensaje", mensajes.CLAVECAMBIADA);
        sesion.remove("primeraVez");
        Usuario u = controladorUsuario.getUsuario(usuario.getId());
        sesion.put("idUsuario", u.getId());
        sesion.put("nombreCompletoUsuario", String.format("%s %s", u.getNombre(), u.getApellido()));
        sesion.put("rolUsuario", u.esResponsableUsuario());
        sesion.put("rolMozo", u.esMozo());
        sesion.put("rolCocina", u.esResponsableCocina());
        sesion.put("rolStock", u.esResponsableStock());
        sesion.put("rolCaja", u.esResponsableCaja());
        sesion.put("rolMesa", u.esResponsableMesa());
        return SUCCESS;
    }

    public void validateVerificarRespuesta() {
        Usuario temp = controladorUsuario.getUsuario(usuario.getId());
        if (temp.getRespuestaSecreta() == null) {
            sesion.put("mensaje", "Usted aun no respondio la pregunta secreta.");
            addFieldError(NONE, ERROR);
        } else if (!temp.getRespuestaSecreta().toLowerCase().equals(usuario.getRespuestaSecreta().toLowerCase())) {
            sesion.put("mensaje", mensajes.RESPUESTANOVALIDA);
            addFieldError(NONE, ERROR);
        }
        usuario = temp;
    }

    public String verificarRespuesta() {
        sesion.put("respuesta_respondida", true);
        return SUCCESS;
    }

    public void validateObtenerPregunta() {
        if (controladorUsuario.getUsuario(usuario.getNick()) == null) {
            String msj = mensajes.NICKINCORRECTO;
            addFieldError("nick", msj);
            sesion.put("mensaje", msj);
        }
    }

    public String obtenerPregunta() {
        usuario = controladorUsuario.getUsuario(usuario.getNick());
        return SUCCESS;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    @VisitorFieldValidator(appendPrefix = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> getRolesSeleccionados() {
        return rolesSeleccionados;
    }

    public void setRolesSeleccionados(List<Rol> rolesSeleccionados) {
        this.rolesSeleccionados = rolesSeleccionados;
    }

    public List<Rol> getRolesTodos() {
        return rolesTodos;
    }
    
    public String getApellidoFiltro() {
        return apellidoFiltro;
    }

    public void setApellidoFiltro(String apellidoFiltro) {
        this.apellidoFiltro = apellidoFiltro;
    }

    @Override
    public Usuario getModel() {
        return usuario;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

}
