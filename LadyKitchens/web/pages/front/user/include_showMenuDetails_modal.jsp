<%--
  Created by IntelliJ IDEA.
  User: Gss
  Date: 2017/9/4
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!-- 查看菜品详情的的Modal -->
<div class="modal fade" id="menuShowModal" tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true"
     data-keyboard="true">
    <div class="modal-dialog" style="width: 1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">
                    <span class="glyphicon glyphicon-folder-open"></span>
                    <strong>菜品详情</strong></h3>
            </div>
            <div class="modal-body" style="float: none">
                <div style="float: right;z-index: 9999">
                    <img src="" style="width: 260px;height: 180px" id="smimg">
                </div>
                <div class="row" style="height: 25px">
                    <div class="col-md-2 text-right"><strong>菜品名称：</strong></div>
                    <div class="col-md-5" id="smname">${user.name}</div>
                </div>
                <div class="row" style="margin-top: 10px;height: 25px">
                    <div class="col-md-2 text-right"><strong>所属分类：</strong></div>
                    <div class="col-md-5" id="smtype">

                    </div>
                </div>
                <div class="row" style="margin-top: 10px;height: 25px">
                    <div class="col-md-2 text-right"><strong>原材料：</strong></div>
                    <div class="col-md-5" id="smburden">
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;height: 35px">
                    <div class="col-md-2 text-right"><strong>简介：</strong></div>
                    <div class="col-md-5" id="smbrief">
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;height: 25px">
                    <div class="col-md-2 text-right"><strong>余量：</strong></div>
                    <div class="col-md-5" id="smsum">
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;height: 25px">
                    <div class="col-md-2 text-right"><strong>价格：</strong></div>
                    <div class="col-md-5" id="smprice" style="font-size: 20px;color: orangered">
                    </div>
                </div>
                <div class="row" style="margin-top: 20px;margin-left: 165px">
                    <input type="hidden" id="smid">
                    <input type="button" id="smbtn" class="btn btn-default"
                           style="background: #ff6218;font-weight: bold;color:whitesmoke;" value="加入购物车">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
            </div>
        </div>
    </div>
</div>

