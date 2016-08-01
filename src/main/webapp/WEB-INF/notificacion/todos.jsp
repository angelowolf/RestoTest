<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<div class="form-group">   
    <h2 class="page-header">Notificaciones</h2>
    <div class=" col-md-12">
        <display:table name="lista" pagesize="20" requestURI="${listar}" uid="row" keepStatus="true">
            <display:setProperty name="basic.msg.empty_list" ><p id="notificacion">No se encontraron Notificaciones.</p></display:setProperty>
            <display:column sortable="true" property="mensaje" title="Mensaje" class="text-center-all" headerClass="text-center-all"/>            
            <display:column sortable="true" property="visto" title="Vista" decorator="Decorator.NotificacionVistaDecorator" class="text-center-all" headerClass="text-center-all"/>
            <display:column sortable="true" property="fecha" title="Fecha" decorator="Decorator.DateTimeDecorator" class="text-center-all" headerClass="text-center-all"/>
            <display:column title="Acciones" class="text-center-all" headerClass="text-center-all">
                <div id="botones">
                    <s:hidden name="id" value="%{#attr.row.id}"/>
                    <s:if test="(!#attr.row.visto)">
                        <button id="visto" class="btn btn-info  "><i class="fa fa-eye"></i></button>
                        </s:if>
                    <button id="modaleliminar" class="btn btn-danger"><i class="fa fa-close"></i></button>
                </div>
            </display:column>
        </display:table>
    </div>
</div>
<s:set var="objeto" value="#application.mensaje.NOTIFICACION"/>
<s:include value="/WEB-INF/modal/modal.jsp">
    <s:param name="titulo"><s:property value="#objeto"/></s:param>
    <s:param name="mensaje"><s:property value="#application.mensaje.getPreguntaEliminarLa(#objeto)"/></s:param>
    <s:param name="modelo">notificacion</s:param>
</s:include>