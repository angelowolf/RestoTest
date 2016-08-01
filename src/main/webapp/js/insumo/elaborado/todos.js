(function ($) {
    var cdetalles = 0;

    $('.mostrar-modal-confeccionar-insumo-elaborado').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-confeccionar-insumo-elaborado');
        var $form  = $('#confeccionar-insumo-elaborado-form');
            $form.trigger('reset');
            $form.find('#model-id').val(id);
            $form.find('#confeccionar-detalle-insumo-elaborado').empty();
            erroresM.limpiarErrores($form.attr('id'));
        $.post("/insumoelaborado/getModificar", {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#nombre').html(response.model.nombre);
                $modal.find('#unidadMedida').html(response.model.unidadMedida);
                $modal.find('#cantidadActual').html(response.model.stock.cantidadActual);
                $.each(response.model.detalleInsumoElaborados, function (k, detalle) {
                    var    $tdN = $('<td>').addClass('text-center-all').html(detalle.insumoBruto.nombre);
                    var    $tdU = $('<td>').addClass('text-center-all').html(detalle.insumoBruto.unidadMedida);
                    var    $tdC = $('<td>').addClass('text-center-all cantidad').html('0');
                    var $hidden = $('<input>').prop('type', 'hidden')
                                              .addClass('cantidad-original')
                                              .val(detalle.cantidad);
                    var     $tr = $('<tr>').prop('id', detalle.insumoBruto.id)
                                           .append($hidden)
                                           .append($tdN)
                                           .append($tdC)
                                           .append($tdU);
                    $modal.find('#confeccionar-detalle-insumo-elaborado').append($tr);
                });
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });

        $modal.modal('show');
    });

    $('#cantidad-insumo-a-confeccionar').on('keyup', function (e) {
        var cantidadElaboracion = parseFloat($(this).val()) || 0;
        $('#confeccionar-detalle-insumo-elaborado .cantidad').each(function (i, v) {
            var cantidadInsumo = parseFloat($(this).parents('tr').children('.cantidad-original').val()) || 0;
            var cantidadUtilizar = cantidadInsumo * cantidadElaboracion;
            $(this).html(cantidadUtilizar.toFixed(2));
        });
    });

    $('#modal-confeccionar-insumo-elaborado #confeccionar-insumo-elaborado-form').submit(function (e) {
        var $form = $(this);
        var $boton = $form.find('.confirmar');
        var data = $form.serialize();
        toggleBoton($boton);
        $.post('/insumoelaborado/confeccionar', data, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumoelaborado/listar?' + data);
            } else {
                toggleBoton($boton);
                erroresM.mostrarErrores($form.attr('id'), response);
            }
        });
        return false;
    });

    $('.mostrar-modal-recuperar-insumo-elaborado').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-recuperar-insumo-elaborado');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-recuperar-insumo-elaborado .confirmar').on('click', function (e) {
        var $dialog = $('#modal-recuperar-insumo-elaborado');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/insumoelaborado/recuperar', {id: id}, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumoelaborado/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-baja-insumo-elaborado').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-baja-insumo-elaborado');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-baja-insumo-elaborado .confirmar').on('click', function (e) {
        var $dialog = $('#modal-baja-insumo-elaborado');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/insumoelaborado/eliminar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $dialog.modal('hide');
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumoelaborado/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-ver-insumo-elaborado').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-ver-insumo-elaborado');
            $modal.find('#id').val(id);
        $.post('/insumoelaborado/getModificar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#nombre').html(response.model.nombre);
                $modal.find('#unidadMedida').html(response.model.unidadMedida);
                $modal.find('#cantidadActual').html(response.model.stock.cantidadActual);
                $modal.find('#cantidadMinima').html(response.model.stock.cantidadMinima);
                $modal.find('#fechaAlta').html(response.model.fAlta ? response.model.fAlta : '-');
                $modal.find('#fechaBaja').html(response.model.fBaja ? response.model.fBaja : '-');
                $.each(response.model.detalleInsumoElaborados, function (k, detalle) {
                    var $tdN = $('<td>').addClass('text-center-all').html(detalle.insumoBruto.nombre);
                    var $tdU = $('<td>').addClass('text-center-all').html(detalle.insumoBruto.unidadMedida);
                    var $tdC = $('<td>').addClass('text-center-all').html(detalle.cantidad);
                    var  $tr = $('<tr>').append($tdN).append($tdC).append($tdU);
                    $modal.find('#ver-detalle-insumo-elaborado').append($tr);
                });
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });
        $modal.modal('show');
    });

    $('.mostrar-modal-modificar-insumo-elaborado').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-modificar-insumo-elaborado');
            $modal.find('#id').val(id);
            $modal.find('#detalle-insumo-elaborado').empty();
            $modal.find('#modificar-insumo-elaborado-form').trigger("reset");
        $.post('/insumoelaborado/getModificar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').val(response.model.id);
                $modal.find('#nombre').val(response.model.nombre);
                $modal.find('#unidadMedida' + response.model.unidadMedida).prop('checked', true);
                $modal.find('#cantidadMinima').val(response.model.stock.cantidadMinima);
                $.each(response.model.detalleInsumoElaborados, function (k, detalle) {
                    crearFilaDetalleInsumo(detalle.insumoBruto, detalle.cantidad);
                });
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });
        erroresM.limpiarErrores('modificar-insumo-elaborado-form');
        setTimeout(function (modal) { modal.find('[autofocus]').focus() }, 500, $modal);
        $modal.modal('show');
    });

    $('#modal-modificar-insumo-elaborado #modificar-insumo-elaborado-form').submit(function (e) {
        var $form = $(this);
        var $boton = $form.find('.confirmar');
        var data = $form.serialize();
        toggleBoton($boton);
        $.post('/insumoelaborado/postModificar', data, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumoelaborado/listar?' + data);
            } else {
                toggleBoton($boton);
                erroresM.mostrarErrores($form.attr('id'), response);
            }
        })
        return false;
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
                        crearFilaDetalleInsumo(response.model, 1);
                    } else {
                        erroresM.mostrarAlertError(response.actionErrors);
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

    function crearFilaDetalleInsumo(model, cantidad) {
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
                                        .val(cantidad)
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