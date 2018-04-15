window.onload = function init() {
    var navToggle = document.getElementsByClassName('nav-toggle')[0];
    var navSide = document.getElementsByClassName('nav-side')[0];
    navToggle.addEventListener("click", toggleSideBar);

    function toggleSideBar() {
        navSide.classList.toggle('nav-open');
    }

}
