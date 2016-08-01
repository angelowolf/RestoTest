/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Modelo.Rol;
import Modelo.Usuario;
import Persistencia.ORM.DAOInterface.IUsuario;
import Persistencia.ORM.Util.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author ang_2
 */
public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements IUsuario {

    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class);

    @Override
    public Usuario buscarNick(String nick) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        try {
            String sql = "from Usuario where nick = :nick";
            objetos = session.createQuery(sql).setParameter("nick", nick).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar usuario", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Usuario> listar() {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        try {
            String sql = "from Usuario order by nombre";
            objetos = session.createQuery(sql).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los usuarios.", e);
        }
        return objetos;
    }

    @Override
    public List<Usuario> buscar(String nombre, String apellido, List<Rol> roles) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        try {
            StringBuilder sb = new StringBuilder("select * from Usuario usuario inner join Rol_Usuario rol on usuario.id = rol.id  where usuario.id is not null");
            if (nombre != null) {
                sb.append(" and usuario.nombre like :nombre");
                f1 = true;
            }
            if (apellido != null) {
                sb.append(" and usuario.apellido like :apellido");
                f2 = true;
            }
            if (roles != null && !roles.isEmpty()) {
                sb.append(" and rol.roles in (:roles)");
                f3 = true;
            }
            sb.append(" group by usuario.id");
            if (f3) {
                sb.append(" HAVING COUNT(DISTINCT rol.roles) = ");
                sb.append(roles.size());
            }
            sb.append(" order by nombre");
            SQLQuery sqlQ = session.createSQLQuery(sb.toString());
            if (f1) {
                sqlQ.setParameter("nombre", nombre + "%");
            }
            if (f2) {
                sqlQ.setParameter("apellido", apellido + "%");
            }
            if (f3) {
                String[] ls = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    Rol get = roles.get(i);
                    ls[i] = get.toString();
                }
                sqlQ.setParameterList("roles", ls);
            }
            objetos = sqlQ.addEntity(Usuario.class).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los usuarios.", e);
        }
        return objetos;
    }

    @Override
    public Usuario buscarDocumento(long documento) {
        Session session = getHibernateTemplate();
        List<Usuario> objetos = new ArrayList<>();
        try {
            String sql = "from Usuario where documento = :documento";
            objetos = session.createQuery(sql).setParameter("documento", documento).list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar usuario", e);
        }
        if (!objetos.isEmpty()) {
            return objetos.get(0);
        } else {
            return null;
        }
    }

}
