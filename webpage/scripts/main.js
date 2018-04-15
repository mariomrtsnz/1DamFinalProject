window.onload = function init() {
    var signUp = document.getElementById("signUp");
    signUp.addEventListener("click", loadSignUp);

    var logIn = document.getElementById("logIn");
    logIn.addEventListener("click", loadLogIn);

    var logo = document.getElementsByClassName("landing-page-logo")[0];
    logo.addEventListener("mouseenter", scaleBackground);
    logo.addEventListener("mouseleave", scaleBackgroundOut);

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

    function scaleBackground() {
        var background = document.getElementsByClassName('landing-page-image')[0];
        background.style.backgroundSize = '100%';
    }

    function scaleBackgroundOut() {
        var background = document.getElementsByClassName('landing-page-image')[0];
        var initialValue = window.getComputedStyle(background).getPropertyValue('backgroundSize');
        background.style.backgroundSize = initialValue;
    }

    function validateSignUp() {

    }

}
