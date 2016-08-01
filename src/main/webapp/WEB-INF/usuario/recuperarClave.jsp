<%-- 
    Document   : recuperarClave
    Created on : 11/05/2016, 14:39:52
    Author     : ang_2
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Recuperar Contraseña</title>
        <link rel="shortcut icon" href="/imagenes/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/imagenes/favicon.ico" type="image/x-icon">
        <link href="/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='/bower_components/bootstrap/dist/css/bootstrap.css' rel='stylesheet' type='text/css'>
        <link href='/css/login.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-offset-3 col-lg-6 col-sm-offset-2 col-sm-8 col-xs-12 vcentered">
                    <form id="cambiar-contraseña-form" method="POST">
                        <div class="panel">
                            <div class="panel-body">
                                <input type="hidden" id="id" name="id" value='<s:property value="usuario.id"/>'>
                                <div class="form-group">
                                    <label class="control-label" for="clave">Nueva Contraseña</label>
                                    <input required  type="password" class="form-control" id="clave" name="clave" placeholder="Nueva Contraseña" autocomplete="off" autofocus="autofocus">
                                    <span class="help-block"></span>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="clave2">Repite la Nueva Contraseña</label>
                                    <input type="password" required  class="form-control" id="clave2" name="clave2" placeholder="Repite la Nueva Contraseña" autocomplete="off">
                                    <span class="help-block"></span>
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-xs-6 text-left">
                                        <a class="btn btn-default" href="/recuperar">
                                            <i class="fa fa-chevron-left fa-fw"></i>
                                            Volver
                                        </a>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <button type="submit" id="guardar" class="btn btn-ruhaj pull-right">
                                            <i class="fa fa-lock fa-fw"></i>
                                            Cambiar Contraseña
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="/js/vendor/jquery.min.js"></script>
    <script type="text/javascript" src="/js/vendor/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/admin.js"></script>
    <script type="text/javascript" src="/js/usuario/recuperarClave.js"></script>
</html>
