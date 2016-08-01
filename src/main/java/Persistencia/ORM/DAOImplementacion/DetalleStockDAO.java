/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.ORM.DAOImplementacion;

import Modelo.DetalleStock;
import Modelo.TipoMovimiento;
import Persistencia.ORM.DAOInterface.IDetalleStock;
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
public class DetalleStockDAO extends GenericDAO<DetalleStock, Integer> implements IDetalleStock {

    private static final Logger LOG = Logger.getLogger(DetalleStockDAO.class);

    @Override
    public List<DetalleStock> getTodos(int id, TipoMovimiento tm) {
        Session session = getHibernateTemplate();
        List<DetalleStock> objetos = new ArrayList<>();
        try {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            if (tm != null) {
                sb.append("select d1.*  from detallestock d1 inner join ( select max(fecha) as max from detallestock  where tipoMovimiento = :tm group by date(fecha) ) d2 on d1.fecha = d2.max inner join stock s on s.id = d1.id_stock inner join insumo i on i.id_stock = s.id where i.id = :id and i.fechaBaja is null and d1.tipoMovimiento = :tm");
                flag = true;
            } else {
                sb.append("select d1.* from detallestock d1 inner join ( select max(fecha) as max from detallestock group by date(fecha) ) d2 on d1.fecha = d2.max inner join stock s on s.id = d1.id_stock inner join insumo i on i.id_stock = s.id where i.id = :id and i.fechaBaja is null ");
            }
            SQLQuery q = session.createSQLQuery(sb.toString()).addEntity(DetalleStock.class);
            q.setParameter("id", id);
            if (flag) {
                q.setParameter("tm", tm.toString());
            }
            objetos = q.list();
        } catch (RuntimeException e) {
            LOG.error("Error al buscar los insumos.", e);
        }
        return objetos;
    }

}
