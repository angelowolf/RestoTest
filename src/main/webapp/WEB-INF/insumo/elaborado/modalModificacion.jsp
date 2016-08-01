<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-modificar-insumo-elaborado" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <form id="modificar-insumo-elaborado-form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Modificar Elaboración</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                        </div>
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="hidden" id="id" name="id">
                            <div class="form-group">
                                <label for="nombre" class="control-label">Nombre *</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" maxlength="100" autocomplete="off">
                                <span class="help-block"></span>
                            </div>
                            <s:include value="/WEB-INF/unidadMedida/unidades.jsp"/>
                            <div class="form-group">
                                <label for="cantidadMinima" class="control-label">Cantidad Mínima *</label>
                                <input type="number" min="0" class="form-control numeric-nodot" id="cantidadMinima" name="stock.cantidadMinima" placeholder="Cantidad mínima" maxlength="10" autocomplete="off">
                                <span class="help-block"></span>
                            </div>
                            <s:include value="/WEB-INF/insumo/elaborado/detalleInsumo.jsp"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left cancelar" data-dismiss="modal">
                        Cancelar
                    </button>
                    <button type="submit" class="btn btn-ruhaj confirmar">
                        Aceptar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
