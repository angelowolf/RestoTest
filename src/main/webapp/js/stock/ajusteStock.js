var ids = [];

(function ($) {

    $('#cancelar').click(function (e) {
        e.preventDefault();
        window.location.replace('/home');
    });

    $('#categoria').on('change', function (e) {
        var id = $(this).val(),
                $todas = $('table tbody tr'),
                match = [],
                $filas = null,
                nombre = $('#nombre').val(),
                criterioBusqueda = 'table tbody tr';

        $todas.hide();

        if (id > 0) {
            criterioBusqueda = 'table tbody tr[id=' + id + ']';
        }

        if (nombre) {
            var regex = new RegExp('\\b' + nombre, 'i');

            $filas = $(criterioBusqueda).find('td:eq(0)');

            $filas.each(function (index, td) {
                if (regex.test($(td).html())) {
                    match.push($(td).parent());
                }
            });

            for (var i = 0; i < match.length; i++) {
                match[i].fadeIn();
            }
        } else {
            $(criterioBusqueda).fadeIn();
        }
    });

    $('#nombre').on('keyup', function () {
        $('#categoria').trigger('change');
    });

    $('body').on('change', 'input[name=cantidad]', function () {
        var real = $(this).val();

        if (real >= 0) {
            var actual = $(this).parent().prev().find('input').val();
            $(this).parent().next().find('input').val(actual - real);
        } else {
            $(this).parent().next().find('input').val('');
        }
    });

    $('body').on('change', 'input[type=checkbox]', function () {
        var $check = $(this),
                id = $check.attr('id');

        if ($check.is(':checked')) {
            $check.parents('td').prev().prev().find('input').prop('disabled', false);
            $('#lista').append('<li data-id="' + id + '"><span class="fa fa-check"></span> ' + $check.parents('tr').find('td:first').html() + '</li>');
            ids.push(id);
        } else {
            $check.parents('td').prev().prev().find('input').prop('disabled', true).val('');
            $check.parents('td').prev().find('input').val('');
            $('#lista').find('li[data-id=' + id + ']').remove();
            ids.remove(id);
        }
    });

    $('#registrar').click(function (e) {
        e.preventDefault();
        toggleBoton(e.target);
        var data = getIdsFormatoPOST();

        if (data.length !== 0) {
            data += '&';
        }

        data += $('#datos').serialize();

        $.post('/stock/postAjusteStock', data, function (response) {
            if (response.codigo === 200) {
                window.location.reload();
            } else {
                erroresM.mostrarAlertError(response.actionErrors, 'danger');
                toggleBoton(e.target);
            }
        });
    });

})(jQuery);
