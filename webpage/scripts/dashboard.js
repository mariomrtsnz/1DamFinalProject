window.onload = function init() {
    var navToggle = document.getElementsByClassName('nav-toggle')[0];
    var navSide = document.getElementsByClassName('nav-side')[0];
    navToggle.addEventListener("click", toggleSideBar);
}

function toggleSideBar() {
    var navSide = document.getElementsByClassName('nav-side')[0];
    navSide.classList.toggle('nav-open');

    this.style.display = this.style.display === '' ? 'inline-block' : '';
    this.style.transform = this.style.transform === '' ? 'rotate(180deg)' : '';
}

jQuery(document).ready(function () {
    var mainContent = $('.cd-main-content'),
        header = $('.cd-main-header'),
        sidebar = $('.cd-side-nav'),
        sidebarTrigger = $('.cd-nav-trigger'),
        topNavigation = $('.cd-top-nav'),
        accountInfo = $('.account');
    var resizing = false;
    moveNavigation();
    $(window).on('resize', function () {
        if (!resizing) {
            (!window.requestAnimationFrame) ? setTimeout(moveNavigation, 300): window.requestAnimationFrame(moveNavigation);
            resizing = true;
        }
    });
    var scrolling = false;
    checkScrollbarPosition();
    $(window).on('scroll', function () {
        if (!scrolling) {
            (!window.requestAnimationFrame) ? setTimeout(checkScrollbarPosition, 300): window.requestAnimationFrame(checkScrollbarPosition);
            scrolling = true;
        }
    });
    sidebarTrigger.on('click', function (event) {
        event.preventDefault();
        $([sidebar, sidebarTrigger]).toggleClass('nav-is-visible');
    });
    $('.has-children > a').on('click', function (event) {
        var mq = checkMQ(),
            selectedItem = $(this);
        if (mq == 'mobile' || mq == 'tablet') {
            event.preventDefault();
            if (selectedItem.parent('li').hasClass('selected')) {
                selectedItem.parent('li').removeClass('selected');
            } else {
                sidebar.find('.has-children.selected').removeClass('selected');
                accountInfo.removeClass('selected');
                selectedItem.parent('li').addClass('selected');
            }
        }
    });
    accountInfo.children('a').on('click', function (event) {
        var mq = checkMQ(),
            selectedItem = $(this);
        if (mq == 'desktop') {
            event.preventDefault();
            accountInfo.toggleClass('selected');
            sidebar.find('.has-children.selected').removeClass('selected');
        }
    });
    $(document).on('click', function (event) {
        if (!$(event.target).is('.has-children a')) {
            sidebar.find('.has-children.selected').removeClass('selected');
            accountInfo.removeClass('selected');
        }
    });
    sidebar.children('ul').menuAim({
        activate: function (row) {
            $(row).addClass('hover');
        },
        deactivate: function (row) {
            $(row).removeClass('hover');
        },
        exitMenu: function () {
            sidebar.find('.hover').removeClass('hover');
            return true;
        },
        submenuSelector: ".has-children",
    });

    function checkMQ() {
        return window.getComputedStyle(document.querySelector('.cd-main-content'), '::before').getPropertyValue('content').replace(/'/g, "").replace(/"/g, "");
    }

    function moveNavigation() {
        var mq = checkMQ();
        if (mq == 'mobile' && topNavigation.parents('.cd-side-nav').length == 0) {
            detachElements();
            topNavigation.appendTo(sidebar);
        } else if ((mq == 'tablet' || mq == 'desktop') && topNavigation.parents('.cd-side-nav').length > 0) {
            detachElements();
            topNavigation.appendTo(header.find('.cd-nav'));
        }
        checkSelected(mq);
        resizing = false;
    }

    function detachElements() {
        topNavigation.detach();
    }

    function checkSelected(mq) {
        if (mq == 'desktop') $('.has-children.selected').removeClass('selected');
    }

    function checkScrollbarPosition() {
        var mq = checkMQ();
        if (mq != 'mobile') {
            var sidebarHeight = sidebar.outerHeight(),
                windowHeight = $(window).height(),
                mainContentHeight = mainContent.outerHeight(),
                scrollTop = $(window).scrollTop();
            ((scrollTop + windowHeight > sidebarHeight) && (mainContentHeight - sidebarHeight != 0)) ? sidebar.addClass('is-fixed').css('style', ''): sidebar.removeClass('is-fixed').attr('style', '');
        }
        scrolling = false;
    }
});
jQuery(document).ready(function ($) {
    var $lateral_menu_trigger = $('#cd-menu-trigger'),
        $content_wrapper = $('.cd-main-content'),
        $navigation = $('header');
    $lateral_menu_trigger.on('click', function (event) {
        event.preventDefault();
        $lateral_menu_trigger.toggleClass('is-clicked');
        $navigation.toggleClass('lateral-menu-is-open');
        $content_wrapper.toggleClass('lateral-menu-is-open').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $('body').toggleClass('overflow-hidden');
        });
        $('#cd-lateral-nav').toggleClass('lateral-menu-is-open');
        if ($('html').hasClass('no-csstransitions')) {
            $('body').toggleClass('overflow-hidden');
        }
    });
    $content_wrapper.on('click', function (event) {
        if (!$(event.target).is('#cd-menu-trigger, #cd-menu-trigger span')) {
            $lateral_menu_trigger.removeClass('is-clicked');
            $navigation.removeClass('lateral-menu-is-open');
            $content_wrapper.removeClass('lateral-menu-is-open').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $('body').removeClass('overflow-hidden');
            });
            $('#cd-lateral-nav').removeClass('lateral-menu-is-open');
            if ($('html').hasClass('no-csstransitions')) {
                $('body').removeClass('overflow-hidden');
            }
        }
    });
    $('.item-has-children').children('a').on('click', function (event) {
        event.preventDefault();
        $(this).toggleClass('submenu-open').next('.sub-menu').slideToggle(200).end().parent('.item-has-children').siblings('.item-has-children').children('a').removeClass('submenu-open').next('.sub-menu').slideUp(200);
    });
});