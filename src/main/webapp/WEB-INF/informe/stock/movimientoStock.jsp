<%@taglib uri="/struts-tags" prefix="s" %>
<input type="hidden" value="<s:property value="insumo.id"/>" id="idInsumo"/>
<h2 class="page-header">
    Movimientos de Insumo
</h2>
<div class="panel panel-info">
    <div class="panel-heading">
        <i class="fa fa-info-circle"></i>
        <s:property value="insumo.nombre"/>
    </div>
    <div class="panel-body">
        <div class="col-md-4">
            <label class="">Cantidad Actual:</label>
            <s:if test="insumo.stock.cantidadActual < 0">
                <span class="text-danger"><strong>
                        <s:property value="insumo.stock.cantidadActual"/>
                    </strong>
                </span>
            </s:if><s:else>
                <s:if test="insumo.stock.cantidadActual <= insumo.stock.cantidadMinima">
                    <span class="text-amarillo"><strong>
                            <s:property value="insumo.stock.cantidadActual"/>
                        </strong>
                    </span >
                </s:if><s:else>
                    <s:property value="insumo.stock.cantidadActual"/>
                </s:else>
            </s:else>
        </div>
        <div class="col-md-4">
            <label class="">Cantidad Mínima:</label>
            <s:property value="insumo.stock.cantidadMinima"/>
        </div>
        <div class="col-md-4">
            <label class="">Unidad:</label>
            <s:property value="insumo.unidadMedida"/>
        </div>
    </div>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="form-inline">
            <div class="form-group">
                <label>Tipo Movimiento:</label>
                <s:select headerKey="-1" headerValue="Total" list="movimientos" id="movimiento" cssClass="form-control"/>
            </div>
        </div>
    </div>
    <div class="panel-body">
        <div id="grafico" class="sombra"></div>					
    </div>
</div>