<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2 class="page-header">Ajuste de Stock</h2>
<div class="col-md-12">
    <div class="col-md-10">
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
            <form id="datos">
                <display:table name="listaTodos" pagesize="0" requestURI="${listar}" uid="row" decorator="Decorator.RowCategoriaIdDecorator">
                    <display:setProperty name="basic.msg.empty_list" ><p id="notificacion">No se encontraron insumos por debajo del stock mínimo.</p></display:setProperty>
                    <display:column property="nombre" title="Nombre" class="text-center-all col-md-2" headerClass="text-center-all"/>            
                    <display:column property="categoriaInsumo.nombre" title="Categoria" class="text-center-all col-md-2" headerClass="text-center-all" />            
                    <display:column property="unidadMedida" title="Unidad de Medida" class="text-center-all col-md-2" headerClass="text-center-all"/>

                    <display:column title="Stock Actual" class="text-center-all col-md-1" headerClass="text-center-all"   >
                        <input type="number" class="form-control text-center" value="<s:property value="%{#attr.row.stock.cantidadActual}"/>" disabled="true"/>
                    </display:column>
                    <display:column title="Stock Real" class="text-center-all col-md-1" headerClass="text-center-all"   >
                        <input type="number" min="0" name="cantidad" class="form-control text-center" disabled="true"/>
                    </display:column>
                    <display:column title="Diferencia" class="text-center-all col-md-1" headerClass="text-center-all"   >
                        <input type="number" name="diferencia" class="form-control text-center" disabled="true"/>
                    </display:column>

                    <display:column title="Seleccionar" class="text-center-all col-md-1" headerClass="text-center-all"   >
                        <div class="checkbox tamaño-medio">
                            <label>
                                <input type="checkbox" id="<s:property value="%{#attr.row.id}"/>">
                            </label>
                        </div>
                    </display:column>
                </display:table>
            </form>
        </div>
    </div>
    <div class="col-md-2">
        <div class="panel panel-default">
            <div class="panel-heading">Insumos seleccionados</div>
            <div class="panel-body">
                <ul id="lista">

                </ul>
            </div>
        </div>
    </div>
</div>
<hr>
<div id="botones" class="form-group">
    <button type="submit" id="cancelar" class="btn btn-default pull-left">Cancelar</button>
    <button type="submit" id="registrar" class="btn btn-success pull-right">Registrar</button>
</div>