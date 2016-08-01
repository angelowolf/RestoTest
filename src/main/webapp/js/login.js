(function ($) {
  $('#nick').on('change', function (e) {
    $('#recover-link').attr('href', '/recuperar?nick=' + $(this).val());
  });
})(jQuery);