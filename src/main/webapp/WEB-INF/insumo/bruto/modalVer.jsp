<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-ver-insumo-bruto" tabindex="-1" role="dialog" data-backdrop="static" >
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Insumo</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <input type="hidden" id="id" name="id">
                    <div class="col-xs-12 text-inline">
                        <strong for="nombre">Nombre:</strong> <p id="nombre"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Precio:</strong> <p id="precioUnidad"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Categoria de Insumo:</strong> <p id="categoria"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Unidad de Medida:</strong> <p id="unidadMedida"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Cantidad Actual:</strong> <p id="cantidadActual"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Cantidad Mínima:</strong> <p id="cantidadMinima"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Fecha de Alta:</strong> <p id="fechaAlta"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Fecha de Baja:</strong> <p id="fechaBaja"></p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-right" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>
