<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-modificar-insumo-bruto" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <form id="modificar-insumo-bruto-form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modificar Insumo</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="hidden" id="id" name="id">
                            <div class="form-group">
                                <label for="nombre">Nombre *</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" autocomplete="off" autofocus="autofocus" maxlength="100">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label for="precioUnidad">Precio *</label>
                                <input  class="form-control numeric" id="precioUnidad" name="precioUnidad" placeholder="Precio por unidad" autocomplete="off" maxlength="10">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label for="categoria" name="categoria">Categoria de Insumo *</label>
                                <div class="form-group">
                                    <s:select list="categorias" id="categoriaInsumo" name="categoriaInsumo.id" listKey="id" listValue="nombre" cssClass="form-control"/>
                                    <span class="help-block"></span>
                                </div>
                            </div>
                            <s:include value="/WEB-INF/unidadMedida/unidades.jsp"/>
                            <div class="form-group">
                                <label for="cantidadMinima">Cantidad Mínima *</label>
                                <input class="form-control numeric-nodot" id="cantidadMinima" name="stock.cantidadMinima" placeholder="Cantidad mínima" autocomplete="off" maxlength="10">
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left cancelar" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-ruhaj confirmar">Aceptar</button>
                </div>
            </form>
        </div>
    </div>
</div>
