<%@ page import="com.zhuozhengsoft.pageoffice.PageOfficeLink" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%String script = (String) request.getSession(true).getAttribute("script");
    System.out.println(script);%>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body style="font-family: 微软雅黑">
<jsp:include page="../includes/admin_header.jsp"/>
<a href=></a>
<div class="container">
    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-10">
            <ul class="nav nav-tabs">
                <li role="presentation" class="active" style="font-size: x-large">系统详细信息</li>
            </ul>
            <div>
                <%--<div class="tab-content">--%>
                <form:form method="post" action="${map.url}" commandName="map">
                    <div class="text-center">
                        <label style="font-size: x-large">${map.get("name")}</label>
                    </div>
                    <div class="text-center">
                        <p class="text-center" style="font-size: small">演示要求浏览器：&nbsp; ${map.get("type")}</p>
                    </div>
                    <div >
                        <c:if test="${!empty isnull}">
                            <div class="form-group ">
                                <label for="systemSynopsis">系统简介</label>
                                <textarea cols="80%" rows="10" id="" class="form-control">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${map.get("summary")}</textarea>
                            </div>
                        </c:if>
                        <c:if test="${empty isnull}">
                            <label for="systemSynopsis">系统简介</label>
                            <div class="row">
                            <div class="form-group col-xs-4">
                                    <img src="/deploy/getpicture?obj=${screenshots}"width="100%" height="30%"  >
                                <%--<img  href="http://lpf.gsafety.com${screenshots}" width="100%" height="30%"  >--%>
                            </div>
                            <div class="form-group col-xs-8">

                                <textarea cols="80%" rows="10" id="systemSynopsis" class="form-control">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${map.get("summary")}</textarea>
                            </div>
                            </div>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <label>用户手册</label>
                        <br>
                            <%--<a href="/pdf?id=${map.id}">查看</a>--%>
                        <i class=" icon-search"></i>&nbsp;<a
                            href="http://lpf.gsafety.com${script}">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
                            class="icon-download-alt"></i>&nbsp;<a href="http://lpf.gsafety.com${script}">下载</a>
                        <%--<i class=" icon-search"></i>&nbsp;<a--%>
                            <%--href="<%=PageOfficeLink.openWindow(request,"/pdf?name="+script,"width=auto;height=auto;")%>">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i--%>
                            <%--class="icon-download-alt"></i>&nbsp;<a href="${map.script}">下载</a>--%>
                    </div>
                        <div class="form-group">
                        <label>演示脚本</label>
                        <br>
                        <i class=" icon-search"></i>&nbsp;<a href="${map.script}">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
                            class="icon-download-alt"></i>&nbsp;<a href="${map.script}">下载</a>
                    </div>
                    <div class="form-group">
                        <p style="font-family: 微软雅黑">
                            系统支持人员邮箱: ${map.get("supporter")}</p>
                    </div>

                    <div class="form-group">
                        <c:if test="${!empty fail}">
                                <a  href="#" class="btn btn-warning disabled">${fail}</a>
                        </c:if>
                        <c:if test="${empty fail}">
                            <button href="${map.get("url")}" class="btn btn-primary">开始演示</button>
                        </c:if>

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
<%--<%@ page import="com.zhuozhengsoft.pageoffice.PageOfficeLink" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%Integer id = (Integer) request.getSession(true).getAttribute("id");%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>系统详情</title>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/font-awesome.min.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/fonts/fontawesome-webfont.eot?v=3.2.1"/>"/>&ndash;%&gt;--%>
<%--</head>--%>
<%--<body style="font-family: 微软雅黑">--%>
<%--<jsp:include page="../includes/admin_header.jsp"/>--%>
<%--<a href=></a>--%>
<%--<div class="container">--%>
    <%--<div class="row">--%>
        <%--<div class="col-xs-1"></div>--%>
        <%--<div class="col-xs-10">--%>
            <%--<ul class="nav nav-tabs">--%>
                <%--<li role="presentation" class="active" style="font-size: x-large">系统详细信息</li>--%>
            <%--</ul>--%>
            <%--<div>--%>
                <%--&lt;%&ndash;<div class="tab-content">&ndash;%&gt;--%>
                <%--<form:form method="post" action="${deploy.url}" commandName="deploy">--%>
                    <%--<div class="text-center">--%>
                        <%--<label style="font-size: x-large">${deploy.systemName}</label>--%>
                    <%--</div>--%>
                    <%--<div class="text-center">--%>
                        <%--<p class="text-center" style="font-size: small">演示要求浏览器：&nbsp; ${deploy.browser}</p>--%>
                    <%--</div>--%>
                    <%--<div >--%>
                        <%--<c:if TencentMailStatusChange="${!empty isnull}">--%>
                            <%--<div class="form-group ">--%>
                                <%--<label for="systemSynopsis">系统简介</label>--%>
                                <%--<textarea cols="80%" rows="10" id="" class="form-control">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${deploy.systemSynopsis}</textarea>--%>
                            <%--</div>--%>
                        <%--</c:if>--%>
                        <%--<c:if TencentMailStatusChange="${empty isnull}">--%>
                            <%--<div class="row">--%>
                            <%--<div class="form-group col-xs-4">--%>
                                <%--<img src="/deploy/getpicture?id=${deploy.id}"width="100%" height="30%"  >--%>
                            <%--</div>--%>
                            <%--<div class="form-group col-xs-8">--%>
                                <%--<label for="systemSynopsis">系统简介</label>--%>
                                <%--<textarea cols="80%" rows="10" id="systemSynopsis" class="form-control">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${deploy.systemSynopsis}</textarea>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                        <%--</c:if>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label>用户手册</label>--%>
                        <%--<br>--%>
                            <%--&lt;%&ndash;<a href="/pdf?id=${deploy.id}">查看</a>&ndash;%&gt;--%>
                        <%--<i class=" icon-search"></i>&nbsp;<a--%>
                            <%--href="<%=PageOfficeLink.openWindow(request,"/pdf?id="+id,"width=auto;height=auto;")%>">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i--%>
                            <%--class="icon-download-alt"></i>&nbsp;<a href="${deploy.script}">下载</a>--%>
                    <%--</div>--%>
                        <%--<div class="form-group">--%>
                        <%--<label>演示脚本</label>--%>
                        <%--<br>--%>
                        <%--<i class=" icon-search"></i>&nbsp;<a href="${deploy.script}">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i--%>
                            <%--class="icon-download-alt"></i>&nbsp;<a href="${deploy.script}">下载</a>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<p style="font-family: 微软雅黑">--%>
                            <%--系统支持人员+（电话）: ${deploy.deploymentInterfacePeople}:${deploy.contact}</p>--%>
                    <%--</div>--%>
                    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<label for="contact">系统支持人员+（电话）:</label>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input type="text" class="form-control" id="contact"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;value="${deploy.deploymentInterfacePeople}:${deploy.contact}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--<div class="form-group">--%>
                        <%--<c:if TencentMailStatusChange="${!empty fail}">--%>
                                <%--<a  href="#" class="btn btn-warning disabled">${fail}</a>--%>
                        <%--</c:if>--%>
                        <%--<c:if TencentMailStatusChange="${empty fail}">--%>
                            <%--<button href="${deploy.url}" class="btn btn-primary">开始演示</button>--%>
                        <%--</c:if>--%>

                        <%--<a class="btn btn-success pull-right" href="list">返回</a>--%>
                    <%--</div>--%>
                <%--</form:form>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="col-xs-1"></div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<jsp:include page="../includes/footer.jsp"/>--%>
<%--<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/bootstrap-3.3.0/js/bootstrap.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/jquery-ui-1.12.1/datepicker-zh-CN.js"/>"></script>--%>
<%--</body>--%>
<%--</html>--%>
