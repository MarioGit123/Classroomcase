<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 筱
  Date: 2019-04-23
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath() %>/">
    <title>查看</title>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script>
        $(function () {
            $(".bianji").on("click", function () {
                var id = $(this).val();
                console.log(id);
                window.location.href = "http://localhost:8080/web/addvip?mid=" + id;
            })
        })
    </script>
</head>
<body>
<div>


    <table border="1" cellpadding="0">
        <tr>
            <td>会员头像</td>
            <td>会员姓名</td>
            <td>真实姓名</td>
            <td>性别</td>
            <td>生日</td>
            <td>星座</td>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>
                    <img src="'${list.head} '">

                </td>
                <td>${list.nickname}</td>
                <td>${list.realname}</td>
                <td>${list.sex}</td>
                <td>${list.birth}</td>
                <td>${list.constellation}</td>
                <td>
                    <button class="bianji" value="${list.meid}">编辑</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
