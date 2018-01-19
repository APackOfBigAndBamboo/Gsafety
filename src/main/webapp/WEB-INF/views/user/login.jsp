<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>统一演示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body  class="form-signin-body">
<div class="container">
    <form class="form-signin" action="<c:url value="/login"/>" method="post">
        <h2 class="form-signin-heading" style="font-family: 微软雅黑">统一演示系统</h2>
        <%--<input type="text" name='email' class="form-control" placeholder="账号" required autofocus value="1084150741@qq.com">--%>
        <%--<input type="password" name="password" class="form-control" placeholder="密码" required value="123456">--%>
        <input type="text" name='email' class="form-control" placeholder="账号" required autofocus value="zhangjiqiang@gsafety.com">
        <input type="password" name="password" class="form-control" placeholder="密码" required value="123456">
         <c:if test="${!empty fail}">
            <div class="alert alert-success" role="alert">
                <b>${fail}</b>
            </div>
        </c:if>
        <c:if test="${param.logout != null}" >
            <div class="alert alert-success" role="alert">
                您已成功退出系统
            </div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">登录</button>
    </form>
</div>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
</body>
</html>
