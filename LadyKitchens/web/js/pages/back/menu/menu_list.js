window.onload = function() {
	bind(ele("selAll"),"click",function(){
		handleSelectAll("menuid",this.checked) ;
	}) ;
};
var jsUrl = "" ;
$(document).ready(function() {
    $(".click").click(function() {
        var eleId = this.id ;
        if (eleId == "addBtn") {	// 如果是由
            window.location = getContextPath()+"/pages/back/menu/MenuServlet/insertPre";
            return;
        }
        $(".tip").fadeIn(200,function(){
            if (eleId == "delBtn") {	// 删除处理
                var nid = "" ;	// 保存所有的删除的ID编号
                var nidEle = document.all("menuid") ;
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
                    jsUrl = "/pages/back/menu/MenuServlet/delete?ids=" + nid ;
                    document.getElementById("pMsg").innerHTML = "是否要删除这些菜品？" ;
                } else {	// 没有选择任何的数据
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "未选择任何菜品！" ;
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
                window.location = getContextPath()+jsUrl ;
            }
        });
    });

    $(".cancel").click(function() {
        $(".tip").fadeOut(100);
    });
    $('.tablelist tbody tr:odd').addClass('odd');
});