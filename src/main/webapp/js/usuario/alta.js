(function ($) {
    $('#fechaAlta').val(erroresM.fechaActual());

    $('#nombre, #apellido').blur(function () {
        var nombre = $('#nombre').val()
                                 .split(" ")
                                 .join("");

        var apellido = $('#apellido').val()
                                     .split(" ")
                                     .join("");

        var nick = nombre + apellido;
        $('#nick').val(nick.toLowerCase());
    });

    $('#alta-usuario-form').submit(function (e) {
        var $boton = $(this).find('.confirmar');
        var data = $(this).serialize();
        toggleBoton($boton);
        $.post('/usuario/registrar', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/usuario/listar');
            } else {
                erroresM.mostrarErrores('alta-usuario-form', response);
                toggleBoton($boton);
            }
        });
        return false;
    });

    $('#alta-usuario-form .cancelar').on('click', function (e) {
        e.preventDefault();
        window.location.replace('/usuario/listar');
    });
})(jQuery);