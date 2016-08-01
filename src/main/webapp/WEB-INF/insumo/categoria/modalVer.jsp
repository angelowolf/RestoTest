<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-ver-categoria" tabindex="-1" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Categoría de Insumo</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <input type="hidden" id="id" name="id">
                    <div class="col-xs-12 text-inline">
                        <strong>Nombre: </strong><p id="nombre"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Descripcion: </strong><p id="descripcion"></p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-right cancelar" data-dismiss="modal">
                    Cancelar
                </button>
            </div>
        </div>
    </div>
</div>
