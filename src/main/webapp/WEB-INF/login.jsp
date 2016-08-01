<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ingreso al Sistema</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
                    <div class="panel">
                        <div class="panel-body">
                            <div class="col-lg-5 col-sm-6 col-xs-12 text-center">
                                <img src="/imagenes/favicon.ico" class="logo center-block">
                            </div>
                            <div class="col-lg-7 col-sm-6 col-xs-12">
                                <br />
                                <form id="login-form" action="/login" method="POST">
                                    <div class="form-group">
                                        <label for="nick">Nombre de Usuario</label>
                                        <input class="form-control" type="text" id="nick" name="nick" placeholder="Tu Nombre de Usuario" required autocomplete="off" autofocus="autofocus" />
                                    </div>
                                    <div class="form-group">
                                        <label for="clave">Contraseña</label>
                                        <div class="input-group">
                                            <input class="form-control" type="password" id="clave" name="clave" placeholder="Tu Contraseña" required autocomplete="off" />
                                            <div class="input-group-btn">
                                                <button class="btn btn-ruhaj" type="submit">
                                                    Ingresar
                                                    <i class="fa fa-chevron-right"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <small class="forgotpass">
                                            <i class="fa fa-bell fa-fw"></i>
                                            <a id="recover-link" href="/recuperar?nick=">¿Olvidaste la contraseña?</a>
                                        </small>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <s:actionerror theme="bootstrap"/>
                </div>
            </div>
        </div>

        <script src="/js/vendor/jquery.min.js" type="text/javascript"></script>
        <script src="/js/vendor/bootstrap.min.js" type="text/javascript"></script>
        <script src="/js/login.js" type="text/javascript"></script>
    </body>
</html>