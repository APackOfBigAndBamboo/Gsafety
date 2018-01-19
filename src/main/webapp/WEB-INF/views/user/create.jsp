<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>新建用户</title>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="../includes/admin_header.jsp"/>--%>
<%--<div class="container">--%>
    <%--<div class="row">--%>
        <%--<div class="col-xs-6"><h4>新建系统用户</h4></div>--%>
        <%--<div class="col-xs-6"></div>--%>
    <%--</div>--%>
    <%--<form:form method="post" commandName="user">--%>
        <%--<div class="row">--%>
            <%--<div class="col-xs-6">--%>
                <%--<spring:bind path="account">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="account" >账号</form:label>--%>
                        <%--<form:input path="account" cssClass="form-control" placeholder="请输入账号名"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="password">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="password" cssClass="control-label">密码</form:label>--%>
                        <%--<form:input path="password" cssClass="form-control" placeholder="请输入密码"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="name">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="name" cssClass="control-label">用户名</form:label>--%>
                        <%--<form:input path="name" cssClass="form-control" placeholder="用户名"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>

                <%--<spring:bind path="accountType">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="accountType" cssClass="control-label">账号类型</form:label>--%>
                        <%--<form:select path="accountType" cssClass="form-control">--%>
                            <%--<form:option value="普通用户" >普通用户</form:option>--%>
                            <%--<form:option value="系统管理员">系统管理员</form:option>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>
            <%--</div>--%>
            <%--<div class="col-xs-6">--%>

                <%--<spring:bind path="department">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="department" cssClass="control-label">所属部门</form:label>--%>
                        <%--<form:input path="department" cssClass="form-control" placeholder="请输入所属部门"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="accountStatus">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="accountStatus" cssClass="control-label">账号状态</form:label>--%>
                        <%--<form:select path="accountStatus" cssClass="form-control">--%>
                            <%--<form:option value="可用" >可用</form:option>--%>
                            <%--<form:option value="禁用">禁用</form:option>--%>
                        <%--</form:select>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>

                <%--<spring:bind path="mobile">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="mobile" cssClass="control-label">联系电话</form:label>--%>
                        <%--<form:input path="mobile" cssClass="form-control" placeholder="请输入联系电话"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>
                <%--<spring:bind path="email">--%>
                    <%--<div class="form-group">--%>
                        <%--<form:label path="email" cssClass="control-label">邮箱</form:label>--%>
                        <%--<form:input path="email" cssClass="form-control" placeholder="请输入可用邮箱"></form:input>--%>
                    <%--</div>--%>
                <%--</spring:bind>--%>

            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="row">--%>
            <%--<div class="col-xs-3">--%>
            <%--</div>--%>
            <%--<div class="col-xs-3">--%>
                <%--<button type="submit" class="btn btn-primary">新建</button>--%>
            <%--</div>--%>

            <%--<div class="col-xs-6">--%>
                <%--<a class="btn btn-success" href="list">返回</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form:form>--%>
<%--</div>--%>
<%--<jsp:include page="../includes/footer.jsp"/>--%>
<%--<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/jquery-ui-1.12.1/datepicker-zh-CN.js"/>"></script>--%>
<%--</body>--%>
<%--</html>--%>
