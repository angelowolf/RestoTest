(function ($) {
    $('#cambiar-contraseña-form').submit(function (e) {
        $form = $(this);
        $boton = $(this).closest('.confirmar');
        toggleBoton($boton);
        var data = $form.serialize();
        $.post('/recuperarClave', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/home');
            } else {
                erroresM.mostrarErrores($form.attr('id'), response);
                toggleBoton($boton);
            }
        });
        return false;
    });
})(jQuery);