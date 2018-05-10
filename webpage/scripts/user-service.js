var today = moment().format('MM/DD/YYYY');
var aYearFromToday = moment(today).add(1, 'year').format('MM/DD/YYYY');
var openTime = "09:00";
var closeTime = "19:00";
$(document).ready(function () {
    $("#datePicker").attr({
        "max": aYearFromToday,
        "min": today
    })
});

window.onload = function () {
    document.getElementById('exitButton').addEventListener('click', modalToggler);
    document.getElementById('appointmentRequestButton').addEventListener('click', modalToggler);
    document.getElementById('continue').addEventListener('click', loadConfirmation);
}

function modalToggler() {
    $('#appointmentModal').toggle('slow');
}

function loadConfirmation() {
    var datePickerValue = document.getElementById('datePicker').value;
    var timePickerValue = document.getElementById('timeInput').value;
    if (
        moment(datePickerValue).isBefore(today) || moment(datePickerValue).isAfter(aYearFromToday) || datePickerValue === ""
    ) {
        alert('La fecha tiene que estar entre ' + today + ' y ' + aYearFromToday);
    } else if (
        timePickerValue < openTime || timePickerValue > closeTime || timePickerValue === ""
    ) {
        alert('La hora tiene que ser entre las' + openTimeFormatted + ' y ' + closeTimeFormatted);
    } else {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementsByClassName("appointment-content")[0].innerHTML =
                    this.responseText;
            }
        };
        xhttp.open("GET", "../html/appointment-confirmation.html", true);
        xhttp.send();
        $(".appointment-content").css({
            "grid-template-areas": '"date" "calendar" "time" "timePicker" "price" "finalPrice" "payNow" "payPhysically" "payLater" "goBack"',
            "grid-template-rows": "0.1fr 0.5fr 0.1fr 0.5fr 0.1fr 0.5fr 0.2fr 0.2fr 0.2fr 0fr"
        });
        $("#continue").hide();
    }
}

function goBack() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementsByClassName("appointment-content")[0].innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", "../html/appointment-initial.html", true);
    xhttp.send();
    $(".appointment-content").css({
        "grid-template-areas": '"date" "calendar" "time" "timePicker"',
        "grid-template-rows": "0.2fr 1fr 0.2fr 1fr"
    });
    $("#continue").show();
}