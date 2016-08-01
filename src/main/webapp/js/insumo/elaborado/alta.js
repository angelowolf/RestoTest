(function ($) {
    var cdetalles = 0;
    $('#fechaAlta').val(erroresM.fechaActual());
    $('#alta-insumo-elaborado-form').submit(function (e) {
        var $boton = $(this).find('.confirmar');
        var data = $(this).serialize();
        toggleBoton($boton);
        $.post('/insumoelaborado/registrar', data, function (response) {
            if (response.codigo === 200) {
                window.location.replace('/insumoelaborado/listar');
            } else {
                erroresM.mostrarErrores('alta-insumo-elaborado-form', response);
                toggleBoton($boton);
            }
        });
        return false;
    });

    $('#alta-insumo-elaborado-form .cancelar').on('click', function (e) {
        window.location.replace('/insumoelaborado/listar');
    });

    $('#busqueda-insumo').easyAutocomplete({
        url: function (phrase) {
            return '/insumobruto/postBuscarInsumoBrutoAutoComplete';
        },
        preparePostData: function(data) {
            data = { term : $("#busqueda-insumo").val() };
            return data;
        },
        getValue: 'value',
        list: {
            showAnimation: {
                type: "slide", //normal|slide|fade
                time: 200,
            },

            hideAnimation: {
                type: "slide", //normal|slide|fade
                time: 200,
            },
            onChooseEvent: function() {
                var id = $("#busqueda-insumo").getSelectedItemData().id;

                $.post("/insumobruto/getModificar", { id : id }, function (response) {
                    if (response.codigo === 200) {
                        $('#busqueda-insumo').val('');
                        crearFilaDetalleInsumo(response.model);
                    } else {
                        erroresM.mostrarAlertError(response.actionErrors, 'danger');
                    }
                });
            }
        },
        ajaxSettings: {
            dataType: "json",
            method: "POST",
            data: {
                dataType: "json"
            }
        },
        theme: 'blue-light',
        adjustWidth : false,
        placeholder: "Buscar Insumo a añadir..."
    });

    function crearFilaDetalleInsumo(model) {
        if (model.id) {
            var    $hidden = $('<input>').attr('id', 'idUtilizar')
                                        .prop('name', 'idUtilizar')
                                        .prop('type', 'hidden')
                                        .val(model.id);


            var $tdNombre = $('<td>').addClass('text-center-all')
                                     .html(model.nombre)
                                     .append($hidden);

            var $tdUniMed = $('<td>').addClass('text-center-all')
                                     .html(model.unidadMedida);

            var $tdCanAct = $('<td>').addClass('text-center-all')
                                     .html(model.stock.cantidadActual);

            var    $input = $('<input>').attr('id', 'cantidadUtilizar')
                                        .prop('name', 'cantidadUtilizar')
                                        .prop('type', 'text')
                                        .prop('maxlength', '4')
                                        .prop('placeholder', 'Cantidad')
                                        .addClass('form-control fixed-width-4')
                                        .val('1')
                                        .blur(function () {
                                            $(this).val($(this).val().replace(/[^\d\.,]/g, ''));
                                        });

            var $tdCanUsa = $('<td>').addClass('text-center-all')
                                     .append($input);

            var     $icon = $('<i>').addClass('fa fa-minus')

            var   $button = $('<button>').attr('tabindex', '-1')
                                         .addClass('btn btn-xs btn-danger')
                                         .append($icon)
                                         .on('click', function () {
                                            $(this).tooltip('destroy');
                                            $(this).parents('tr').remove();
                                            cdetalles--;
                                            if(cdetalles < 1) {
                                                $('#detalle-insumo-elaborado').find('.empty')
                                                                              .show(); 
                                            }
                                          })
                                         .tooltip({
                                            title : 'Quitar Insumo',
                                            placement : 'right',
                                            container : 'body'
                                          });

            var $tdAccion = $('<td>').addClass('text-center-all')
                                     .append($button);

            var       $tr = $('<tr>').prop('id', model.id)
                                     .append($tdNombre)
                                     .append($tdCanAct)
                                     .append($tdCanUsa)
                                     .append($tdUniMed)
                                     .append($tdAccion);

            if(cdetalles < 1) {
                $('#detalle-insumo-elaborado').find('.empty').hide();
            }
            $('#detalle-insumo-elaborado').append($tr);
            cdetalles++;
        }
    }
})(jQuery);