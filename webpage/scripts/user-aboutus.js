// Funcionamiento de la galería de imágenes de las oficinas.
$(document).ready(function () {
    $(".thumbs a").click(function (evt) {
        evt.preventDefault();
        $(".display").empty().append(
            $("<img>", {
                src: this.href
            })
        );
    });
});