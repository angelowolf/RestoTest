(function ($) {
    $('#fechaAlta').val(erroresM.fechaActual());
    $('#alta-insumo-bruto-form').submit(function (e) {
        var $boton = $(this).find('.confirmar');
        var data = $(this).serialize();
        toggleBoton($boton);
        $.post('/insumobruto/registrar', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/insumobruto/listar');
            } else {
                erroresM.mostrarErrores('alta-insumo-bruto-form', response);
                toggleBoton($boton);
            }
        });
        return false;
    });
    $('#alta-insumo-bruto-form .cancelar').on('click', function (e) {
        window.location.replace('/insumobruto/listar');
    });
})(jQuery);