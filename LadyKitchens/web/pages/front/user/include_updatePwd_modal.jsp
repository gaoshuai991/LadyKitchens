<%--
  Created by IntelliJ IDEA.
  User: Gss
  Date: 2017/9/4
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- 修改密码的Modal -->
<div class="modal fade" id="updatePwdModal" tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true"
     data-keyboard="true">
    <div class="modal-dialog" style="width: 1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">
                    <span class="glyphicon glyphicon-folder-open"></span>
                    <strong>订单详情</strong></h3>
            </div>
            <div class="modal-body">
                <form id="updatePwdForm" action="/pages/front/UserServlet/updatePwd" method="post">
                    <div class="row">
                        <div class="col-md-2 text-right"><strong>用户名：</strong></div>
                        <div class="col-md-8">${user.name}</div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>原密码：</strong></div>
                        <div class="col-md-8">
                            <input type="password" name="user.pwd" id="user.pwd">
                        </div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>新密码：</strong></div>
                        <div class="col-md-8">
                            <input type="password" name="newpwd" id="newpwd">
                        </div>
                    </div>
                    <div class="row" style="margin-top: 10px">
                        <div class="col-md-2 text-right"><strong>确认密码：</strong></div>
                        <div class="col-md-8">
                            <input type="password" name="confpwd" id="confpwd">
                        </div>
                    </div>
                    <div class="row" style="margin-top: 20px;margin-left: 165px">
                        <input type="hidden" name="user.id" value="${user.id}">
                        <input type="submit" class="btn btn-primary" value="修改">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
            </div>
        </div>
    </div>
</div>
