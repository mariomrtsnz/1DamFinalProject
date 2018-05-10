window.onload = function() {
    document.getElementById('exitButton').addEventListener('click', modalToggler);
    document.getElementById('appointmentRequestButton').addEventListener('click', modalToggler);
    document.getElementById('continue').addEventListener('click', loadConfirmation);
}
function modalToggler() {
    $('#appointmentModal').toggle('slow');
}
function loadConfirmation() {
    /*Cargar AJAX de página de confirmación*/
}