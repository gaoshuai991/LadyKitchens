<%@ page pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/css/style_back.css">
<%
	request.setCharacterEncoding("UTF-8") ;
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	String url = null ;
	int currentPage = 1 ;
	int lineSize = 5 ;
	String column = null ;
	String keyWord = null ;
	int allRecorders = 0 ;
	int pageSize = 0 ;
	int lsData [] = new int [] {1,3,5,10,15,20,30,50,100} ;
	int seed = 3 ;	// 种子数
	String paramName = request.getParameter("paramName") ;
	String paramValue = request.getParameter("paramValue") ;
%>

<%	// 接收传递的参数
	try {
		currentPage = (Integer) request.getAttribute("currentPage") ;
	} catch (Exception e) {}
	try {
		allRecorders = (Integer)request.getAttribute("allRecorders") ;
	} catch (Exception e) {}
	try {
		lineSize = (Integer) request.getAttribute("lineSize") ;
	} catch (Exception e) {}
	column = (String) request.getAttribute("column") ;
	keyWord = (String) request.getAttribute("keyWord") ;
	url = basePath + request.getAttribute("url") ;
%>
<%
	if (allRecorders > 0) {
		pageSize = (allRecorders + lineSize - 1) / lineSize ;
	} else {	// 没有记录
		pageSize = 1 ;
	}
%>

<ul class="pagination">
	<%
		if (pageSize > seed * 3) {
	%>
	        <li class="<%=currentPage == 1?"active":""%>"><a onclick="goSplit(1)">1</a></li>

	<%
		    if (currentPage > seed * 2) {
	%>
	            <li class="disabled"><span>...</span></li>
	<%
                int startPage = currentPage - seed ;
                int endPage = currentPage + seed ;
                for (int x = startPage ; x <= endPage ; x ++) {
                    if(x < pageSize) {
	%>
	                    <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
	<%
                    }
                }
                if ((currentPage + seed * 2) <= pageSize) {
	%>
	                <li class="disabled"><span>...</span></li>
	<%
                }
            } else {	// 还在6页以前
                for (int x = 2 ; x <= currentPage + seed ; x ++) {
	%>
	                <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
	<%
                }
                if ((currentPage + seed * 2) <= pageSize) {
	%>
	                <li class="disabled"><span>...</span></li>
	<%
                }
            }
	%>
	        <li class="<%=currentPage == pageSize?"active":""%>"><a onclick="goSplit(<%=pageSize%>)"><%=pageSize%></a></li>
	<%
            } else {
                for (int x = 1 ; x <= pageSize ; x ++) {
    %>
	                <li class="<%=currentPage == x?"active":""%>"><a onclick="goSplit(<%=x%>)"><%=x%></a></li>
	<%
			    }
		    }
	%>
</ul>
<div class="text-danger" style="font-size: 16px">
	每页显示
	<select name="ls" id="ls" onchange="goSplit(1)" class="form-control" style="width: 75px;display: inline">
		<%
			for (int x=0;x < lsData.length;x++){
		%>
		        <option value="<%=lsData[x]%>" <%=lineSize==lsData[x]?"selected":""%>><%=lsData[x]%></option>
		<%
			}
		%>
	</select>
	条数据
</div>
<script type="text/javascript">
    function goSplit(vcp) {	// 根据外部传递的cp内容进行操作
        try {
            var ls = document.getElementById("ls").value;
            var eleKw = document.getElementById("kw").value ;
            var eleCol = document.getElementById("colSel").value ;
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + ls + "&kw=" + eleKw + "&col=" + eleCol + "&<%=paramName%>=<%=paramValue%>" ;
        } catch (Exception) {
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + ls + "&<%=paramName%>=<%=paramValue%>" ;
        }
    }
</script>