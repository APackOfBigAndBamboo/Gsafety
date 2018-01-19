<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/statics/bootstrap-3.3.0/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/statics/css/style.css"/>">
</head>
<body>
<jsp:include page="../includes/admin_header.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-xs-6"><h4>用户列表</h4></div>
    </div>
    <div class="row">

        <div class="col-xs-12">
            <form class="form-horizontal" action="list" method="get">
                <div class="form-group">
                    <label class="control-label col-sm-2">账号关键字</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="searchText" name="searchText"
                               value="${param.searchText}"
                               placeholder="请输入账号名、所属部门、账号状态、账号类型">
                    </div>
                    <div class=" col-sm-2">
                        <button type="submit" class="btn btn-primary">查询</button>
                    </div>
                    <%--<div class="col-sm-2"><a class="btn btn-primary center-pill"--%>
                    <%--href="<c:url value="/user/create"/>">新建用户</a></div>--%>
                    <div class="col-sm-2"><a class="btn btn-primary center-pill"
                                             href="<c:url value="/user/sync"/>">同步数据</a></div>
                </div>

            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <table class="table table-striped">
                <tr>
                    <th>用户名</th>
                    <th>所属部门</th>
                    <th>账号状态</th>
                    <th>账号类型</th>
                    <th>修改</th>

                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><a href="edit?id=${user.id}">${user.name}</a></td>
                        <td>${user.department}</td>
                        <td>${user.accountStatus}</td>
                        <td>${user.accountType}</td>
                        <td><a href="edit?id=${user.id}">修改</a>
                        </td>
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
                            <a href="list?searchText=${param.searchText}&offset=${offset - limit}">上一页</a>
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
                    <c:when test="${users.size() >= limit}">
                        <li class="next">
                            <a href="list?searchText=${param.searchText}&offset=${offset + limit}">下一页</a>
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
            pagenum = 1;
        }
        if(pagenum>${totalPages}){
            alert("已经是最后一页！")
            pagenum=${totalPages}
        }
        var p = (pagenum - 1) *  ${limit};
        window.location.href = 'list?searchText=${param.searchText}&offset=' + p;
    }
</script>
</body>
</html>

