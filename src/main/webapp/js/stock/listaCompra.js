(function ($) {

    $('#cancelar').click(function (e) {
        e.preventDefault();
        window.location.replace('/home');
    });
    $('#imprimir').click(function (e) {
        e.preventDefault();
        window.print();
    });
    $('#nombre').autocomplete({
        source: function (request, response) {
            $.ajax({
                url: "/insumobruto/postBuscarInsumoBrutoAutoComplete",
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
            $.post("/insumobruto/getModificar", data, function (response) {
                if (response.codigo === 200) {
                    $('#nombre').val('');
                    if ($('#' + response.model.id + '').length !== 1) {
                        $('#row').append('<tr id="' + response.model.id + '"><td class="text-center-all">' + response.model.nombre + '</td><td class="text-center-all">' +
                                response.model.categoriaInsumo.nombre +
                                '</td><td class="text-center-all">' +
                                response.model.unidadMedida +
                                '</td><td class="text-center-all">' +
                                response.model.precioUnidad +
                                '</td><td class="text-center-all">' +
                                response.model.stock.cantidadActual +
                                '</td><td class="text-center-all">' +
                                response.model.stock.cantidadMinima +
                                '</td><td class="text-center-all"><input min="0" type="number" class="form-control" id="cantidad" name="cantidad" placeholder="Cantidad a comprar"></td>' +
                                '<td class="text-center-all"><button id="quitar" class="btn btn-danger"><i class="fa fa-close"></i></button></td></tr>');
                    }
                } else {
                    erroresM.mostrarAlertError(response.actionErrors, 'danger');
                }
            });
        }
    });
    $('body').on('click', '#row button', function (e) {
        e.preventDefault();
        $(this).parents('tr').fadeOut('normal', function () {
            var tr = $(this).detach();
            tr.remove();
        });
    });
})(jQuery);