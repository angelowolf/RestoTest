<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Configuracion Cuenta</title>
        <link rel="shortcut icon" href="/imagenes/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/imagenes/favicon.ico" type="image/x-icon">
        <link href="/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='/bower_components/bootstrap/dist/css/bootstrap.css' rel='stylesheet' type='text/css'>
        <link href="/css/vendor/bootstrap-select.min.css" rel="stylesheet" type="text/css">
        <link href='/css/login.css' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-offset-3 col-lg-6 col-sm-offset-2 col-sm-8 col-xs-12 vcentered">
                    <form id="primer-login-form" method="POST">
                        <div class="panel">
                            <div class="panel-body">
                                <h4>Bienvenido a Ruhaj!</h4>
                                <p>Hola! como esta es la primera vez que ingresas al sistema te vamos a pedir que selecciones y des una respuesta a la "Pregunta Secreta" de tu cuenta, la misma te será solicitada en el caso de que olvides tu contraseña.</p>
                                <hr />
                                <s:include value="/WEB-INF/usuario/preguntasSecretas.jsp"/>
                                <div class="form-group">
                                    <label for="respuestaSecreta" class="control-label">Respuesta Secreta</label>
                                    <input type="text" class="form-control" id="respuestaSecreta" name="respuestaSecreta" placeholder="Tu Respuesta Secreta" autofocus="autofocus" autocomplete="off">
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 text-left">
                                        <button class="btn btn-default">
                                            <i class="fa fa-chevron-left fa-fw"></i>
                                            Volver
                                        </button>
                                    </div>
                                    <div class="col-xs-6 text-right">
                                        <button id="btn" class="btn btn-ruhaj confirmar" type="submit">
                                            Listo
                                            <i class="fa fa-thumbs-up fa-fw"></i>
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
    <script type="text/javascript" src="/js/vendor/bootstrap-select.min.js"></script>

    <script type="text/javascript" src="/js/admin.js"></script>
    <script type="text/javascript" src="/js/usuario/primerLogin.js"></script>
</html>
