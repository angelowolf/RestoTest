package Persistencia.ORM.Util;

import java.io.Serializable;

/**
 * @author Angelo
 * @version 1.0
 * @param <Entity>
 * @param <PK>
 * @created 28-ene-2016 08:44:26 p.m.
 */
public interface IGenericDAO<Entity, PK extends Serializable> {

    /**
     * Guarda un objeto
     *
     * @param t El objeto a guardar.
     * @return El ID generado al guardar el objeto
     */
    public Integer guardar(Entity t);

    /**
     * Actualiza los datos de un objeto.
     *
     * @param t El objeto a actualizar.
     */
    public void actualizar(Entity t);

    /**
     * Busca un objeto por su id. En el caso de que el objeto no exista, se
     * devolvera un nuevo objeto al que se le mapeara el id pasado por
     * parametro, si se le pide una propiedad saltara una exception.
     *
     * @param id
     * @return El objeto encontrado.
     */
    public Entity buscar(PK id);

    /**
     * Elimina un objeto.
     *
     * @param t El objeto a eliminar.
     */
    public void eliminar(Entity t);

}
