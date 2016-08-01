<%@taglib uri="/struts-tags" prefix="s"%>
<div class="col-lg-offset-1 col-lg-10 col-sm-offset-2 col-sm-8 col-xs-12">
    <div class="panel panel-ruhaj">
        <form id="alta-usuario-form">
            <div class="panel-heading">
                <h3 class="panel-title">Nuevo Usuario</h3>
            </div>
            <div class="panel-body"> 
                <div class="row">
                    <div class="col-xs-12">
                        <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="nombre">Nombre *</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" maxlength="100" autocomplete="off" autofocus="autofocus">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="apellido">Apellido *</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" maxlength="100" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="documento">Documento *</label>
                            <input type="text" class="form-control numeric-nodot" id="documento" name="documento" placeholder="Documento" maxlength="10" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
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
                            <input type="tel" class="form-control numeric-nodot" id="telefono" name="telefono" placeholder="Teléfono" maxlength="100">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="direccion">Dirección</label>
                            <input type="text" class="form-control" id="direccion" name="direccion" placeholder="Dirección" maxlength="255" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-6">
                        <div class="form-group">
                            <label class="control-label" for="fechaAlta">Fecha Alta</label>
                            <input type="text" class="form-control" id="fechaAlta" disabled autocomplete="off" tabindex="-1">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="nick">Nombre de Usuario *</label>
                            <input type="text" class="form-control" id="nick" name="nick" placeholder="Nombre de Usuario" maxlength="200" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
                        <s:include value="/WEB-INF/rol/roles.jsp"/>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-xs-6 text-left">
                        <button class="btn btn-default cancelar" type="button">Cancelar</button>
                    </div>
                    <div class="col-xs-6 text-right">
                        <button class="btn btn-ruhaj confirmar" type="submit">Aceptar</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>