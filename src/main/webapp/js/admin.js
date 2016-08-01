var erroresM = (function () {
    var modulo = this;

    var defaultConfig = {
        ApplicationName: 'Restaurante'
    };

    modulo.getConfig = defaultConfig;

    modulo.setConfig = function (config) {
        defaultConfig.ApplicationName = config.ApplicationName;
    };

    modulo.limpiarErrores = function (formId) {
        $('#' + formId + ' .help-block').html('');
        $('#' + formId + ' .has-error').removeClass('has-error');
    };

    modulo.mostrarErrores = function (formId, data, noLimpiar) {
        if (!noLimpiar) {
            modulo.limpiarErrores(formId);
        }

        if (data.actionErrors) {
            modulo.mostrarAlertError(data.actionErrors);
        }
        if (data.fieldErrors) {
            $.each(data.fieldErrors, function (input, errors) {
                var $frmgrp = $('#' + formId + ' [name="' + input + '"]').parents('.form-group');
                var strerror= '';
                $.each(errors, function (idx, error) {
                    strerror += error + '<br />';
                });
                $frmgrp.addClass('has-error');
                $frmgrp.children('.help-block').html(strerror);
            });
        }
        if (data.actionMessages) {
            var mensajes = data.actionMessages;
            for (var dato in mensajes) {
                var mensaje = mensajes[dato];
                $(formId).append('<p class="info">' + mensaje + '</p>');
            }
        }
    };

    modulo.mostrarAlertError = function (mensajes) {
        $.each(mensajes, function (k, mensaje) {
            crearNotify('<strong>Ocurrió un Problema:</strong> ', mensaje, 'danger', 'fa fa-exclamation-circle')
        });
    };

    modulo.mostrarAlert = function (mensaje, tipo) {
        crearNotify('<strong>Informacion:</strong> ', mensaje, tipo, 'fa fa-info-circle');
    };

    modulo.fechaActual = function () {
      function pad(s) { return (s < 10) ? '0' + s : s; }
      var d = new Date();
      return [pad(d.getDate()), pad(d.getMonth()+1), d.getFullYear()].join('/');
    }

    function crearNotify(titulo, mensaje, tipo, icono) {
        $.notify(
            {
                title  : titulo,
                icon   : icono,
                message: mensaje
            },
            {
                animate: {
                    enter: 'animated fadeInDown',
                    exit : 'animated fadeOutUp'
                },
                delay : 10000,
                offset: 
                { 
                    y : 0 
                },
                placement: 
                {
                    align: "center",
                    from : "top"
                },
                type: tipo
            }
        );
    }
    return modulo;
})();


function getIdsFormatoPOST() {
    var allVals = '';
    $.each(ids, function (index, id) {
        allVals += "ids=" + id + "&";  //prepare the string
    });
    if (allVals.length > 0) {
        allVals = allVals.substring(0, allVals.length - 1); //remove last '&'
    }
    return allVals; //submit this string as parameter
}

Array.prototype.remove = function () {
    var what, a = arguments, L = a.length, ax;
    while (L && this.length) {
        what = a[--L];
        while ((ax = this.indexOf(what)) !== -1) {
            this.splice(ax, 1);
        }
    }
    return this;
};

function toggleBoton(button) {
    var btn = $(button);
    if (btn.is(':disabled')) {
        btn.prop('disabled', false);
        btn.removeClass('btn-loading');
    } 
    else {
        btn.prop('disabled', true);
        btn.addClass('btn-loading');
    }
}

