<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/struts-tags" prefix="s"%>
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