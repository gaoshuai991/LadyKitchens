<%@ page pageEncoding="UTF-8"%>
<%--
	实现数据搜索条的控制
<jsp:include page="split_page_plugin_search.jsp"/>
--%>
<%
	request.setCharacterEncoding("UTF-8") ;
	String url = (String)request.getAttribute("url") ;
	String columnData = (String)request.getAttribute("columnData") ;
	String keyWord = (String)request.getAttribute("keyword") ;
	String column = (String)request.getAttribute("column") ;
%>
<div id="searchDiv">
	<form action="<%=url%>" method="post">
		<%
			if (columnData != null) {
		%>
				<select class="form-control" id="col" name="col" style="display: inline;width: 120px">
				<%
					String result [] = columnData.split("\\|") ;
					for (int x = 0 ; x < result.length ; x ++) {
						String temp [] = result[x].split(":") ;
				%>
						<option value="<%=temp[1]%>" <%=column.equals(temp[1])?"selected":""%>><%=temp[0]%></option>
				<%
					}
				%>
				</select>
		<%
			}
		%>
		<input type="text" class="form-control" style="display: inline;width: 200px" name="kw" id="kw" placeholder="请输入模糊查询关键字" value="<%=keyWord == null ? "" : keyWord%>">
		<input type="submit" class="btn" style="margin-bottom: 5px" value="查询">
		<br>
	</form>
</div>