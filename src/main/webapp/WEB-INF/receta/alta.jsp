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