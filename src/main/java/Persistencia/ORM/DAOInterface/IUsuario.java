/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.Rol;
import Modelo.Usuario;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IUsuario extends IGenericDAO<Usuario, Integer> {

    /**
     * Busca un usuario por su nick. Si no existe devolvera null.
     *
     * @param username
     * @return Usuario o NULL.
     */
    public Usuario buscarNick(String username);

    /**
     * Una lista con todos los usuarios registrados.
     *
     * @return List
     */
    public List<Usuario> listar();

    public List<Usuario> buscar(String nombre, String apellido, List<Rol> roles);

    public Usuario buscarDocumento(long documento);

}
