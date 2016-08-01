/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Interface;

import Modelo.DetalleStock;
import Modelo.Stock;
import Modelo.TipoMovimiento;
import Persistencia.ORM.DAOImplementacion.DetalleStockDAO;
import Persistencia.ORM.DAOImplementacion.InsumoDAO;
import Persistencia.ORM.DAOImplementacion.StockDAO;
import Persistencia.ORM.DAOInterface.IDetalleStock;
import Persistencia.ORM.DAOInterface.IInsumo;
import Persistencia.ORM.DAOInterface.IStock;
import java.util.List;

/**
 *
 * @author ang_2
 */
public interface IControladorStock {

    final IStock STOCKDAO = new StockDAO();
    final IDetalleStock DETALLESTOCKDAO = new DetalleStockDAO();
    final IInsumo INSUMODAO = new InsumoDAO();

    public void eliminar(Stock stock);

    public void actualizar(Stock stock);

    public Stock getStock(int id);

    public void guardar(Stock stock);

    /**
     * registrar compra de insumos
     *
     * @param ids los insumos a registrar
     * @param cantidad las cantidad comprada, positiva
     * @param precio los precio pagada por la unidad de medida
     */
    public void registrarCompraInsumoBruto(List<Integer> ids, List<Float> cantidad, List<Float> precio);

    /**
     * registra para estos insumos un ajuste de stock.
     *
     * @param idInsumos los insumos a registrar
     * @param cantidades las cantidades a ajustar positivas o negativas segun el
     * caso
     */
    public void registrarAjuste(List<Integer> idInsumos, List<Float> cantidades);

    /**
     * Busca todos los detalles de stock para este insumo.
     *
     * @param id
     * @return
     */
    public List<DetalleStock> getDetalles(int id);

    /**
     * Busca todos los detalles de stock para este insumo y este movimiento.
     *
     * @param id
     * @param tipoMovimiento
     * @return
     */
    public List<DetalleStock> getDetalles(int id, TipoMovimiento tipoMovimiento);
}
