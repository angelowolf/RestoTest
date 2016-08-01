(function ($) {
   
    $('.mostrar-modal-recuperar-insumo-bruto').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-recuperar-insumo-bruto');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-recuperar-insumo-bruto .confirmar').on('click', function (e) {
        var $dialog = $('#modal-recuperar-insumo-bruto');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/insumobruto/recuperar', {id: id}, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumobruto/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-baja-insumo-bruto').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-baja-insumo-bruto');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-baja-insumo-bruto .confirmar').on('click', function (e) {
        var $dialog = $('#modal-baja-insumo-bruto');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/insumobruto/eliminar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $dialog.modal('hide');
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumobruto/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-ver-insumo-bruto').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-ver-insumo-bruto');
            $modal.find('#id').val(id);
        $.post('/insumobruto/getModificar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').html(response.model.id);
                $modal.find('#nombre').html(response.model.nombre);
                $modal.find('#precioUnidad').html(response.model.precioUnidad);
                $modal.find('#cantidadMinima').html(response.model.stock.cantidadMinima);
                $modal.find('#cantidadActual').html(response.model.stock.cantidadActual);
                $modal.find('#fechaAlta').html(response.model.fAlta ? response.model.fAlta : '-');
                $modal.find('#fechaBaja').html(response.model.fBaja ? response.model.fBaja : '-');
                $modal.find('#unidadMedida').html(response.model.unidadMedida);
                $modal.find('#categoria').html(response.model.categoriaInsumo.nombre);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });
        $modal.modal('show');
    });

    $('.mostrar-modal-modificar-insumo-bruto').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-modificar-insumo-bruto');
            $modal.find('#id').val(id);
        $.get('/insumobruto/getModificar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').val(response.model.id);
                $modal.find('#nombre').val(response.model.nombre);
                $modal.find('#precioUnidad').val(response.model.precioUnidad);
                $modal.find('#unidadMedida' + response.model.unidadMedida).prop('checked', true);
                $modal.find('#categoriaInsumo').val(response.model.categoriaInsumo.id).prop('selected', true);
                $modal.find('#cantidadMinima').val(response.model.stock.cantidadMinima);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });
        erroresM.limpiarErrores('modificar-insumo-bruto-form');
        setTimeout(function (modal) { modal.find('[autofocus]').focus() }, 500, $modal);
        $modal.modal('show');
    });

    $('#modal-modificar-insumo-bruto #modificar-insumo-bruto-form').submit(function (e) {
        var $form = $(this);
        var $boton = $form.find('.confirmar');
        var data = $form.serialize();
        toggleBoton($boton);
        $.post('/insumobruto/postModificar', data, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/insumobruto/listar?' + data);
            } else {
                erroresM.mostrarErrores($form.attr('id'), response);
                toggleBoton($boton);
            }
        })
        return false;
    });
})(jQuery);