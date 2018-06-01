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
    $("#submitEditButton").click(submit);
}

function submit(e) {
    var datePickerValue = document.getElementById('datePicker').value;
    var timePickerValue = document.getElementById('timeInput').value;
    var nameFormat = "/([A-ZÀ-Ú]{1}[A-Za-zÀ-ú]{1,}(-| ){0,1})/";
    var descriptionFormat = "/([A-ZÀ-Ú0-9]{1}[A-Za-zÀ-ú0-9]{1,}[0-9]{0,}(-| ){0,1})/";
    var invalidName = !(nameFormat.test(document.getElementById('nameInput').value));
    var invalidDescription = !(descriptionFormat.test(document.getElementById('descriptionInput').value));
	var invalidTotalPrice = !(document.getElementById('totalPriceInput').value >= 5);
	var invalidNumSessions = !(treatment.getNumSessions() >= 1);
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