window.onload = function init() {
	var signUp = document.getElementById("signUp");
	signUp.addEventListener("click", loadSignUp);

	var logIn = document.getElementById("logIn");
	logIn.addEventListener("click", loadLogIn);
}

function loadSignUp() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("form").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/public/signup.html", true);
	xhttp.send();
}

function loadLogIn() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("form").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "/public/login.html", true);
	xhttp.send();
}

$(document).ready(function() {
	$("#submitSignUpButton").click(submitSignUp);
});
function submitSignUp(e) {
	var nameRegexr = /([A-ZÀ-Ú]{1}[A-Za-zÀ-ú]{1,}(-| ){0,1})/g;
	var nameValidationResult = $('#name').val() == nameRegexr;
	if (nameValidationResult) {
		return true;
	} else {
		alert('Validación Fallida');
		e.preventDefault();
		return false;
	}
}