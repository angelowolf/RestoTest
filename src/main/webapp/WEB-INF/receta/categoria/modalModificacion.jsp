<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-modificar-categoria" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-center ">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Editar Categoria de Insumo</h4>
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
                        <form id="modificar-categoria-form">
                            <input type="hidden" id="id" name="id">
                            <div class="form-group">
                                <label class="control-label" for="nombre">Nombre de Categoria *</label>
                                <input maxlength="100" type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="descrpcion">Descripción</label>
                                <textarea maxlength="255" class="form-control" id="descripcion" name="descripcion"></textarea>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" id="cancelarEditar" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-ruhaj" id="editar">Guardar</button>
            </div>
        </div>
    </div>
</div>
