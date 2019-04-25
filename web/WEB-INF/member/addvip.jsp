<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 筱
  Date: 2019-04-22
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=request.getContextPath()%>/">
    <title>addvip</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .addvipbox {
            display: none;
            width: 400px;
            margin: auto;
        }

        .boxm {
            width: 600px;
            margin: auto;
        }
    </style>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script>
        $(function () {
            var i = 0;






            $(".butt_add").on("click", function () {
                if (i % 2 === 0) {
                    $(".addvipbox").css(
                        "display", "block"
                    );
                } else {
                    $(".addvipbox").css(
                        "display", "none"
                    );
                }
                i++;
            });


           /* $(".butt_register").on("click", function () {
                var loginName = $(".lname").val();
                console.log("dseswswsw", loginName);
                var realNname = $(".realNname").val();
                var pwd = $(".pwd").val();
                var header = $(".header").val();
                console.log("图片路劲",header);
                var phone = $(".phone").val();
                var sex = $(".sex:checked").val();


                $.ajax({
                    type: "Post",
                    url: "addmem",
                    data: {
                        "loginName": loginName,
                        "realNname": realNname,
                        "pwd": pwd,
                        "header": header,
                        "sex": phone,
                        "birthday": sex
                    },
                    success:function (dat) {
                        console.log("成功：",dat);
                    }
                })
            })*/
        })

    </script>
</head>
<body>
<div class="boxm">
    <div>
        <p>会员信息</p>
       <table border="1" cellpadding="0">
           <tr>
               <td>会员姓名</td>
               <td>真实姓名</td>
               <td>会员头像</td>
               <td>积分</td>
               <td>注册时间</td>
               <td>电话</td>
               <td>性别</td>
               <td>出生日期</td>
           </tr>
           <c:forEach var="mem" items="${vip}">
               <tr>
                   <td>${mem.login_Name}</td>
                   <td>${mem.real_Name}</td>
                   <td>${mem.header_Image}</td>
                   <td>${mem.score}</td>
                   <td>${mem.reg_Time}</td>
                   <td>${mem.phone}</td>
                   <td>${mem.sex}</td>
                   <td>${mem.birthday}</td>

               </tr>
           </c:forEach>
       </table>



        <button class="butt_add"> 添加会员</button>
    </div>
    <div class="addvipbox"> <%-- 添加会员--%>
        <form action="${pageContext.request.contextPath}/addmem" method="post" enctype="multipart/form-data">
            <%--
             // 登录名
            //真实姓名
            // 密码
            //用户头像（存路径）
            //电话
            //性别
            // 出生日期
            --%>
            <p>
                登录名：<input type="text" name="loginName" class="lname">
            </p>
            <p>
                真实姓名：<input type="text" name="realNname" class="realNname">
            </p>
            <p>
                密码：<input type="password" name="pwd" class="pwd">
            </p>
            <p>
                用户头像：<input type="file" name="header" class="header">
            </p>
            <p>
                电话：<input type="text" name="phone" class="phone">
            </p>
            <p>
                性别：<input type="radio" name="sex" class="sex" value="男"> 男 <input type="radio" name="sex" class="sex" value="女">女
            </p>
            <p>
                出生日期：<input type="text" name="birthday" class="birthday">
            </p>
            <p>
                <input type="submit" value="确认" class="butt_register">
            </p>
        </form>
    </div>
</div>
</body>
</html>
