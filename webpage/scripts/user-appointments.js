$(document).ready(function () {
    $('.search-button').click(function () {
        $(this).parent().toggleClass('open');
    });
    $('tbody > tr').hover(function () {
        var $advancedOptions = $(this).children('.advancedOptions').children('.dropdown').children('img');
        $($advancedOptions).toggle();
        $($advancedOptions).click(function () {
            $(this).siblings('.dropdown-content').show();
        });
        $($advancedOptions).siblings('.dropdown-content').hover(function () {
            $(this).toggle();
        });
    });
});