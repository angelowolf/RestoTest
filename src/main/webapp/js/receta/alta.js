(function ($) {

    $('body').on('click', '#registrar', function (e) {
        e.preventDefault();
        toggleBoton(e.target);
        var data = $('#formulario').serialize();
        var data2 = $('#detalleIngredientes').serialize();
        $.post('/receta/registrar', data + '&' + data2, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/receta/listar');
            } else {
                erroresM.mostrarErrores('#formulario', response);
                toggleBoton(e.target);
            }
        });
    });
//    $('body').on('click', '#cancelar', function (e) {
//        e.preventDefault();
//        window.location.replace('/insumoelaborado/listar');
//    });


    $('body').on('click', '#row button', function (e) {
        e.preventDefault();
        $(this).parents('tr').fadeOut('normal', function () {
            var tr = $(this).detach();
            tr.remove();
        });
    });



    $('#nombre-insumo-ac').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "/insumo/postBuscarInsumoAutoComplete",
                type: "POST",
                data: {
                    term: request.term
                },
                dataType: "json",
                success: function (data) {
                    response(data);
                }
            });
        },
        select: function (event, ui) {
            var data = {id: ui.item.id};
            $.post("/insumo/getModificar", data, function (response) {
                if (response.codigo === 200) {
                    $('#nombre-insumo-ac').val('');
                    if ($('#' + response.model.id + '').length !== 1) {
                        $('#tabla-ingredientes-body').append('<tr id="' + response.model.id + '"><td class="text-center-all">' + response.model.nombre + '</td><td class="text-center-all">' +
                                response.model.unidadMedida +
                                '</td><td class="text-center-all"><input min="0" type="number" class="form-control" id="cantidadUtilizar" name="cantidadesIngredientes" placeholder="Cantidad a utilizar"><input type="hidden" name="idsIngredientes" value="' + response.model.id + '"></td>' +
                                '<td><input type="checkbox" name="opcionalIngredientesID" value="' + response.model.id + '"></td>' +
                                '<td class="text-center-all"><button class="btn btn-danger"><i class="fa fa-close"></i></button></td></tr>');
                    }
                } else {
                    erroresM.mostrarAlertError(response.actionErrors, 'danger');
                }
            });
        }
    });

})(jQuery);