<%--
  Created by IntelliJ IDEA.
  User: 筱
  Date: 2019-04-21
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Insert title here</title>
</head>

<style>
    .box {
        width: 600px;
        margin: 0px auto;
        border: solid 1px black;
        padding: 10px 14px;
    }

    ul {
        list-style: none;
    }

    ul li {
        border-bottom: dashed 1px #444;
        height: 30px;
        line-height: 30px;
    }

    ul li .num {
        display: inline-block;
        background: #999;
        width: 29px;
        text-align: center;
        color: white;
    }

    ul li a {
        text-decoration: none;
        color: #333;
    }

    ul li .time {
        font-size: 12px;
        color: #ccc;
        float: right;
        margin-right: 10px;
    }

    .pager {
        background: #E8F2FE;
        width: 600px;
        margin: 20px auto;
    }

    .pager a {
        display: inline-block;
        border: solid 1px #ccc;
        text-align: center;
        margin-right: 15px;
    }
</style>
<body>
<div class="box">
    <h2>评论列表</h2>
    <ul>
        <!-- 分页数据，存储在分页对象Pager中 -->
        <c:if var="c" test="${empty commentPager.data}">
            <li>没有数据</li>
        </c:if>
        <c:if test="${not c }">
            <c:set var="comment" scope="session" value="${commentPager.data}"/>
            <c:forEach var="n" items="${commentPager.data}" varStatus="vs">
                <li>
                    <span class="num">${vs.count}</span>
                    <span>${n.content}</span>
                </li>
            </c:forEach>
        </c:if>
    </ul>
    <div class="pager">
        <c:if test="${not commentPager.first}">
            <a href="comment?pageno=1&newsid=${comment[0].newsid}">首页</a>
        </c:if>
        <c:if var="c" test="${commentPager.prev==commentPager.pageno }">
            <a style="cursor: not-allowed">上一页</a>
        </c:if>
        <c:if test="${not c }">
            <a href="comment?pageno=${commentPager.prev }&newsid=${comment[0].newsid }">上一页</a>
        </c:if>

        <a>当前第${commentPager.pageno }页</a>
        <c:if var="c" test="${commentPager.next==commentPager.pageno}">
            <a style="cursor: not-allowed">下一页</a>
        </c:if>
        <c:if test="${not c }">
            <a href="comment?pageno=${commentPager.next }&newsid=${comment[0].newsid }">下一页</a>
        </c:if>
        <c:if test="${not commentPager.last}">
            <a href="comment?pageno=${commentPager.pagecount}&newsid=${comment[0].newsid }">尾页</a>
        </c:if>
        <a>共${commentPager.pagecount}页</a>
    </div>
</div>
</body>

</html>
