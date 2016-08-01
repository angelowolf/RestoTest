<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-confeccionar-insumo-elaborado"  role="dialog" data-backdrop="static">
   <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <form id="confeccionar-insumo-elaborado-form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confeccionar Elaboración</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-12">
                            <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                        </div>
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-xs-12 text-inline">
                            <strong>Nombre:</strong> <p id="nombre"></p>
                        </div>
                        <div class="col-xs-12 text-inline">
                            <strong>Unidad de Medida:</strong> <p id="unidadMedida"></p>
                        </div>
                        <div class="col-xs-12 text-inline">
                            <strong>Cantidad Actual:</strong> <p id="cantidadActual"></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <input type="hidden" id="id" name="id">
                            <div class="form-group">
                                <label for="cantidadConfeccionarInsumo" class="control-label">Cantidad a Confeccionar</label>
                                <input class="form-control numeric" type="text" id="cantidad-insumo-a-confeccionar" name="cantidadConfeccionarInsumo"/>
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <h4>Cantidades a descontar del stock: </h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="table-responsive">
                            <table class="table table-striped table-condensed">
                                <thead>
                                    <tr>
                                        <th class="table-header-ruhaj">Nombre</th>
                                        <th class="table-header-ruhaj">Cantidad a Utilizar</th>
                                        <th class="table-header-ruhaj">Unidad de Medida</th>
                                    </tr>
                                </thead>
                                <tbody id="confeccionar-detalle-insumo-elaborado">
                                </tbody>
                            </table>
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
