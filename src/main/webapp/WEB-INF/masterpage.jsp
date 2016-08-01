<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="stylesheet" />
<tiles:importAttribute name="javascript" />
<tiles:importAttribute name="main" />
<%
    HttpSession sesion = request.getSession();
    if (null == sesion.getAttribute("idUsuario")) {
        response.sendRedirect("/logear");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="shortcut icon" href="../imagenes/favicon.ico" type="image/x-icon">
        <link rel="icon" href="../imagenes/favicon.ico" type="image/x-icon">
        <s:iterator value="#attr.stylesheet" var="cascadeUrl">
            <link href='<s:url value="%{cascadeUrl}"/>' rel="stylesheet" type="text/css" >
        </s:iterator>
        <s:iterator value="#attr.main" var="headUrl">
            <script src='<s:url value="%{headUrl}"/>'></script>
        </s:iterator>
    </head>

    <body>
        <s:hidden value="%{#session.idUsuario}" id="idUsuarioHidden"/>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-ruhaj navbar-fixed-top" role="navigation" style="margin-bottom: 0">
                <a id="navbar-toggle-menu" class="closed"><i class="fa fa-bars fa-2x"></i></a>
                <ul class="nav pull-right navbar-top-links">
                    <s:action name="panel" namespace="/notificacion" executeResult="true"/>
                    <!-- /.dropdown-notificaciones -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>
                            <s:property value="%{#session.nombreCompletoUsuario}" />
                            <i class="fa fa-caret-down fa-fw"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li>
                                <a id="mostrar-modal-modificar-perfil" href='#'>
                                    <i class="fa fa-gear fa-fw"></i> Ver Mi Perfil
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href='<s:url action="logout" namespace="/"/>'>
                                    <i class="fa fa-sign-out fa-fw"></i> Cerrar sesión
                                </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-ruhaj sidebar closed" role="navigation">
                    <div class="sidebar-nav" id="menu-collapse">
                        <ul class="nav" id="side-menu">
                            <tiles:insertAttribute name="menu" />
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper" class="closed">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-12">
                            <s:action name="alerta" namespace="/modal" executeResult="true">
                                <s:param name="tipoAlerta"><s:property value="#application.mensaje.TIPOINFO"/></s:param>
                            </s:action>
                        </div> 
                        <!-- /.col-xs-12 -->
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-xs-12">
                            <tiles:insertAttribute name="body" />
                        </div>
                        <!-- /.col-xs-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <s:include value="/WEB-INF/usuario/modalPerfil.jsp"/>
        <s:iterator value="#attr.javascript" var="scriptUrl">
            <script src='<s:url value="%{scriptUrl}"/>'></script>
        </s:iterator>
    </body>
</html>
