/**
 * Created by bitcoinreaver on 2/18/17.
 */


function agentModeSwitch() {
    if($("#agent-cb")[0].checked) {
        // 使用代理
        $("a", "[id=search]").each(function(){
            //FIXME
            var url = encodeURI($(this).attr("href"));
            if(url.indexOf("/search?q=") == -1) {
                var agentUrl = "/url?q=" + url + $(this).attr("param-data");
                $(this).attr("href", agentUrl);
            }
        })
    } else {
        // 不使用代理
    	// 属性选择器不使用引号就报错; 2017-05-25 之前运行正常, jQuery 更新导致?
    	// 又不报错了,奇怪
//        $("a", [id=search]).each(function(){
        $("a", "[id=search]").each(function(){
            var url = $(this).attr("href");
            if(url.indexOf("/url?q=") > -1) {
                var pIndex = url.indexOf("&sa=")
                var originalUrl = url.substring(7, pIndex);
                $(this).attr("href", originalUrl);
            }
        })
    }
}


$(function () {
//  $("a", [id=search]).each(function(){
    $("a", "[id=search]").each(function(){
        var url = $(this).attr("href");
        if(url.indexOf("/url?q=") > -1) {
            var pIndex = url.indexOf("&sa=")
            var originalUrl = decodeURIComponent(url.substring(7, pIndex));
            var params = url.substr(pIndex)
            $(this).attr("href", originalUrl);
            $(this).attr("param-data", params)
        }
    })
    //$(".st b").css("color", "#dd4b39");
    // $("#agent-cb").click(agentModeSwitch);

})