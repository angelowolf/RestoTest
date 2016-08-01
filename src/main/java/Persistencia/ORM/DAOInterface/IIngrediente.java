/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Persistencia.ORM.Util.IGenericDAO;
import Modelo.Ingrediente;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IIngrediente extends IGenericDAO<Ingrediente, Integer> {

    public List<Ingrediente> getTodos();
}
