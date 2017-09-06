window.onload = function() {
	bind(ele("selAll"),"click",function(){
		handleSelectAll("typeid",this.checked) ;
	}) ;
	// bind(ele("delBtn"),"click",function(){
	// 	handleDelete("menuid","pages/back/member/MemberServletBack/rm?p=p") ;
	// }) ;
};
var jsUrl = "" ;
$(document).ready(function() {
    $(".click").click(function() {
        var eleId = this.id ;
        $(".tip").fadeIn(200,function(){
            if (eleId == "addBtn") {	// 如果是由
                var newtypename = $("#newtypename").val();
                if(newtypename == null||newtypename == ""){
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "菜品类型名称不能为空！";
                }else {
                    jsUrl = "/pages/back/type/TypeServlet/insert?type.name=" + newtypename;
                    document.getElementById("pMsg").innerHTML = "确认添加此菜品类型？";
                }
            }else if (eleId == "delBtn") {	// 删除处理
                var nid = "" ;	// 保存所有的删除的ID编号
                var nidEle = document.all("typeid") ;
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
                    jsUrl = "/pages/back/type/TypeServlet/delete?ids=" + nid ;
                    document.getElementById("pMsg").innerHTML = "是否要删除这些菜品？" ;
                } else {	// 没有选择任何的数据
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "未选择任何菜品！" ;
                }
            }else{
                var typeid = eleId.split("-")[1];
                var typename = $("#" + "typename-"+typeid).val();
                if(typename == ""){
                    jsUrl = "" ;
                    document.getElementById("pMsg").innerHTML = "菜品类型名称不能为空！";
                }else{
                    jsUrl = "/pages/back/type/TypeServlet/update?type.id="+typeid+"&type.name="+typename;
                    document.getElementById("pMsg").innerHTML = "确认修改此菜品类型名称" ;
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
                window.location = getContextPath()+ jsUrl ;
            }
        });
    });

    $(".cancel").click(function() {
        $(".tip").fadeOut(100);
    });
    $('.tablelist tbody tr:odd').addClass('odd');
});