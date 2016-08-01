<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-editar" tabindex="-1" role="dialog" aria-labelledby="Editar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Editar Insumo</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <%@taglib uri="/struts-tags" prefix="s"%>
                    <form id="formulario" autocomplete="off">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                        <label for="categoria" name="categoria">Categoria de Insumo</label>
                        <s:select headerKey="-1" headerValue="Seleccione una categoria" list="categorias" id="categoriaReceta" name="categoriaReceta.id" listKey="id" listValue="nombre" cssClass="form-control"/>
                        <s:include value="/WEB-INF/receta/detalleRecetas.jsp"/>
                        <s:include value="/WEB-INF/receta/detalleIngredientes.jsp"/>
                        <button type="submit" id="cancelar" class="btn btn-default pull-left">Cancelar</button>
                        <button type="submit" id="registrar" class="btn btn-success pull-right">Registrar</button>
                    </form>           
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" id="cancelarEditar" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-success" id="editar">Guardar</button>
            </div>
        </div>
    </div>    
</div>    
