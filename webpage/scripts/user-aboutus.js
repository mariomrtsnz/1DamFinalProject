window.onload = function () {
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var img = document.getElementById('myImg');
    var modalImg = document.getElementById("img01");
    var captionText = document.getElementById("caption");
    img.onclick = function () {
        modal.style.display = "block";
        modalImg.src = this.src;
        captionText.innerHTML = this.alt;
    }

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }
}

// Funcionamiento de la galería de imágenes de las oficinas.
$(document).ready(function () {
    $(".thumbs a").click(function (evt) {
        evt.preventDefault();
        $("#myImg").attr("src", this.href);
        // $(".display").empty().append(
        //     $("<img>", {
        //         src: this.href
        //     })
        // );
    });
    var slide = $('.card')
    $(slide).first().addClass('active-img');
    $(slide).last().addClass('small').addClass('prev');
    $(slide).last().prev('.card').addClass('smaller prevSmall');
    $(slide).first().next('.card').addClass('small next');
    $(slide).first().next('.card').next('.card').addClass('smaller nextSmall');



    $('.next-btn').click(function (e) {
        e.preventDefault();
        var Active = $('.active-img'),
            Prev = $('.prev'),
            Next = $('.next'),
            SmallPrev = $('.prevSmall'),
            SmallNext = $('.nextSmall');

        $(Active).addClass('small prev ').removeClass('active-img');
        $(Next).addClass('active-img').removeClass('small next');
        $(Prev).addClass('smaller prevSmall ').removeClass('small prev ');
        $(SmallNext).addClass('small next').removeClass('smaller nextSmall ');
        $(SmallPrev).removeClass('prevSmall').addClass('nextSmall');

    });
    $('.prev-btn').click(function (e) {
        e.preventDefault();
        var Active = $('.active-img'),
            Prev = $('.prev'),
            Next = $('.next'),
            SmallPrev = $('.prevSmall'),
            SmallNext = $('.nextSmall');

        $(Active).removeClass('active-img').addClass('small next');
        $(Prev).removeClass('small prev').addClass('active-img');
        $(Next).removeClass('small next').addClass('smaller nextSmall');
        $(SmallPrev).addClass('small prev').removeClass('smaller prevSmall');
        $(SmallNext).removeClass('nextSmall').addClass('prevSmall');

    });
});