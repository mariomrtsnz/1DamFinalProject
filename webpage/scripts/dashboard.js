window.onload = function init() {
    var navToggle = document.getElementsByClassName('nav-toggle')[0];
    var navSide = document.getElementsByClassName('nav-side')[0];
    var profileMenu = document.getElementById('profileMenu');
    var profileSubMenu = document.getElementById('profileSubMenu');
    profileMenu.addEventListener("click", toggleProfileSubMenu);
    navToggle.addEventListener("click", toggleSideBar);

    function toggleSideBar() {
        navSide.classList.toggle('nav-open');
    }

    function toggleProfileSubMenu() {
        profileMenu.classList.toggle('profileSubMenu-toggle');
        if (profileSubMenu.style.display == 'block') {
            profileSubMenu.style.display = 'none';
        } else {
            profileSubMenu.style.display = 'block';
        }
    }

}