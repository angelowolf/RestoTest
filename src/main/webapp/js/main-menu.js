$(document).ready(function () {

    if (typeof(Storage) !== "undefined") {
        var status = localStorage.getItem("isRuhajMenuOpen") || 0;
        toggleRuhajMenu(status);
    }

    $("#navbar-toggle-menu").on('click', function (evt) {
        toggleRuhajMenu($("#page-wrapper").hasClass('closed') ? 1 : 0);
    });

    function toggleRuhajMenu(keepOpen) {
        var canStore = (typeof(Storage) !== "undefined");
        if(keepOpen ==  1) {
            $(".sidebar").removeClass('closed');
            $("#navbar-toggle-menu").removeClass('closed');
            $("#page-wrapper").removeClass('closed');
            if(canStore) {
                localStorage.setItem('isRuhajMenuOpen', 1);
            }
        }
        else {
            $(".sidebar").addClass('closed');
            $("#navbar-toggle-menu").addClass('closed');
            $("#page-wrapper").addClass('closed');
            if(canStore) {
                localStorage.setItem('isRuhajMenuOpen', 0);
            }
        }
    }
});