<%@page import="Decorator.RolDecorator"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="modal fade" id="modal-modificar-perfil" tabindex="-1" role="dialog" data-backdrop="static">
    <div class="modal-dialog modal-dialog-center">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Editar Perfil de Usuario</h4>
            </div>
            <form id="modificar-perfil-usuario-form" method="POST">
                <input type="hidden" id="id" name="id">
                <div class="modal-body">
                    <div class="row">
                        <div id="datos-perfil">
                            <div class="col-xs-12 col-md-4 text-inline">
                                <strong>Nombre: </strong><p id="nombre"></p>
                            </div>
                            <div class="col-xs-12 col-md-4 text-inline">
                                <strong>Apellido: </strong><p id="apellido"></p>
                            </div>
                            <div class="col-xs-12 col-md-4 text-inline">
                                <strong>Documento: </strong><p id="documento"></p>
                            </div>
                            <div class="col-xs-12 col-md-6 text-inline">
                                <strong>Roles:&nbsp;&nbsp;</strong><p id="roles"></p>
                            </div>
                            <hr />
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label class="control-label" for="fechaNacimiento">Fecha de Nacimiento</label>
                                    <div class="input-group date">
                                        <input type="text" class="form-control" id="fechaNacimiento" name="fechaNacimiento" placeholder="Fecha de Nacimiento" maxlength="11" autocomplete="off">
                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                    </div>
                                    <span class="help-block"></span>
                                </div>

                                <div class="form-group">
                                    <label class="control-label" for="telefono">Teléfono</label>
                                    <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Teléfono" maxlength="100">
                                    <span class="help-block"></span>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="direccion">Dirección</label>
                                    <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Dirección" autocomplete="off" maxlength="255">
                                    <span class="help-block"></span>
                                </div>
                                <button id="ver-datos-ingreso" class="btn btn-sm btn-default btn-block" type="button">
                                    Mostrar Datos de Ingreso
                                </button>
                            </div>
                        </div>
                        <div id="datos-ingreso" class="col-xs-12" style="display: none;">
                            <br />
                            <div class="row">
                                <div class="col-xs-12">
                                    <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                                </div>
                            </div>
                            <br />
                            <input type="hidden" id="preguntaSecretaOriginal" value="">
                            <div class="form-group">
                                <label class="control-label" for="nick">Nombre de Usuario *</label>
                                <input type="text" class="form-control" id="nick" name="nick" placeholder="Nombre de Usuario" autocomplete="off" maxlength="200" required="required">
                                <span class="help-block"></span>
                            </div>
                            <s:include value="/WEB-INF/usuario/preguntasSecretas.jsp"/>
                            <div class="form-group">
                                <label for="respuestaSecreta">Respuesta Secreta *</label>
                                <input type="text" class="form-control" id="respuestaSecreta" name="respuestaSecreta" placeholder="Respuesta Secreta" maxlength="50" autocomplete="off" maxlength="50" required="required">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label for="clave">Nueva Contraseña</label>
                                <input type="password" class="form-control" id="clave" name="clave" placeholder="Nueva Contraseña" autocomplete="off" maxlength="100">
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label for="clave2">Repite la Nueva Contraseña</label>
                                <input type="password" class="form-control" id="clave2" name="clave2" placeholder="Repite la Nueva Contraseña" autocomplete="off" maxlength="100">
                                <span class="help-block"></span>
                            </div>
                            <p><strong>PISTA:</strong> Rellena los campos de contraseña solo si deseas cambiarla.</p>
                        </div>
                        <div id="contraseña-actual" class="col-xs-12" style="display: none;">
                            <div class="form-group">
                                <label for="claveOriginal">Contraseña Actual</label>
                                <input type="password" class="form-control" id="claveOriginal" name="claveOriginal" placeholder="Contraseña Actual" autocomplete="off" maxlength="100">
                                <span class="help-block"></span>
                            </div>
                            <hr />
                            <p><strong>NOTA:</strong> Queremos asegurarnos de que eres TÚ, para ello te solicitamos que ingreses tu contraseña actual.</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-xs-6 text-left">
                            <button type="button" class="btn btn-default pull-left cancelar" data-dismiss="modal">Cancelar</button>
                        </div>
                        <div class="col-xs-6 text-right">
                            <button type="submit" class="btn btn-ruhaj confirmar">Aceptar</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>