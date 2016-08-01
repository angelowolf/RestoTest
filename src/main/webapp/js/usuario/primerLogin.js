(function ($) {
    $('#primer-login-form').submit(function (e) {
        $form = $(this);
        $boton = $(this).closest('.confirmar');
        toggleBoton($boton);
        var data = $form.serialize();
        $.post('/primerLogin', data, function (response) {
            alert(response.codigo);
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