(function ($) {
    $('.mostrar-modal-recuperar-usuario').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-recuperar-usuario');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-recuperar-usuario .confirmar').on('click', function (e) {
        toggleBoton(e.target);
        var $dialog = $('#modal-recuperar-usuario');
        var id =  $dialog.find('#model-id').val();
        $.post('/usuario/recuperar', {id: id}, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/usuario/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-reiniciar-contraseña').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-reiniciar-contraseña');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-reiniciar-contraseña .confirmar').on('click', function (e) {
        var $dialog = $('#modal-reiniciar-contraseña');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/usuario/blanquear', {id: id}, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/usuario/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-baja-usuario').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-baja-usuario');
            $modal.find('#model-id').val(id);
            $modal.modal('show');
    });

    $('#modal-baja-usuario .confirmar').on('click', function (e) {
        var $dialog = $('#modal-baja-usuario');
        var id =  $dialog.find('#model-id').val();
        toggleBoton(e.target);
        $.post('/usuario/eliminar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $dialog.modal('hide');
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/usuario/listar?' + data);
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
                toggleBoton(e.target);
            }
        });
    });

    $('.mostrar-modal-ver-usuario').on('click', function (e) {
        var id = $(this).parents('.acciones').children('.model-id').val();
        var $modal = $('#modal-ver-usuario');
            $modal.find('#id').val(id);
        $.get('/usuario/editar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').html(response.model.id);
                $modal.find('#nombre').html(response.model.nombre);
                $modal.find('#apellido').html(response.model.apellido);
                $modal.find('#documento').html(response.model.documento);
                $modal.find('#telefono').html(response.model.telefono);
                $modal.find('#direccion').html(response.model.direccion);
                $modal.find('#fechaNacimiento').html(response.model.fNacimiento ? response.model.fNacimiento : '-');
                $modal.find('#fechaAlta').html(response.model.fAlta ? response.model.fAlta : '-');
                $modal.find('#fechaBaja').html(response.model.fBaja ? response.model.fBaja : '-');
                $modal.find('#nick').html(response.model.nick);
                var $roles = $modal.find('#roles-ver');
                $roles.empty();
                $.each(response.model.roles, function (k, rol) {
                    var $label = $('<span>').addClass('label label-default').html(rol);
                    $roles.append($label).append('&nbsp;&nbsp;');
                });
            } else {
                erroresM.mostrarAlertError(response.actionErrors, 'danger');
            }
        });
        $modal.modal('show');
    });

    $('.mostrar-modal-modificar-usuario').on('click', function (e) {
        var    id = $(this).parents('.acciones').children('.model-id').val();
        var $form = $('#modificar-usuario-form');
            $form.trigger("reset");
        var $modal = $('#modal-modificar-usuario');
            $modal.find('#id').val(id);
        $.post('/usuario/editar', {id: id}, function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').val(response.model.id);
                $modal.find('#nombre').val(response.model.nombre);
                $modal.find('#apellido').val(response.model.apellido);
                $modal.find('#documento').val(response.model.documento);
                $modal.find('#telefono').val(response.model.telefono);
                $modal.find('#direccion').val(response.model.direccion);
                if (response.model.fNacimiento !== null) {
                    $modal.find('#fechaNacimiento').val(response.model.fNacimiento);
                }
                $modal.find('#fechaAlta').val(response.model.fAlta);
                $modal.find('#nick').val(response.model.nick);
                for (var i = 0; i < response.model.roles.length; i++) {
                    $modal.find('#rol' + response.model.roles[i]).prop('checked', true);
                }
                $modal.find('#rol').val(response.model.rol);
            } else {
                erroresM.mostrarAlertError(response.actionErrors, 'danger');
            }
        });
        erroresM.limpiarErrores('modificar-usuario-form');
        setTimeout(function (modal) { modal.find('[autofocus]').focus() }, 500, $modal);
        $modal.modal('show');
    });

    $('#modal-modificar-usuario #modificar-usuario-form').submit(function (e) {
        var $form = $(this);
        var $boton = $form.find('.confirmar');
        var data = $form.serialize();
        toggleBoton($boton);
        $.post('/usuario/modificar', data, function (response) {
            if (response.codigo === 200) {
                var data = $('#formulario-buscar').serialize();
                window.location.replace('/usuario/listar?' + data);
            } else {
                erroresM.mostrarErrores($form.attr('id'), response);
                toggleBoton($boton);
            }
        });
        return false;
    });
})(jQuery);