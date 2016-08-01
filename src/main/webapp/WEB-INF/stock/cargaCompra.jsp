<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2 class="page-header">Reponer Insumos</h2>
<div class="panel panel-default" id="contenedor">
    <div class="panel-heading ">
        <form class="form-inline">
            <div class="form-group">
                <label for="categoria">Categoria</label>
                <s:select headerKey="-1" headerValue="Todas" list="categorias" id="categoria" name="categoria" listKey="id" listValue="nombre" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del insumo">
            </div>
        </form>
    </div>        
    <display:table name="lista" pagesize="0" requestURI="${listar}" uid="row">
        <display:setProperty name="basic.msg.empty_list" ><p id="notificacion">No se encontraron insumos por debajo del stock mínimo.</p></display:setProperty>
        <display:column property="nombre" title="Nombre" class="text-center-all" headerClass="text-center-all"/>            
        <display:column property="categoriaInsumo.nombre" title="Categoría" class="text-center-all" headerClass="text-center-all"/>            
        <display:column property="unidadMedida" title="Unidad de Medida" class="text-center-all" headerClass="text-center-all"/>
        <display:column property="precioUnidad" title="Precio por Unidad" format="$ {0,number,.00}" class="text-center-all" headerClass="text-center-all"/>
        <display:column property="stock.cantidadActual" title="Cantidad Actual" class="text-center-all" headerClass="text-center-all"/>            
        <display:column property="stock.cantidadMinima" title="Cantidad Mínima" class="text-center-all" headerClass="text-center-all"/>            
        <display:column title="Agregar" class="text-center-all" headerClass="text-center-all"   >
            <button id="<s:property value="%{#attr.row.id}"/>" class="btn btn-info"><i class="fa fa-arrow-down"></i></button> 
            </display:column>
        </display:table>     
</div>
<hr>
<div class="panel panel-default" id="insumosComprados" style="display: none;">
    <div class="panel-heading">
        Insumos a Cargar
    </div>
    <form id="formulario-compra">
        <table class="table table-striped table-bordered" id="row2">
            <thead>
                <tr>
                    <th class="text-center-all">Nombre</th>
                    <th class="text-center-all">Categoría</th>
                    <th class="text-center-all">Unidad de Medida</th>
                    <th class="text-center-all">Precio por Unidad</th>
                    <th class="text-center-all">Cantidad Actual</th>
                    <th class="text-center-all">Cantidad Mínima</th>
                    <th class="text-center-all">Cantidad Comprada</th>
                    <th class="text-center-all">Precio Compra</th>
                    <th class="text-center-all">Remover</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </form>
</div>
<hr>
<div id="botones" class="form-group">
    <button type="submit" id="cancelar" class="btn btn-default pull-left">Cancelar</button>
    <button type="submit" id="registrar" class="btn btn-success pull-right">Registrar</button>
</div>