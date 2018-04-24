// window.onload = function init() {
//     var navToggle = document.getElementsByClassName('nav-toggle')[0];
//     var navSide = document.getElementsByClassName('nav-side')[0];
//     var profileMenu = document.getElementById('profileMenu');
//     var profileSubMenu = document.getElementById('profileSubMenu');
//     profileMenu.addEventListener("click", toggleProfileSubMenu);
//     navToggle.addEventListener("click", toggleSideBar);

//     function toggleSideBar() {
//         navSide.classList.toggle('nav-open');
//     }

//     function toggleProfileSubMenu() {
//         profileMenu.classList.toggle('profileSubMenu-toggle');
//         if (profileSubMenu.style.display == 'block') {
//             profileSubMenu.style.display = 'none';
//         } else {
//             profileSubMenu.style.display = 'block';
//         }
//     }

// }
jQuery(document).ready(function(){var mainContent=$('.cd-main-content'),header=$('.cd-main-header'),sidebar=$('.cd-side-nav'),sidebarTrigger=$('.cd-nav-trigger'),topNavigation=$('.cd-top-nav'),searchForm=$('.cd-search'),accountInfo=$('.account');var resizing=false;moveNavigation();$(window).on('resize',function(){if(!resizing){(!window.requestAnimationFrame)?setTimeout(moveNavigation,300):window.requestAnimationFrame(moveNavigation);resizing=true;}});var scrolling=false;checkScrollbarPosition();$(window).on('scroll',function(){if(!scrolling){(!window.requestAnimationFrame)?setTimeout(checkScrollbarPosition,300):window.requestAnimationFrame(checkScrollbarPosition);scrolling=true;}});sidebarTrigger.on('click',function(event){event.preventDefault();$([sidebar,sidebarTrigger]).toggleClass('nav-is-visible');});$('.has-children > a').on('click',function(event){var mq=checkMQ(),selectedItem=$(this);if(mq=='mobile'||mq=='tablet'){event.preventDefault();if(selectedItem.parent('li').hasClass('selected')){selectedItem.parent('li').removeClass('selected');}else{sidebar.find('.has-children.selected').removeClass('selected');accountInfo.removeClass('selected');selectedItem.parent('li').addClass('selected');}}});accountInfo.children('a').on('click',function(event){var mq=checkMQ(),selectedItem=$(this);if(mq=='desktop'){event.preventDefault();accountInfo.toggleClass('selected');sidebar.find('.has-children.selected').removeClass('selected');}});$(document).on('click',function(event){if(!$(event.target).is('.has-children a')){sidebar.find('.has-children.selected').removeClass('selected');accountInfo.removeClass('selected');}});sidebar.children('ul').menuAim({activate:function(row){$(row).addClass('hover');},deactivate:function(row){$(row).removeClass('hover');},exitMenu:function(){sidebar.find('.hover').removeClass('hover');return true;},submenuSelector:".has-children",});function checkMQ(){return window.getComputedStyle(document.querySelector('.cd-main-content'),'::before').getPropertyValue('content').replace(/'/g,"").replace(/"/g,"");}
function moveNavigation(){var mq=checkMQ();if(mq=='mobile'&&topNavigation.parents('.cd-side-nav').length==0){detachElements();topNavigation.appendTo(sidebar);searchForm.removeClass('is-hidden').prependTo(sidebar);}else if((mq=='tablet'||mq=='desktop')&&topNavigation.parents('.cd-side-nav').length>0){detachElements();searchForm.insertAfter(header.find('.cd-logo'));topNavigation.appendTo(header.find('.cd-nav'));}
checkSelected(mq);resizing=false;}
function detachElements(){topNavigation.detach();searchForm.detach();}
function checkSelected(mq){if(mq=='desktop')$('.has-children.selected').removeClass('selected');}
function checkScrollbarPosition(){var mq=checkMQ();if(mq!='mobile'){var sidebarHeight=sidebar.outerHeight(),windowHeight=$(window).height(),mainContentHeight=mainContent.outerHeight(),scrollTop=$(window).scrollTop();((scrollTop+windowHeight>sidebarHeight)&&(mainContentHeight-sidebarHeight!=0))?sidebar.addClass('is-fixed').css('bottom',0):sidebar.removeClass('is-fixed').attr('style','');}
scrolling=false;}});