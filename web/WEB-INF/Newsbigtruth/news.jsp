<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 筱
  Date: 2019-04-21
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
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
</head>
<body>
<div class="box">
    <h2>新闻列表</h2>
    <ul>
        <!-- 分页数据，存储在分页对象Pager中 -->
        <c:if var="c" test="${empty pager.data}">
            <li>没有数据</li>
        </c:if>
        <c:if test="${not c }">
            <c:forEach var="n" items="${pager.data}" varStatus="vs">
                <li>
                    <span class="num">${vs.count}</span>
                    <a href="new?newsid=${n.newsid }">${n.title}</a>
                    <span class="time">
						<fmt:formatDate value="${n.newdate}"
                         pattern="yyyy年MM月dd日 HH:mm"/>
					</span>
                </li>
            </c:forEach>
        </c:if>
    </ul>
    <div class="pager">
        <c:if test="${not pager.first}">
            <a href="news?pageno=1">首页</a>
        </c:if>
        <c:if var="c" test="${pager.prev==pager.pageno }">
            <a style="cursor: not-allowed">上一页</a>
        </c:if>
        <c:if test="${not c }">
            <a href="news?pageno=${pager.prev }">上一页</a>
        </c:if>

        <a>当前第${pager.pageno }页</a>
        <c:if var="c" test="${pager.next==pager.pageno}">
            <a style="cursor: not-allowed">下一页</a>
        </c:if>
        <c:if test="${not c }">
            <a href="news?pageno=${pager.next }">下一页</a>
        </c:if>
        <c:if test="${not pager.last}">
            <a href="news?pageno=${pager.pagecount}">尾页</a>
        </c:if>
        <a>共${pager.pagecount}页</a>
    </div>
</div>
<p>

</p>
</body>
</html>
