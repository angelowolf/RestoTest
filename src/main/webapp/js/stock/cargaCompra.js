var ids = [];

(function ($) {

    $('#cancelar').click(function (e) {
        e.preventDefault();
        window.location.replace('/home');
    });
    
    $('#categoria').on('change', function () {
        var data = getIdsFormatoPOST();
        if (data !== "") {
            data += '&';
        }
        data += 'idCategoria=' + $(this).find('option:selected').val();
        data += '&nombreInsumo=' + $('#nombre').val();
        $.post('/insumobruto/postBuscarInsumoBruto', data, function (response) {
            $('#row').fadeOut().remove();
            $('#notificacion').remove();
            $('#contenedor').append(response);
        });
    });

    $('#nombre').on('keyup', function () {
        var data = getIdsFormatoPOST();
        if (data !== "") {
            data += '&';
        }
        data += 'nombreInsumo=' + $(this).val();
        data += '&idCategoria=' + $('#categoria').find('option:selected').val();
        $.post('/insumobruto/postBuscarInsumoBruto', data, function (response) {
            $('#row').fadeOut().remove();
            $('#notificacion').remove();
            $('#contenedor').append(response);
        });
    });

    $('body').on('click', '#row button', function (e) {
        e.preventDefault();
        ids.push($(this).attr('id'));
        $(this).parents('tr').fadeOut('normal', function () {
            var tr = $(this).detach();
            var id = tr.find('td:last button').attr('id');
            tr.find('td:last').remove();
            tr.append('<td><input name="cantidad" type="number" min="0" class="form-control text-center-all"/></td><td><input min="0"  name="precio" type="number" class="form-control text-center-all"/></td><td class="text-center-all"><button value="' + id + '" class="btn btn-danger"><i class="fa fa-close"></i></button></td>');
            $('#row2 tbody').append(tr);
            tr.fadeIn();
            mostrarTabla();
        });
    });

    $('body').on('click', '#row2 button', function (e) {
        e.preventDefault();
        console.log($(this));
        var id = $(this).val();
        ids.remove(id);
        $(this).parents('tr').fadeOut('normal', function () {
            $(this).remove();
            mostrarTabla();
        });
    });


    $('body').on('click', '#registrar', function (e) {
        e.preventDefault();
        toggleBoton(e.target);
        var data = getIdsFormatoPOST();
        if (data.length !== 0) {
            data += '&';
        }
        data += $('#formulario-compra').serialize();
        $.post('/stock/postCargarCompra', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/stock/getCargarCompra');
            } else {
                erroresM.mostrarAlertError(response.actionErrors, 'danger');
                toggleBoton(e.target);
            }
        });
    });



})(jQuery);

function mostrarTabla() {
    var tabla = $('#insumosComprados');
    if (ids.length !== 0) {
        if (!tabla.is(':visible')) {
            tabla.fadeIn();
            $('#registrar').prop('disabled', false);
        }
    } else {
        tabla.fadeOut();
        $('#registrar').prop('disabled', true);
    }
}
