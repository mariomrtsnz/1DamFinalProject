window.onload = function() {
    document.getElementById('exitButton').addEventListener('click', modalToggler);
    document.getElementById('appointmentRequestButton').addEventListener('click', modalToggler);
}
function modalToggler() {
    $('#appointmentModal').toggle('slow');
}