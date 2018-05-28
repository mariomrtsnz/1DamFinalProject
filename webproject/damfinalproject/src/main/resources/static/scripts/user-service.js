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
    $("#payNow, #payPhysically").click(submit);
}

function modalToggler() {
    $('#appointmentModal').toggle('slow');
    $('.modal-overlay').toggle();
}

function submit(e) {
    var datePickerValue = document.getElementById('datePicker').value;
    var timePickerValue = document.getElementById('timeInput').value;
    if (moment(datePickerValue).isBefore(today) || moment(datePickerValue).isAfter(aYearFromToday) || datePickerValue === "") {
        alert('La fecha tiene que estar entre ' + today + ' y ' + aYearFromToday);
        return false;
    } else if (timePickerValue < openTime || timePickerValue > closeTime || timePickerValue === "") {
        alert('La hora tiene que ser entre las ' + openTime + ' y las ' + closeTime);
        return false;
    } else {
    	return true;
    }
}