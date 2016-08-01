/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Controlador.Implementacion.ControladorStock;
import Modelo.InsumoBruto;
import Persistencia.ORM.DAOImplementacion.InsumoBrutoDAO;
import java.util.List;
import Persistencia.ORM.DAOInterface.IInsumoBruto;

/**
 *
 * @author ang_2
 */
public interface IControladorInsumoBruto {

    final IInsumoBruto INSUMODAO = new InsumoBrutoDAO();
    final IControladorStock CS = new ControladorStock();

    public int guardar(InsumoBruto insumo);

    public InsumoBruto getInsumo(int id);

    public void actualizar(InsumoBruto insumo);

    public void eliminar(InsumoBruto insumo);

    public void recuperar(InsumoBruto insumo);

    public List<InsumoBruto> getTodosStockMinimo();

    public List<InsumoBruto> getTodosByCategoriaByNombreSinEstos(int idCategoria, String nombreInsumo, List<Integer> ids, boolean activo);

    public List<InsumoBruto> buscar(String nombreFiltro, int categoriaInsumoFiltro);

    public boolean nombreDisponible(InsumoBruto insumo);

    public int enUso(InsumoBruto insumo);

}
