/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.Rol;
import Modelo.Usuario;
import Persistencia.ORM.DAOImplementacion.UsuarioDAO;
import Persistencia.ORM.DAOInterface.IUsuario;
import java.util.List;
import java.util.Set;

/**
 *
 * @author flore
 */
public interface IControladorUsuario {

    final IUsuario USUARIODAO = new UsuarioDAO();

    /**
     * Guarda un nuevo usuario en la BD.
     *
     * @param nombre
     * @param clave
     * @param apellido
     * @param nick
     * @param rol
     * @return id.
     */
    public int guardar(String nombre, String apellido, String clave, String nick, Set<Rol> rol);

    /**
     * Guarda un nuevo usuario en la BD.
     *
     * @param usuario
     * @return id.
     */
    public int guardar(Usuario usuario);

    /**
     * Actualiza los datos del usuario. Encripta la clave en MD5. Actualiza el
     * tipo de usuario.
     *
     * @param idUsuario
     * @param nombre
     * @param apellido
     * @param clave
     * @param nick
     * @param rol
     */
    public void actualizar(int idUsuario, String nombre, String apellido, String clave, String nick, Set<Rol> rol);

    /**
     * Actualiza los datos del usuario. Encripta la clave en MD5. Actualiza el
     * tipo de usuario.
     *
     * @param usuario
     */
    public void actualizar(Usuario usuario);

    /**
     * Elimina un usuario.
     *
     * @param u El usuario.
     */
    public void eliminar(Usuario u);

    /**
     * Elimina un usuario.
     *
     * @param idUsuario EL id del usuario.
     */
    public void eliminar(int idUsuario);

    /**
     * Verifica si el nombre su usuario se encuentra disponible o no.
     *
     * @param nick
     * @return True si es posible utilizarlo.
     */
    public boolean isNickDisponible(String nick);

    /**
     * Devuelve al usuario.
     *
     * @param nick
     * @return Usuario.
     */
    public Usuario getUsuario(String nick);

    /**
     * Devuelve un usuario.
     *
     * @param id
     * @return Usuario.
     */
    public Usuario getUsuario(int id);

    /**
     * Verifica si los datos ingresados pertenecen a un usuario registrado. Si
     * el usuario es NULL, se devolvera false. Si el usuario existe, pero la
     * contraseña no coincide devolvera false.
     *
     * @param u El usuario que esta intentando logearse.
     * @param password La clave.
     * @return True si existe y coincide la contraseña.
     */
    public boolean iniciarSesion(Usuario u, String password);

    /**
     * Todos los usuarios registrados.
     *
     * @return List
     */
    public List<Usuario> getTodos();

    public List<Usuario> buscar(String nombre, String apellido, List<Rol> roles);

    /**
     * Verifica si el nombre de usuario se encuentra disponible. Si el nick
     * pertenece al mismo usuario,(es el dueño del nick) devolvera true, si se
     * encuentra disponible devolvera true, si esta usado devolvera falso.
     *
     * @param u
     * @return Leer arriba.
     */
    public boolean nickDisponible(Usuario u);

    public boolean documentoDisponible(Usuario usuario);

    public void recuperar(Usuario usuario);

    public void actualizarMisDatos(Usuario usuario, boolean cambiaClave);

    public void actualizar(int id, String preguntaSecreta, String respuestaSecreta);

    public void actualizarClave(int id, String clave);

    public void blanquear(Usuario usuario);

}
