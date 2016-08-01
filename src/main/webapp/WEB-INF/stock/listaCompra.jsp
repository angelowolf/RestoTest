<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2 class="page-header">Lista de Compras</h2>
<div class="panel panel-default" id="contenedor">
    <div class="panel-heading">
        <form class="form-inline">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del insumo">
            </div>
        </form>
    </div>  

    <form>
        <display:table name="lista" pagesize="0" requestURI="${listar}" uid="row" decorator="Decorator.RowInsumoIdDecorator">
            <display:setProperty name="basic.msg.empty_list" ><p id="notificacion">No se encontraron insumos por debajo del stock mínimo.</p></display:setProperty>
            <display:column property="nombre" title="Nombre" class="text-center-all" headerClass="text-center-all"/>            
            <display:column property="categoriaInsumo.nombre" title="Categoria" class=" text-center-all" headerClass="text-center-all"/>            
            <display:column property="unidadMedida" title="Unidad de Medida" class="text-center-all" headerClass="text-center-all"/>
            <display:column property="precioUnidad" title="Precio por Unidad" format="$ {0,number,.00}" class="text-center-all" headerClass="text-center-all"/>
            <display:column property="stock.cantidadActual" title="Cantidad Actual" class="text-center-all" headerClass="text-center-all"/>            
            <display:column property="stock.cantidadMinima" title="Cantidad Mínima" class="text-center-all" headerClass="text-center-all"/>            
            <display:column title="Cantidad a Comprar" class="text-center-all" headerClass="text-center-all">
                <div class="form-group">
                    <input min="0" type="number" class="form-control" id="cantidad" name="cantidad" placeholder="Cantidad a comprar">
                </div>
            </display:column>
            <display:column title="Quitar" class="text-center-all" headerClass="text-center-all">
                <button id="quitar" class="btn btn-danger"><i class="fa fa-close"></i></button>            
                </display:column>
            </display:table>     
    </form>
</div>
<hr>
<div id="botones" class="form-group">
    <button type="submit" id="cancelar" class="btn btn-default pull-left">Cancelar</button>
    <button type="submit" id="imprimir" class="btn btn-success pull-right">Imprimir</button>
</div>