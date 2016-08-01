<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-ver-insumo-elaborado" role="dialog" aria-labelledby="Editar" aria-hidden="true">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Insumo</h4>
            </div>
            <div class="modal-body">
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
                    <div class="col-xs-12 text-inline">
                        <strong>Cantidad Minima:</strong> <p id="cantidadMinima"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Fecha de Alta:</strong> <p id="fechaAlta"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Fecha de Baja:</strong> <p id="fechaBaja"></p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <h4>Receta: </h4>
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
                            <tbody id="ver-detalle-insumo-elaborado">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">
                    Cancelar
                </button>
            </div>
        </div>
    </div>
</div>
