$(document).ready(function () {
    $('.search-button').click(function () {
        $(this).parent().toggleClass('open');
    });
    $(window).on("load resize ", function () {
        var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
        $('.tbl-header').css({
            'padding-right': scrollWidth
        });
    }).resize();
});