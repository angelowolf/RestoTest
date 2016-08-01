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
                    <div class="panel">
                        <form  action="/obtenerPregunta" method="POST" id="recuperar-contraseña-form">
                            <div class="panel-body">
                                <div class="col-lg-5 col-sm-6 col-xs-12 text-center">
                                    <img src="/imagenes/favicon.ico" class="logo center-block">
                                </div>
                                <div class="col-lg-7 col-sm-6 col-xs-12">
                                    <br />
                                    <h4>Recuperar Contraseña</h4>
                                    <p>Ingresa el nombre de usuario de tu cuenta</p>
                                    <div class="form-group">
                                        <label for="nick" class="control-label">Nombre de Usuario</label>
                                        <div class="input-group">
                                            <input class="form-control" type="text" name="nick" placeholder="Nombre de Usuario" required autocomplete="off" autofocus="autofocus" value='<s:property value="usuario.nick" />' />
                                            <div class="input-group-btn">
                                                <button class="btn btn-ruhaj" type="submit">
                                                    Continuar
                                                    <i class="fa fa-chevron-right"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <small class="forgotpass">
                                            <i class="fa fa-chevron-left fa-fw"></i>
                                            <a href="/logear">Volver al Ingreso del Sistema</a>
                                        </small>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <s:action name="alerta" namespace="/modal" executeResult="true">
                        <s:param name="tipoAlerta"><%out.println(Soporte.Mensaje.TIPODANGER);%></s:param>
                    </s:action>
                </div>
            </div>
        </div>
    </body>
</html>
