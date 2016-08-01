/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import Controlador.Interface.IControladorCategoriaInsumo;
import Controlador.Interface.IControladorInsumoBruto;
import Controlador.Interface.IControladorInsumoElaborado;
import Modelo.CategoriaInsumo;
import Modelo.InsumoBruto;
import Modelo.InsumoElaborado;
import Modelo.Stock;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;

/**
 *
 * @author ang_2
 */
public class ControladorInsumoElaborado implements IControladorInsumoElaborado {

    @Override
    public List<InsumoElaborado> buscar(String nombreFiltro) {
        if (StringUtils.isBlank(nombreFiltro)) {
            nombreFiltro = null;
        }
        return InsumoElaboradoDAO.getTodosByNombreSinEstos(nombreFiltro, null, false);
    }

    @Override
    public void eliminar(InsumoElaborado insumoElaborado) {
        InsumoElaborado insumoEnBD = this.getInsumo(insumoElaborado.getId());
        insumoEnBD.darDeBaja();
        InsumoElaboradoDAO.actualizar(insumoEnBD);
    }

    @Override
    public int guardar(InsumoElaborado insumoElaborado, List<Integer> ids, List<Float> cantidades) {
        Stock s = insumoElaborado.getStock();
        s.nuevoInsumo();
        CS.guardar(s);
        IControladorCategoriaInsumo icci = new ControladorCategoriaInsumo();
        CategoriaInsumo ci = icci.buscarTodos("Elaborado").get(0);
        insumoElaborado.setFechaAlta(new LocalDate());
        insumoElaborado.setCategoriaInsumo(ci);
        IControladorInsumoBruto controladorInsumoBruto = new ControladorInsumoBruto();
        for (int i = 0; i < ids.size(); i++) {
            InsumoBruto ib = controladorInsumoBruto.getInsumo(ids.get(i));
            insumoElaborado.agregarInsumoBruto(ib, cantidades.get(i));
        }
        return InsumoElaboradoDAO.guardar(insumoElaborado);
    }

    @Override
    public void actualizar(InsumoElaborado insumoElaborado, List<Integer> ids, List<Float> cantidades) {
        List<InsumoBruto> insumosRequest = new ArrayList<>();
        InsumoElaborado insumoEnBd = this.getInsumo(insumoElaborado.getId());
        IControladorInsumoBruto controladorInsumoBruto = new ControladorInsumoBruto();
        for (int i = 0; i < ids.size(); i++) {
            InsumoBruto ib = controladorInsumoBruto.getInsumo(ids.get(i));
            insumosRequest.add(ib);
        }
        insumoElaborado.setCategoriaInsumo(insumoEnBd.getCategoriaInsumo());
        insumoEnBd.actualizar(insumoElaborado, insumosRequest, cantidades);
        InsumoElaboradoDAO.actualizar(insumoEnBd);
    }

    @Override
    public InsumoElaborado getInsumo(int id) {
        return InsumoElaboradoDAO.buscar(id);
    }

    @Override
    public void recuperar(InsumoElaborado insumoElaborado) {
        InsumoElaborado insumoEnBD = this.getInsumo(insumoElaborado.getId());
        insumoEnBD.recuperar();
        InsumoElaboradoDAO.actualizar(insumoEnBD);
    }

    @Override
    public boolean nombreDisponible(InsumoElaborado insumo) {
        InsumoElaborado insumoBd = InsumoElaboradoDAO.buscar(insumo.getNombre());
        if (insumoBd == null) {
            return true;
        }
        return insumoBd.getId() == insumo.getId();
    }

    @Override
    public void confeccionar(InsumoElaborado insumoElaborado, float cantidadConfeccionarInsumo) {
        InsumoElaborado insumoBD = InsumoElaboradoDAO.buscar(insumoElaborado.getId());
        insumoBD.confeccionar(cantidadConfeccionarInsumo);
    }
}
