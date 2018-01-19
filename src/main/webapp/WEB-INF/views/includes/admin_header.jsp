<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">统一演示系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/deploy/list"/>">统一演示</a></li>
                <li><a href="http://lpf.gsafety.com/static/form_deployment.html">系统部署</a></li>
                <li><a href="<c:url value="/user/list"/>">用户管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/user/info?id=${user.id}"/>">个人信息</a></li>
                <li><a href="<c:url value="/login"/>">退出</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>