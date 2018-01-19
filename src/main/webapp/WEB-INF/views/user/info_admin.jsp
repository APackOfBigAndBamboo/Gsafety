<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/admin_header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-10">
            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="edit?id=${param.id}">基本信息</a></li>
                <li role="presentation"><a href="/user/editaccesscontrol?id=${param.id}">权限控制</a></li>
                <li role="presentation"><a href="/user/changepassword?id=${param.id}">修改密码</a></li>
                <li role="presentation"><a href="/user/resetpassword?id=${param.id}">重置密码</a></li>
            </ul>
            <div class="tab-content">
                <form:form method="post" commandName="user">
                    <spring:bind path="department">
                        <div class="form-group">
                            <form:label path="department" cssClass="control-label">所属部门</form:label>
                            <form:input path="department" cssClass="form-control" placeholder="请输入所属部门" readonly="true"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="name">
                        <div class="form-group">
                            <form:label path="name" cssClass="control-label">账户名</form:label>
                            <form:input path="name" cssClass="form-control" placeholder="请输入账户名" readonly="true"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="accountStatus">
                        <div class="form-group">
                            <form:label path="accountStatus" cssClass="control-label">账号状态</form:label>
                            <form:select path="accountStatus" cssClass="form-control">
                                <form:option value="可用" >可用</form:option>
                                <form:option value="禁用">禁用</form:option>
                            </form:select>
                        </div>
                    </spring:bind>
                    <spring:bind path="accountType">
                        <div class="form-group">
                            <form:label path="accountType" cssClass="control-label">账号类型</form:label>
                            <form:select path="accountType" cssClass="form-control">
                                <form:option value="普通用户" >普通用户</form:option>
                                <form:option value="系统管理员">系统管理员</form:option>
                            </form:select>
                        </div>
                    </spring:bind>
                    <spring:bind path="mobile">
                        <div class="form-group">
                            <form:label path="mobile" cssClass="control-label">联系方式</form:label>
                            <form:input path="mobile" cssClass="form-control" readonly="true"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="email">
                        <div class="form-group">
                            <form:label path="email" cssClass="control-label">邮箱</form:label>
                            <form:input path="email" cssClass="form-control" readonly="true"></form:input>
                        </div>
                    </spring:bind>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">保存</button>
                        <a class="btn btn-success pull-right" href="list">返回</a>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="col-xs-1"></div>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/datepicker-zh-CN.js"/>"></script>
</body>
</html>