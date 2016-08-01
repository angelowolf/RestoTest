<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-modificar-categoria" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center ">
        <div class="modal-content">
            <form id="modificar-categoria-form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Modificr Categoría de Insumo</h4>
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
                                <label class="control-label" for="nombre">Nombre de Categoria *</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" maxlength="100" autocomplete="off" autofocus="autofocus">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="descrpcion">Descripción</label>
                                <textarea class="form-control" id="descripcion" name="descripcion" maxlength="255" autocomplete="off"></textarea>
                                <span class="help-block"></span>
                            </div>
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
