/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Implementacion;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import Controlador.Interface.IControladorInsumoBruto;
import Modelo.InsumoBruto;
import Modelo.Stock;
import Persistencia.ORM.DAOImplementacion.InsumoElaboradoDAO;
import Persistencia.ORM.DAOImplementacion.RecetaDAO;
import Persistencia.ORM.DAOInterface.IInsumoElaborado;
import Persistencia.ORM.DAOInterface.IReceta;

/**
 *
 * @author ang_2
 */
public class ControladorInsumoBruto implements IControladorInsumoBruto {

    private static final Logger LOGGER = Logger.getLogger(ControladorInsumoBruto.class);

    @Override
    public int guardar(InsumoBruto insumo) {
        Stock s = insumo.getStock();
        s.nuevoInsumo();
        CS.guardar(s);
        insumo.setFechaAlta(new LocalDate());
        return INSUMODAO.guardar(insumo);
    }

    @Override
    public InsumoBruto getInsumo(int id) {
        return INSUMODAO.buscar(id);
    }

    @Override
    public void actualizar(InsumoBruto insumo) {
        InsumoBruto insumoEnBd = this.getInsumo(insumo.getId());
        insumoEnBd.actualizar(insumo);
        INSUMODAO.actualizar(insumoEnBd);
    }

    @Override
    public void eliminar(InsumoBruto insumo) {
        InsumoBruto insumoEnBD = this.getInsumo(insumo.getId());
        insumoEnBD.darDeBaja();
        INSUMODAO.actualizar(insumoEnBD);
    }

    @Override
    public void recuperar(InsumoBruto insumo) {
        InsumoBruto insumoEnBD = this.getInsumo(insumo.getId());
        insumoEnBD.recuperar();
        INSUMODAO.actualizar(insumoEnBD);
    }

    @Override
    public List<InsumoBruto> getTodosStockMinimo() {
        return INSUMODAO.getTodosStockMinimo();
    }

    @Override
    public List<InsumoBruto> getTodosByCategoriaByNombreSinEstos(int idCategoria, String nombreInsumo, List<Integer> ids, boolean activo) {
        if (StringUtils.isBlank(nombreInsumo) || nombreInsumo.equals("undefined")) {
            LOGGER.info("2");
            return INSUMODAO.getTodosByCategoriaByNombreSinEstos(idCategoria, null, ids, activo);
        } else {
            LOGGER.info("4");
            return INSUMODAO.getTodosByCategoriaByNombreSinEstos(idCategoria, WordUtils.capitalize(nombreInsumo), ids, activo);
        }
    }

    @Override
    public List<InsumoBruto> buscar(String nombreFiltro, int categoriaInsumoFiltro) {
        if (StringUtils.isBlank(nombreFiltro)) {
            nombreFiltro = null;
        }
        return INSUMODAO.getTodosByCategoriaByNombreSinEstos(categoriaInsumoFiltro, nombreFiltro, null, false);
    }

    @Override
    public boolean nombreDisponible(InsumoBruto insumo) {
        InsumoBruto insumoBd = INSUMODAO.buscar(insumo.getNombre());
        if (insumoBd == null) {
            return true;
        }
        return insumoBd.getId() == insumo.getId();
    }

    @Override
    public int enUso(InsumoBruto insumo) {
        IInsumoElaborado DAOElaborado = new InsumoElaboradoDAO();
        if (!DAOElaborado.insumoEnUso(insumo).isEmpty()) {
            return 1;
        } else {
            IReceta DAOReceta = new RecetaDAO();
            if (!DAOReceta.insumoEnUsoPorReceta(insumo).isEmpty()) {
                return 2;
            }
        }
        return 0;
    }
}
