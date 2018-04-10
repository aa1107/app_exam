$(document).ready(function () {
    var sidebarEl = "";

    sidebarEl += '<div class="ui sidebar inverted vertical right menu overlay">';
    sidebarEl += '<div class="top">';
    sidebarEl += '<img src="images/top_logo.png" alt="">';
    sidebarEl += '<a href="#" class="icon close">';
    sidebarEl += '<span>닫기</span>';
    sidebarEl += '</a>';
    sidebarEl += '</div>';
    sidebarEl += '<nav class="navi">';
    sidebarEl += '<ul>';
    sidebarEl += '<li>';
    sidebarEl += '<a href="index.html">청남대 소개</a>';
    sidebarEl += '</li>';
    sidebarEl += '<li>';
    sidebarEl += '<a href="page1.html">청남대 둘러보기</a>';
    sidebarEl += '</li>';
    sidebarEl += '<li>';
    sidebarEl += '<a href="page2.html">청남대 지도보기</a>';
    sidebarEl += '</li>';
    sidebarEl += '<li>';
    sidebarEl += '<a href="page3.html">주변관광정보</a>';
    sidebarEl += '</li>';
    sidebarEl += '<li>';
    sidebarEl += '<a href="page4.html">이용안내</a>';
    sidebarEl += '</li>';
    sidebarEl += '</ul>';
    sidebarEl += '</nav>';
    sidebarEl += '</div>';

    $("body").append(sidebarEl);
    $(".header .menu").on("click", function () {
        $('.ui.sidebar').sidebar('setting', 'transition', 'overlay').sidebar('toggle');
    })
    $(".ui.sidebar .close").on("click", function () {
        $('.ui.sidebar').sidebar('setting', 'transition', 'overlay').sidebar('toggle');
    })
    $(".header .back").on("click",function(){
        history.back();
    })

})