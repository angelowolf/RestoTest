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
                        <div class="panel-body">
                            <form action="/verificarRespuesta" method="POST" id="verificar-pregunta-form">
                                <input type="hidden" id="id" name="id" value="<s:property value="usuario.id"/>">
                                <div class="form-group">
                                    <h4 id="preguntaSecreta"><s:property value="usuario.preguntaSecreta"/></h4>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <input required type="text" class="form-control" id="respuestaSecreta" name="respuestaSecreta" placeholder="Ingresa tu Respuesta Secreta" autocomplete="off" autofocus="autofocus">
                                        <div class="input-group-btn">
                                            <button class="btn btn-ruhaj" type="submit">
                                                Continuar
                                                <i class="fa fa-chevron-right fa-fw"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <span class="help-block"></span>
                                </div>
                                <div class="form-group">
                                    <small class="forgotpass">
                                        <i class="fa fa-chevron-left fa-fw"></i>
                                        <a href="/logear">Volver al Ingreso del Sistema</a>
                                    </small>
                                </div>
                                <hr />
                                <p><strong>NOTA:</strong> Para restablecer la contraseña deberás responder a la pregunta secreta que configuraste en el primer inicio de sesión. Si no la recuerdas comunícate con el Administrador.</p>
                            </form>
                        </div>
                    </div>
                    <s:action name="alerta" namespace="/modal" executeResult="true">
                        <s:param name="tipoAlerta"><%out.println(Soporte.Mensaje.TIPODANGER);%></s:param>
                    </s:action>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="/js/vendor/jquery.min.js"></script>
    <script type="text/javascript" src="/js/vendor/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/admin.js"></script>
</html>
