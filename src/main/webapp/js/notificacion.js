var wsocket;
//var serviceLocation = "ws://restaurante-angelowolf.rhcloud.com:8000/wsnotificacion";
var serviceLocation = "ws://localhost:8080/wsnotificacion";

function mensajeRecibido(evt) {
    var mensaje = JSON.parse(evt.data);
    var tipo = mensaje.tipo + "";
    switch (tipo) {
        case 'LOGIN':
            {
                alert(mensaje.mensaje);
            }
            break;
        case 'OK':
            {
                console.log("logeado con exito.");
            }
            break;
        case 'NOTIFICACION_STOCK':
            {
                console.log(mensaje);
                var panelNotificaciones = $('#panel-notificaciones');
                var not = "<li class='novisto notificacion'> <div class='circulo-notificacion' data-id='" + mensaje.id + "'> </div><a href='/informe/stock/ver?id=" + mensaje.id_insumo + "'><div><i class='fa fa-shopping-basket fa-fw'></i>" + mensaje.mensaje + " <span class='pull-right text-muted small'>" + mensaje.fecha + "</span></div></a></li>";
                panelNotificaciones.prepend(not);
                var badgeCantidad = $('#panel-notificaciones-cantidad');
                var cnt = 1;
                if (badgeCantidad.text().length !== 0) {
                    cnt = parseInt(badgeCantidad.text());
                    var sobran = cnt % 5;

                    if (sobran > 0) {
                        var $notifs = $('.notificacion');
                        for (var i = 0; i < cnt; i++) {
                            $notifs.last().remove();
                        }
                    }

                    cnt++;
                }
                badgeCantidad.text(cnt);
            }
            break;
        case 'ERROR':
            alert(mensaje.mensaje);
            break;
    }
}

function conectarWebSocket() {
    wsocket = new WebSocket(serviceLocation);
    wsocket.onmessage = mensajeRecibido;
    wsocket.onopen = function (e) {
        var msg = '{"idUsuario":"' + idUsuario + '","tipo":"LOGIN"}';
        wsocket.send(msg);
    };
}

$(document).ready(function () {
    idUsuario = $('#idUsuarioHidden').val();
    conectarWebSocket();

    $('body').on('click', '.circulo-notificacion', function (e) {
        e.preventDefault();
        e.stopPropagation();
        var $boton = $(this);
        if ($boton.parent().hasClass('novisto')) {
            $.post('/notificacion/vistoDesdePanel', {id: $boton.data('id')}, function (response) {
                if (response.codigo === 200) {
                    $boton.parent().removeClass('novisto');
                    var badgeCantidad = $('#panel-notificaciones-cantidad');
                    var cnt = parseInt(badgeCantidad.text());
                    if (cnt > 1) {
                        cnt--;
                        badgeCantidad.text(cnt);
                    } else {
                        badgeCantidad.text('');
                    }
                } else {
                    console.log('mal error mal');
                }
            });
        }
    });

    setInterval(actualizarPanel, 60000);

});
var a = null;
function actualizarPanel() {

    console.log("se actualiza el panel");

    $.post('/notificacion/panel', null, function (response) {
        var $parent = $('#contenedor-notificacion').parent();
        var res = $(response);
        var success = res.find("#panel-notificaciones");
        if (success.length > 0) {
            var flag = $('#contenedor-notificacion').hasClass('open') ? true : false;
            $('#contenedor-notificacion').remove();
            $parent.prepend(res);
            if (flag) {
                $('#contenedor-notificacion').addClass("open");
            }
        }
    });

}