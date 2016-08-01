/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOInterface;

import Modelo.InsumoBruto;
import Modelo.InsumoElaborado;
import Persistencia.ORM.Util.IGenericDAO;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IInsumoElaborado extends IGenericDAO<InsumoElaborado, Integer> {

    /**
     * busca todos los insumos brutos que esten activos y por debajo del minimo.
     *
     * @return
     */
    public List<InsumoElaborado> getTodosStockMinimo();

    public List<InsumoElaborado> getTodosByNombreSinEstos(String capitalize, List<Integer> ids, boolean activo);

    public InsumoElaborado buscar(String nombre);

    public List<InsumoElaborado> insumoEnUso(InsumoBruto insumo);

}
