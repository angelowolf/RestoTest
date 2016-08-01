<%@taglib uri="/struts-tags" prefix="s" %>
<li class="dropdown" id="contenedor-notificacion">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <i class="fa fa-bell fa-fw"></i><span class="badge" id="panel-notificaciones-cantidad"><s:if test="cantidad != 0"><s:property value="cantidad"/></s:if></span>  <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-messages dropdown-menu-right" id="panel-notificaciones">
        <s:if test="lista != null">
            <s:if test="lista.isEmpty()">
                <div class="text-center">
                    <h3><i class="fa fa-bell-slash-o fa-lg"></i></h3>
                    <strong>No posees notificaciones</strong>
                </div>
            </s:if>
            <s:iterator value="lista" var="notificacion">
                <li class="notificacion<s:if test="%{!#notificacion.visto}"> novisto</s:if>">
                    <div class="circulo-notificacion" data-id="<s:property value="%{#notificacion.id}"/>"> </div>
                    <a href='<s:url action="ver" namespace="/informe/stock"><s:param name="id" value="%{#notificacion.insumo.id}"/></s:url>'>
                            <div>
                                <i class='fa fa-<s:property value="%{#notificacion.tipoMensaje.getIcono()}"/>  fa-fw'></i> <s:property value="%{#notificacion.mensaje}"/><span class='pull-right text-muted small'><s:property value="%{#notificacion.fecha2}"/></span>
                        </div>
                    </a>
                </li>
            </s:iterator>
        </s:if>
        <li class='divider'></li>
        <li >
            <a class="text-center" href="<s:url action="listar" namespace="/notificacion"/>">
                <strong>Ver todas</strong>
                <i class="fa fa-angle-right"></i>
            </a>
        </li>
    </ul>
    <!-- /.dropdown-alerts -->
</li>