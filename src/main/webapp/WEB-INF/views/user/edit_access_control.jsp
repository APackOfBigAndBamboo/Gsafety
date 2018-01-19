<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.theme.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<script type="text/javascript"></script>
<body>
<jsp:include page="../includes/admin_header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-1"></div>
        <div class="col-xs-10">
            <ul class="nav nav-tabs">
                <li role="presentation"><a href="edit?id=${param.id}">基本信息</a></li>
                <li role="presentation" class="active"><a href="/user/editaccesscontrol?id=${param.id}">权限控制</a></li>
                <li role="presentation"><a href="/user/changepassword?id=${param.id}">修改密码</a></li>
                <li role="presentation"><a href="/user/resetpassword?id=${param.id}">重置密码</a></li>
            </ul>

            <div class="tab-content">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active" style="font-size: large">请为当前用户配置可演示系统</li>
                </ul>
                <div class="row" style="margin: auto">
                    <div class="col-xs-12">

                        <div class="form-group">

                            <div class="control-label col-sm-2"></div>
                            <div class="control-label col-sm-2">
                                <p class="control-label" style="font-size: large">搜索条件</p>
                            </div>

                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="searchText" name="searchText"
                                       value="${param.searchText}"
                                       placeholder="请输入系统名、系统所属行业">
                            </div>
                            <div class="col-sm-4">
                                <button type="submit" class="btn btn-primary" onclick="a()">搜索</button>
                            </div>
                        </div>

                    </div>
                </div>
                <br>
                <form:form commandName="user" method="post">
                    <div class="form-group row">
                        <c:forEach items="${deploys}" var="deploy" varStatus="deployStatus">
                            <div class="col-sm-6"><input type="checkbox" name="checkbox" id="checkbox"
                                                         value="${deploy.id}" />${deploy.systemName}&nbsp;&nbsp;&nbsp;(所属行业：${deploy.industry})
                            </div>
                        </c:forEach>
                    </div>
                    <spring:bind path="id">
                        <div class="form-group" hidden>
                            <form:input path="id" name="id" cssClass="form-control"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="accessControl">
                        <div class="form-group" hidden>
                            <form:input path="accessControl" name="accessControl" cssClass="form-control" ></form:input>
                        </div>
                    </spring:bind>

                    <div class="row">
                        <nav>
                            <div class="col-xs-3"></div>
                            <ul class="pager col-xs-6">
                                <c:choose>
                                    <c:when test="${offset >= limit}">
                                        <li class="previous">
                                            <a href="/user/editaccesscontrol?id=${param.id}&searchText=${param.searchText}&offset=${offset - limit}">上一页</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="previous disabled"><a href="#">上一页</a></li>
                                    </c:otherwise>
                                </c:choose>
                                <li>
                                    <a readonly>当前页：${pageNum}/${totalPages}总页数</a>
                                    <input id="pageNumber" style="width: 50px">
                                    <a onclick="b()">跳转</a>
                                </li>
                                <c:choose>
                                    <c:when test="${deploys.size() >= limit}">
                                        <li class="next">
                                            <a href="/user/editaccesscontrol?id=${param.id}&searchText=${param.searchText}&offset=${offset + limit}">下一页</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="next disabled"><a href="#">下一页</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                            <div class="col-xs-3"></div>
                        </nav>
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
<script type="text/javascript">
    $("input#checkbox").click(function () {
        var access = $(this).val();
        $.get("/user/editaccesscontroller?id=" + ${param.id}+"&access=" + access + "");
    });
    //
    //    function fun() {
    //        var boxes = document.getElementsByTagName("input");
    //        var str = "";
    //        for (var i = 0; i < boxes.length; i++) {
    //            if (boxes[i].name == "checkbox" && boxes[i].checked == true) {
    //                str += boxes[i].value + ',';
    //            }
    //        }
    //        $("#accessControl").val(str);
    //        alert("权限修改成功！")
    //    }

    $(document).ready(function () {
        var accesscontrol = '${user.accessControl}';
        var result = accesscontrol.split(",");
        for (var i = 0; i < result.length; i++) {
            $("input[value='" + result[i] + "']").attr("checked", "checked");
        }
    });

    function b() {
        var pagenum = document.getElementById("pageNumber").value;
        if (pagenum <= 0) {
            alert("请输入大于零的整数");
            pagenum = 1;
        }
        if (pagenum >${totalPages}) {
            alert("已经是最后一页！");
            pagenum =
            ${totalPages}
        }
        var p = (pagenum - 1) * ${limit};
        window.location.href = '/user/editaccesscontrol?id=${param.id}&searchText=${param.searchText}&offset=' + p;
    }

    function a() {
        var pagenum = document.getElementById("searchText").value;
        window.location.href = '/user/editaccesscontrol?id=${param.id}&searchText=' + pagenum + '&offset=';
    }
</script>
</body>

</html>
