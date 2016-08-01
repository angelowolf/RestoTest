(function ($) {
    $('#alta-categoria-form').submit(function (e) {
        e.preventDefault();
        toggleBoton("#alta-categoria-form > .registrar");
        var data = $('#alta-categoria-form').serialize();
        $.post('/receta/categoria/registrar', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/receta/categoria/listar');
            } else {
                erroresM.mostrarErrores('#alta-categoria-form', response);
                toggleBoton("#alta-categoria-form > .registrar");
            }
        });
    });
    $('#alta-categoria-form').on('click', '.cancelar', function (e) {
        e.preventDefault();
        window.location.replace('/receta/categoria/listar');
    });
})(jQuery);