window.onload = function init() {
    var button = document.getElementById("signUp");
    button.addEventListener("click", loadSignUp());

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
}
