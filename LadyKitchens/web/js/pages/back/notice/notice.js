window.onload = function() {
	bind(ele("selAll"),"click",function(){
		handleSelectAll("noticeid",this.checked) ;
	}) ;
};
var jsUrl = "" ;
$(document).ready(function() {
    $(".click").click(function() {
        var eleId = this.id ;
        $(".tip").fadeIn(200,function(){
            if (eleId == "delBtn") {	// 删除处理
                var nid = "" ;	// 保存所有的删除的ID编号
                var nidEle = document.all("noticeid") ;
                if (nidEle.length != undefined) {
                    for (var x = 0 ; x < nidEle.length ; x ++) {
                        if (nidEle[x].checked) {
                            nid += nidEle[x].value + "|" ;
                        }
                    }
                } else {
                    if (nidEle.checked) {
                        nid = nidEle.value + "|" ;
                    }
                }
                if (nid != "") {
                    jsUrl = "/pages/back/notice/NoticeServlet/delete?ids=" + nid ;
                    document.getElementById("pMsg").innerHTML = "是否要删除这些公告？" ;
                } else {	// 没有选择任何的数据
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "未选择任何公告！" ;
                }
            }else{
                var noticeid = eleId.split("-")[1];
                var noticename = $("#noticename-"+noticeid).val();
                var nc = $("#nc-" + noticeid).val();
                if(noticename == ""){
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "公告标题不能为空！";
                }else{
                    jsUrl = "/pages/back/notice/NoticeServlet/update?notice.id="+noticeid+"&notice.name="+noticename+"&notice.content="+nc;
                    document.getElementById("pMsg").innerHTML = "确认修改此公告内容？" ;
                }
            }
        });
    });

    $(".tiptop a").click(function() {
        $(".tip").fadeOut(200);
    });

    $(".sure").click(function() {
        $(".tip").fadeOut(100,function() {
            if (jsUrl != "") {
                console.log(jsUrl);
                window.location = getContextPath()+jsUrl ;
            }
        });
    });

    $(".cancel").click(function() {
        $(".tip").fadeOut(100);
    });
    $('.tablelist tbody tr:odd').addClass('odd');
});