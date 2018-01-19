<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>系统列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/admin_header.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-xs-6"><h4>系统列表</h4></div>
        <%--<a href="/TencentMailStatusChange/upload?id=4">ss</a>--%>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" action="/deploy/list" method="get">
                <div class="form-group">
                    <label class="control-label col-sm-4">搜索条件</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="searchText" name="searchText"
                               value="${param.searchText}"
                               placeholder="请输入系统名、系统所属行业">
                    </div>
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <table class="table ">
                <tr>
                    <th>系统名称</th>
                    <th>所属行业</th>
                    <th>系统状态</th>
                    <%--<th>上传图片</th>--%>
                </tr>
                <c:forEach var="map" items="${maps}">
                    <tr>
                        <td><a href="/deploy/details?name=${map.get("name")}">${map.get("name")}</a></td>
                        <td>${map.get("industry")}</td>
                        <td>${map.get("status")}</td>
                        <%--<td><a href="/deploy/upload?id=${deploy.id}">点击上传</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <nav>
            <div class="col-xs-3"></div>
            <ul class="pager col-xs-6">
                <c:choose>
                    <c:when test="${offset >= limit}">
                        <li class="previous">
                            <a href="/deploy/list?searchText=${param.searchText}&offset=${offset - limit}">上一页</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="previous disabled"><a href="#">上一页</a></li>
                    </c:otherwise>
                </c:choose>

                <li>
                    <a readonly>当前页：${pageNum}/${totalPages}总页数</a>
                    <input id="pageNumber" style="width: 50px">
                    <a onclick="a()">跳转</a>
                </li>
                <c:choose>
                    <c:when test="${deploys.size() >= limit}">
                        <li class="next">
                            <a href="/deploy/list?searchText=${param.searchText}&offset=${offset + limit}">下一页</a>
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
</div>
<jsp:include page="../includes/footer.jsp"/>
<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>
<script type="text/javascript">
    function a() {

        var pagenum = document.getElementById("pageNumber").value;
        if (pagenum <= 0) {
            alert("请输入大于零的整数");
            pagenum=1;
        }
        if(pagenum>${totalPages}){
            alert("已经是最后一页！")
            pagenum=${totalPages}
        }

        var p = (pagenum - 1) * ${limit};
        window.location.href = '/deploy/list?searchText=${param.searchText}&offset=' + p;
    }
</script>
</body>
</html>


<%--<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>--%>
<%--<% request.setCharacterEncoding("UTF-8"); %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="cn">--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>系统列表</title>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">--%>
    <%--<link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="../includes/admin_header.jsp"/>--%>
<%--<div class="container">--%>

    <%--<div class="row">--%>
        <%--<div class="col-xs-6"><h4>系统列表</h4></div>--%>
        <%--&lt;%&ndash;<a href="/TencentMailStatusChange/upload?id=4">ss</a>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--<div class="row">--%>
        <%--<div class="col-xs-12">--%>
            <%--<form class="form-horizontal" action="/deploy/list" method="get">--%>
                <%--<div class="form-group">--%>
                    <%--<label class="control-label col-sm-4">搜索条件</label>--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<input type="text" class="form-control" id="searchText" name="searchText"--%>
                               <%--value="${param.searchText}"--%>
                               <%--placeholder="请输入系统名、系统所属行业">--%>
                    <%--</div>--%>
                    <%--<div class="col-sm-4">--%>
                        <%--<button type="submit" class="btn btn-primary">搜索</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row">--%>
        <%--<div class="col-xs-12">--%>
            <%--<table class="table ">--%>
                <%--<tr>--%>
                    <%--<th>系统名称</th>--%>
                    <%--<th>所属行业</th>--%>
                    <%--<th>系统状态</th>--%>
                    <%--&lt;%&ndash;<th>上传图片</th>&ndash;%&gt;--%>
                <%--</tr>--%>
                <%--<c:forEach var="deploy" items="${deploys}">--%>
                    <%--<tr>--%>
                        <%--<td><a href="/deploy/details?id=${deploy.id}">${deploy.systemName}</a></td>--%>
                        <%--<td>${deploy.industry}</td>--%>
                        <%--<td>${deploy.systemStatus}</td>--%>
                        <%--&lt;%&ndash;<td><a href="/deploy/upload?id=${deploy.id}">点击上传</a></td>&ndash;%&gt;--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="row">--%>
        <%--<nav>--%>
            <%--<div class="col-xs-3"></div>--%>
            <%--<ul class="pager col-xs-6">--%>
                <%--<c:choose>--%>
                    <%--<c:when TencentMailStatusChange="${offset >= limit}">--%>
                        <%--<li class="previous">--%>
                            <%--<a href="/deploy/list?searchText=${param.searchText}&offset=${offset - limit}">上一页</a>--%>
                        <%--</li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li class="previous disabled"><a href="#">上一页</a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>

                <%--<li>--%>
                    <%--<a readonly>当前页：${pageNum}/${totalPages}总页数</a>--%>
                    <%--<input id="pageNumber" style="width: 50px">--%>
                    <%--<a onclick="a()">跳转</a>--%>
                <%--</li>--%>
                <%--<c:choose>--%>
                    <%--<c:when TencentMailStatusChange="${deploys.size() >= limit}">--%>
                        <%--<li class="next">--%>
                            <%--<a href="/deploy/list?searchText=${param.searchText}&offset=${offset + limit}">下一页</a>--%>
                        <%--</li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li class="next disabled"><a href="#">下一页</a></li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</ul>--%>
            <%--<div class="col-xs-3"></div>--%>
        <%--</nav>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<jsp:include page="../includes/footer.jsp"/>--%>
<%--<script src="<c:url value="/statics/jquery-1.12.4/jquery-1.12.4.js"/>"></script>--%>
<%--<script src="<c:url value="/statics/jquery-ui-1.12.1/jquery-ui.js"/>"></script>--%>
<%--<script type="text/javascript">--%>
    <%--function a() {--%>

        <%--var pagenum = document.getElementById("pageNumber").value;--%>
        <%--if (pagenum <= 0) {--%>
            <%--alert("请输入大于零的整数");--%>
            <%--pagenum=1;--%>
        <%--}--%>
        <%--if(pagenum>${totalPages}){--%>
            <%--alert("已经是最后一页！")--%>
            <%--pagenum=${totalPages}--%>
        <%--}--%>

        <%--var p = (pagenum - 1) * ${limit};--%>
        <%--window.location.href = '/deploy/list?searchText=${param.searchText}&offset=' + p;--%>
    <%--}--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>

