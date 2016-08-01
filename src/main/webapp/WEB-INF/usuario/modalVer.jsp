<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-ver-usuario" tabindex="-1" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Usuario</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <input type="hidden" id="id" name="id">
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Nombre: </strong><p id="nombre"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Apellido: </strong><p id="apellido"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Fecha de Nacimiento: </strong><p id="fechaNacimiento"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Documento: </strong><p id="documento"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Teléfono: </strong><p id="telefono"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Dirección: </strong><p id="direccion"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Fecha de Alta: </strong><p id="fechaAlta"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Fecha de Baja: </strong><p id="fechaBaja"></p>
                    </div>
                    <div class="col-xs-12 col-md-6 text-inline">
                        <strong>Nombre de Usuario: </strong><p id="nick"></p>
                    </div>
                    <div class="col-xs-12 text-inline">
                        <strong>Roles:&nbsp;&nbsp;</strong><p id="roles-ver"></p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-right" id="salir" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>    
</div>    
