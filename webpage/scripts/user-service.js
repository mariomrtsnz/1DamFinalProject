window.onload = function() {
    document.getElementById('exitButton').addEventListener('click', modalToggler);
    document.getElementById('appointmentRequestButton').addEventListener('click', modalToggler);
    document.getElementById('continue').addEventListener('click', loadConfirmation);
}
function modalToggler() {
    $('#appointmentModal').toggle('slow');
}

function loadConfirmation() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("initialAppointmentWindow").innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", "../html/appointment-confirmation.html", true);
    xhttp.send();
}