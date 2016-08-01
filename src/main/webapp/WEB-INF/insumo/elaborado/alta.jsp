<%@taglib uri="/struts-tags" prefix="s"%>

<div class="col-lg-offset-1 col-lg-10 col-sm-offset-2 col-sm-8 col-xs-12">
    <div class="panel panel-ruhaj">
        <form id="alta-insumo-elaborado-form">
            <div class="panel-heading">
                <h3 class="panel-title">Nueva Elaboración</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-12">
                        <p><strong>NOTA:</strong> Los campos marcados con (*) son obligatorios y por lo tanto deben ser completados.</p>
                    </div>
                </div>
                <br />
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="nombre" class="control-label">Nombre *</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre" maxlength="100" autocomplete="off" autofocus="autofocus">
                            <span class="help-block"></span>
                        </div>
                        <s:include value="/WEB-INF/unidadMedida/unidades.jsp"/>
                        <div class="form-group">
                            <label for="cantidadActual" class="control-label">Cantidad Actual *</label>
                            <input type="text" class="form-control numeric-nodot" id="cantidadActual" name="stock.cantidadActual" placeholder="Cantidad actual" maxlength="5" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label for="cantidadMinima" class="control-label">Cantidad Mínima *</label>
                            <input type="text" class="form-control numeric-nodot" id="cantidadMinima" name="stock.cantidadMinima" placeholder="Cantidad mínima" maxlength="5" autocomplete="off">
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="fechaAlta">Fecha Alta</label>
                            <input type="text" class="form-control" id="fechaAlta" disabled autocomplete="off" tabindex="-1">
                        </div>
                        <s:include value="/WEB-INF/insumo/elaborado/detalleInsumo.jsp"/>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-xs-6 text-left">
                        <button class="btn btn-default cancelar" type="button">
                            Cancelar
                        </button>
                    </div>
                    <div class="col-xs-6 text-right">
                        <button class="btn btn-ruhaj confirmar" type="submit">
                            Aceptar</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>