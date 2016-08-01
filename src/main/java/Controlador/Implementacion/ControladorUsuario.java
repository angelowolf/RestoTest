package Controlador.Implementacion;

import Controlador.Interface.IControladorUsuario;
import Modelo.Rol;
import Modelo.Usuario;
import Soporte.Encriptar;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:23 p.m.
 */
public class ControladorUsuario implements IControladorUsuario {

    private static final Logger LOG = Logger.getLogger(ControladorUsuario.class);

    @Override
    public void eliminar(Usuario us) {
        Usuario u = USUARIODAO.buscar(us.getId());
        LocalDate hoy = LocalDate.now();
        u.setFechaBaja(hoy);
        USUARIODAO.actualizar(u);
    }

    @Override
    public void eliminar(int idUsuario) {
        Usuario u = USUARIODAO.buscar(idUsuario);
        LocalDate hoy = LocalDate.now();
        u.setFechaBaja(hoy);
        USUARIODAO.actualizar(u);
    }

    @Override
    public boolean isNickDisponible(String nick) {
        Usuario u = getUsuario(nick);
        return u == null;
    }

    @Override
    public Usuario getUsuario(String nick) {
        return USUARIODAO.buscarNick(nick);

    }

    @Override
    public Usuario getUsuario(int id) {
        return USUARIODAO.buscar(id);
    }

    @Override
    public boolean iniciarSesion(Usuario usuario, String password) {
        return usuario != null && usuario.iniciarSesion(password);
    }

    @Override
    public int guardar(String nombre, String apellido, String clave, String nick, Set<Rol> rol) {
        Usuario u = new Usuario(nombre, apellido, nick, Encriptar.encriptaEnMD5(clave), rol);
        return USUARIODAO.guardar(u);
    }

    @Override
    public int guardar(Usuario usuario) {
        LocalDate hoy = LocalDate.now();
        usuario.setFechaAlta(hoy);
        usuario.setClave(Encriptar.encriptaEnMD5(usuario.getNick()));
        return USUARIODAO.guardar(usuario);
    }

    @Override
    public void actualizar(int idUsuario, String nombre, String apellido, String clave, String nick, Set<Rol> rol) {
        Usuario u = USUARIODAO.buscar(idUsuario);
        if (StringUtils.isNotBlank(clave)) {
            u.setClave(Encriptar.encriptaEnMD5(clave));
        }
        u.setNick(nick);
        u.setNombre(nombre);
        u.setApellido(apellido);
        u.setRoles(rol);
        USUARIODAO.actualizar(u);
    }

    @Override
    public void actualizar(Usuario usuario) {
        Usuario u = USUARIODAO.buscar(usuario.getId());
        u.setNombre(usuario.getNombre());
        u.setApellido(usuario.getApellido());
        u.setRoles(usuario.getRoles());
        u.setDocumento(usuario.getDocumento());
        u.setFechaNacimiento(usuario.getFechaNacimiento());
        u.setNick(usuario.getNick());
        u.setTelefono(usuario.getTelefono());
        u.setDireccion(usuario.getDireccion());
        USUARIODAO.actualizar(u);
    }

    @Override
    public void actualizarMisDatos(Usuario usuario, boolean cambiaClave) {
        Usuario u = USUARIODAO.buscar(usuario.getId());
        if (cambiaClave) {
            u.setClave(Encriptar.encriptaEnMD5(usuario.getClave()));
        }
        u.setFechaNacimiento(usuario.getFechaNacimiento());
        u.setTelefono(usuario.getTelefono());
        u.setDireccion(usuario.getDireccion());
        u.setNick(usuario.getNick());
        u.setPreguntaSecreta(usuario.getPreguntaSecreta());
        u.setRespuestaSecreta(usuario.getRespuestaSecreta());
        USUARIODAO.actualizar(u);
    }

    @Override
    public void actualizar(int id, String preguntaSecreta, String respuestaSecreta) {
        Usuario u = USUARIODAO.buscar(id);
        u.setPreguntaSecreta(preguntaSecreta);
        u.setRespuestaSecreta(respuestaSecreta);
        USUARIODAO.actualizar(u);
    }

    @Override
    public List<Usuario> getTodos() {
        return USUARIODAO.listar();
    }

    @Override
    public List<Usuario> buscar(String nombre, String apellido, List<Rol> roles) {
        if (StringUtils.isBlank(nombre)) {
            nombre = null;
        }
        if (StringUtils.isBlank(apellido)) {
            apellido = null;
        }
        return USUARIODAO.buscar(nombre, apellido, roles);
    }

    @Override
    public boolean nickDisponible(Usuario u) {
        Usuario usuario = USUARIODAO.buscarNick(u.getNick());
        if (usuario == null) {
            return true;
        }
        return u.getId() == usuario.getId();
    }

    @Override
    public boolean documentoDisponible(Usuario u) {
        Usuario usuario = USUARIODAO.buscarDocumento(u.getDocumento());
        if (usuario == null) {
            return true;
        }
        return u.getId() == usuario.getId();
    }

    @Override
    public void recuperar(Usuario usuario) {
        Usuario u = USUARIODAO.buscar(usuario.getId());
        u.setFechaBaja(null);
        USUARIODAO.actualizar(u);
    }

    @Override
    public void actualizarClave(int id, String clave) {
        Usuario u = USUARIODAO.buscar(id);
        u.setClave(Encriptar.encriptaEnMD5(clave));
        USUARIODAO.actualizar(u);
    }

    @Override
    public void blanquear(Usuario usuario) {
        usuario = this.getUsuario(usuario.getId());
        usuario.blanquear();
        USUARIODAO.actualizar(usuario);
    }

}//end ControladorUsuario

