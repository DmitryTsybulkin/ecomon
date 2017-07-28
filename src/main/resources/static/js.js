/*<![CDATA[*/
function scroll() {
    $("#logo_index").attr("src","/images/Design/Group.png");
    $(this).attr("src", "/images/Design/Group.png");
    $(".foot").show()
}
$(".scroll-down").mousemove(function () {
    $(".scroll-down").css({"border": "2px solid black"});
    $(".scroll-down:before").css({"border": "2px solid black"});
});
$(".scroll-down").mouseout(function () {
    $(".scroll-down").css({"border": "2px solid white"});
    $(".scroll-down:before").css({"border": "2px solid white"});
});
$(document).ready(function(){
    $("#after_scroll").hide();
    $(".foot").hide();
    $(".scroll-down").click(function(){
        $("#panel").css({"min-height": "47px"});
        $("#after_scroll").show();
        $(".scroll-down").hide();
        $("#logo_index").animate({height: "57", width: "47"}, 500);
        setTimeout(scroll,500);
    });
});
/*]]>*/