$(document).ready(function () {
    var isub = 0;

    $('[data-toggle="tooltip"]').tooltip({
        container : 'body'
    });

    $('.input-group.date').datepicker({
        format: 'dd/mm/yyyy',
        language: 'es',
        autoclose: true,
        todayHighlight: true,
        orientation: 'bottom auto',
        container: 'body'
    });

    $('.selectpicker').selectpicker({
        countSelectedText : '{0} Roles Seleccionados...',
        selectAllText: 'Todos',
        deselectAllText: 'Ninguno',
        container : 'body'
    });

    $('input.numeric-nodot[type=text]').blur(function (evt) {
        var $input = $(this);
        var patrn  = /[^\d]/g;
        if($input.val().trim() && patrn.test($input.val())) {
            var hlbl = $input.parents('.form-group').children('.help-block');
            $input.val($input.val().replace(patrn, ''));
            hlbl.html('Este campo solo acepta numeros sin puntos y/o comas');
        }
    });

    $('input.numeric[type=text]').blur(function (evt) {
        var $input = $(this);
        var patrn  = /[^\d\.,]/g;
        if($input.val().trim() && patrn.test($input.val())) {
            var hlbl = $input.parents('.form-group').children('.help-block');
            $input.val($input.val().replace(patrn, ''));
            hlbl.html('Este campo solo acepta numeros');
        }
    });

    $('input.numeric-signed[type=text]').blur(function (evt) {
        var $input = $(this);
        var patrn  = /[^\d\.,\+\-]/g;
        if($input.val().trim() && patrn.test($input.val())) {
            var hlbl = $input.parents('.form-group').children('.help-block');
            $input.val($input.val().replace(patrn, ''));
            hlbl.html('Este campo solo acepta numeros');
        }
    });


    $('#mostrar-modal-modificar-perfil').on('click', function (evt) {
        var $modal = $('#modal-modificar-perfil');
        var $form  = $('#modal-modificar-perfil #modificar-perfil-usuario-form');
            $form.trigger('reset');
        $.get('/usuario/ver-perfil', function (response) {
            if (response.codigo === 200) {
                $modal.find('#id').val(response.model.id);
                $modal.find('#nombre').html(response.model.nombre);
                $modal.find('#apellido').html(response.model.apellido);
                $modal.find('#documento').html(response.model.documento);
                $modal.find('#telefono').val(response.model.telefono);
                $modal.find('#direccion').val(response.model.direccion);
                $modal.find('#nick').val(response.model.nick);
                $modal.find('#preguntaSecreta').selectpicker('val', response.model.preguntaSecreta);
                $modal.find('#respuestaSecreta').val(response.model.respuestaSecreta);
                $modal.find('#fechaNacimiento').val(response.model.fNacimiento ? response.model.fNacimiento : '');
                var $roles = $modal.find('#roles');
                $roles.empty();
                $.each(response.model.roles, function (k, rol) {
                    var $label = $('<span>').addClass('label label-default').html(rol);
                    $roles.append($label).append('&nbsp;&nbsp;');
                });
                $('#datos-perfil').show();
                $('#contraseña-actual').hide();
                $('#datos-ingreso').hide();
                $('#ver-datos-ingreso').html('Mostrar Datos de Ingreso');
            } else {
                erroresM.mostrarAlertError(response.actionErrors);
            }
        });
        isub = 0;
        erroresM.limpiarErrores($form.attr('id'));
        $modal.modal('show');
    });

    $('#modal-modificar-perfil #ver-datos-ingreso').on('click', function(evt) {
        if($('#datos-ingreso').is(':hidden')) {
            $('#ver-datos-ingreso').html('Ocultar Datos de Ingreso');
            $('#datos-ingreso').slideDown('fast');
        }
        else {
            $('#ver-datos-ingreso').html('Mostrar Datos de Ingreso');
            $('#datos-ingreso').slideUp('fast');
        }
    });

    $('#modificar-perfil-usuario-form').submit(function (e) {
        if(isub == 0) {
            $('#contraseña-actual').slideDown('fast');
            $('#datos-perfil, #datos-ingreso').slideUp('fast');
            isub++;
        }
        else {
            var $form = $(this);
            var $boton = $form.find('.confirmar');
            var data = $form.serialize();
            toggleBoton($boton);
            isub++;
            $.post('/usuario/modificar-perfil', data, function (response) {
                if (response.codigo !== 200) {
                    var firstKey = '';
                    $.each(response.fieldErrors, function(k, v) {
                        firstKey = k;
                        return false;
                    })
                    if(firstKey != 'claveOriginal') {
                        $('#contraseña-actual').slideUp('fast');
                        $('#datos-perfil, #datos-ingreso').slideDown('fast');
                        $('#ver-datos-ingreso').html('Ocultar Datos de Ingreso');
                    }
                    else {
                        $('#claveOriginal').val('');
                        $('#contraseña-actual').slideDown('fast');
                        $('#datos-perfil, #datos-ingreso').slideUp('fast');
                    }
                    erroresM.mostrarErrores('modificar-perfil-usuario-form', response);
                }
                else {
                    erroresM.mostrarAlert('El Perfil de Usuario se modificó con éxito.', 'info');
                    $('#modal-modificar-perfil').modal('hide');
                }
                toggleBoton($boton);
            });
        }
        return false;
    });
});