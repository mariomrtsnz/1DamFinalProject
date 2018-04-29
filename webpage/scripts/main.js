window.onload = function init() {
    var signUp = document.getElementById("signUp");
    signUp.addEventListener("click", loadSignUp);

    var logIn = document.getElementById("logIn");
    logIn.addEventListener("click", loadLogIn);
}
function loadSignUp() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("form").innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", "../html/signup.html", true);
    xhttp.send();
}

function loadLogIn() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("form").innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", "../html/login.html", true);
    xhttp.send();
}

function validateSignUp() {

}