/*<![CDATA[*/
function scroll() {
    $("#logo_index").attr("src", "/images/Design/Group.png");
    $(this).attr("src", "/images/Design/Group.png");
    $(".foot").show()
}
$(document).ready(function () {
    $("#after_scroll").hide();
    $(".foot").hide();
    $("#scroll-up").click(function () {
        $("#panel").css({"min-height": "47px"});
        $("#panel").css({"border-bottom": "2px solid dodgerblue"});
        $(".clearfix").hide();
        $(".body_index").css({"margin-bottom": "60px"});
        $("#after_scroll").show();
        $("#scroll-up").hide();
        $("#logo_index").animate({height: "57", width: "47"}, 500);
        setTimeout(scroll, 500);
    });
});
/*]]>*/
