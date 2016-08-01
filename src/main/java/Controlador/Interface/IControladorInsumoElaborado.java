/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Controlador.Implementacion.ControladorStock;
import Modelo.InsumoElaborado;
import Persistencia.ORM.DAOImplementacion.InsumoElaboradoDAO;
import Persistencia.ORM.DAOInterface.IInsumoElaborado;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorInsumoElaborado {

    IInsumoElaborado InsumoElaboradoDAO = new InsumoElaboradoDAO();
    final IControladorStock CS = new ControladorStock();

    public List<InsumoElaborado> buscar(String nombreFiltro);

    public void eliminar(InsumoElaborado insumoElaborado);

    public int guardar(InsumoElaborado insumoElaborado, List<Integer> ids, List<Float> cantidades);

    public void actualizar(InsumoElaborado insumoElaborado, List<Integer> ids, List<Float> cantidades);

    public InsumoElaborado getInsumo(int id);

    public void recuperar(InsumoElaborado insumoElaborado);

    public boolean nombreDisponible(InsumoElaborado insumoElaborado);

    public void confeccionar(InsumoElaborado insumoElaborado, float cantidadConfeccionarInsumo);

}
