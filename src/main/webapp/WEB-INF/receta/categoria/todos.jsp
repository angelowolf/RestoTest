<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<div class="panel panel-ruhaj">
    <div class="panel-heading">
        <h3 class="panel-title">Listado de Categorias Recetas</h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-xs-12">
                <s:form class="form-inline" action="listar" namespace="/receta/categoria" id="formulario-buscar" autocomplete="off">
                    <div class="form-group">
                        <label for="nombre">Nombre de Categoria</label>
                        <s:textfield type="text" class="form-control" id="nombre" name="nombreFiltro" placeholder="Nombre de Categoria"/>
                    </div>
                    <button type="submit" class="btn btn-ruhaj pull-right">Buscar</button>
                </s:form>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class=" col-xs-12 table-responsive">
                <display:table name="lista" pagesize="10" requestURI="${listar}" uid="row" keepStatus="true">
                    <display:setProperty name="basic.msg.empty_list" >
                        <p id="notificacion">No se encontraron Categorias.</p>
                    </display:setProperty>
                    <display:setProperty name="paging.banner.placement">bottom</display:setProperty>

                    <display:column sortable="true" property="nombre" title="Nombre" decorator="Decorator.LimitadorCaracteresDecorator" headerClass="table-header-ruhaj"/>
                    <display:column property="descripcion" title="Descripción" class="text-center" decorator="Decorator.LimitadorCaracteresDecorator" headerClass="table-header-ruhaj"/>
                    <display:column title="Acciones" class="text-center" headerClass="table-header-ruhaj">
                        <div id="botones">
                            <s:hidden name="id" value="%{#attr.row.id}"/>
                            <button id="mostrar-modal-ver-categoria" class="btn btn-default" title="Ver Categoria" data-toggle="tooltip"><i class="fa fa-eye"></i></button>
                            <button id="mostrar-modal-modificar-categoria" class="btn btn-warning" title="Editar Categoria" data-toggle="tooltip"><i class="fa fa-edit"></i></button>
                            <button id="mostrar-modal-eliminar-categoria" class="btn btn-danger" title="Eliminar Categoria" data-toggle="tooltip"><i class="fa fa-trash"></i></button>
                        </div>
                    </display:column>
                </display:table>
            </div>
        </div>
    </div>
</div>
<s:set var="objeto" value="#application.mensaje.CATEGORIARECETA"/>
<s:include value="/WEB-INF/modal/modal.jsp">
    <s:param name="titulo">Eliminar <s:property value="#objeto"/></s:param>
    <s:param name="mensaje"><s:property value="#application.mensaje.getPreguntaEliminarLa(#objeto)"/></s:param>
    <s:param name="modelo">categoria</s:param>
</s:include>
<s:include value="/WEB-INF/receta/categoria/modalModificacion.jsp"/>
<s:include value="/WEB-INF/receta/categoria/modalVer.jsp"/>