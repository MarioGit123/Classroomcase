<%--
  Created by IntelliJ IDEA.
  User: 筱
  Date: 2019-04-23
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="<%=request.getContextPath() %>/">
    <title>新增/编辑会员</title>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }

        /* 大盒子 */
        .member {
            border: solid 1px #ccc;
            width: 900px;
            margin: 20px auto;
        }

        /* 提示 */
        .member .tips {
            text-align: center;
            color: orange;
            font-size: 12px;
        }

        .member .row {
            min-height: 40px;
            line-height: 40px;
        }

        .member .row:after {
            content: '.';
            display: block;
            visibility: hidden;
            height: 0px;
            clear: both;
        }

        .member .row .left {
            float: left;
            width: 150px;
            text-align: right;
            margin-right: 20px;
        }

        .member .row .right {
            float: left;
            width: 720px;
            text-align: left;
        }

        input[type='submit'] {
            border: none;
            background: orange;
            height: 28px;
            width: 80px;
            color: #fff;
            margin-left: 150px;
            cursor: pointer;
        }
    </style>
    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="js/area.js"></script>
    <script>
        /* 月份对应的日子 */
        var days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        var constellation = ["白羊座", "金牛座", "双子座",
            "巨蟹座", "狮子座", "处女座",
            "天秤座", "天蝎座", "射手座",
            "摩羯座", "水瓶座", "双鱼座"];
        var cityArr = [];
        $(function () {
            //出生年月日
            genrateYear();
            //当月份下拉列表发生改变的时候，通过年&月，得出日期
            $("#month,#year").change(function () {
                var y = $("#year").val();
                var m = $("#month").val();
                //通过年份判断是否闰年
                var d = days[m - 1];
                if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                    if (m == 2) {
                        d++;
                    }
                }
                genrateDay(d);
            });
            //星座
            genrateConstellation();
            //展示省
            displayArea(all_citys, $("#provice"));
            var c = $("#provice>option:eq(0)").val();
            findChild(all_citys, c);
            var cc = $("#city>option:eq(0)").val();
            findChild(cityArr, cc);

            //省发生改变的时候
            $("#provice").change(function () {
                var code = $(this).val();//22
                $("#city>option").remove();
                findChild(all_citys, code);

                //市显示完之后，获取第一个市，将其对应的区显示出来
                $("#district>option").remove();
                var cc = $("#city>option:eq(0)").val();
                findChild(cityArr, cc);
            });
            $("#city").change(function () {
                var code = $(this).val();//2224
                $("#district>option").remove();
                //吉林省的9个市的信息cityArr
                findChild(cityArr, code);
            });

            showBirth();

            //根据省市区选中（编辑状态）
            showAddress();
        });

        function showAddress() {
            var p = "${mem.provice}";
            var c = "${mem.city}";
            var d = "${mem.district}";
            if (p != "" && p.length == 2) {
                $("#provice").val(p);

                //根据省 显示所有市
                $("#city>option").remove();
                findChild(all_citys, p);
                $("#city").val(c);//选中市


                //根据当前的市，显示所有区
                $("#district>option").remove();
                findChild(cityArr, c);
                $("#district").val(d);//选中市
            }
        }

        function showBirth() {
            var birth = "${mem.birth}";
            if (birth != "" && birth.length == 10) {
                var aa = birth.split("-");
                var y = parseInt(aa[0]);
                var m = parseInt(aa[1]);
                var d = parseInt(aa[2]);
                //选中年(已知value，选中select)
                $("#year").val(y);
                //选中月
                $("#month").val(m);
                //根据月份生成对应的日期
                var s = days[m - 1];
                if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
                    if (m === 2) {
                        s++;
                    }
                }
                genrateDay(s);
                $("#day").val(d);
            }
        }


        function findChild(targetArr, pcode) {
            //全国的省市区信息all_citys

            targetArr.forEach(function ( v,index) {
                if (v.code === pcode) {
                    if (pcode.length === 2) {
                        //通过省找市
                        cityArr = v.children;//找到对应的市（数组）
                        displayArea(cityArr, $("#city"));
                    } else {
                        displayArea(v.children, $("#district"));
                    }
                    return false;
                }
            });

        }

        /*
            将参数arr遍历，或者code/name,追加到dom元素的option里面
        */
        function displayArea(arr, dom) {
            arr.forEach(function (v, i) {
                var op = $("<option value='" + v.code + "'>").text(v.name);
                $(dom).append(op);
            })
        }


        function genrateConstellation() {
            constellation.forEach(function (v, i) {
                $("#constellation").append($("<option value='" + v + "'>").text(v));
            });
        }

        function genrateYear() {
            //1970开始，到当前年
            var y = new Date().getYear() + 1900;
            for (var i = 1970; i <= y; i++) {
                $("#year").append($("<option value='" + i + "'>").text(i));
            }
            genrateMonth();
        }

        function genrateMonth() {
            for (var i = 1; i <= 12; i++) {
                $("#month").append($("<option value='" + i + "'>").text(i));
            }
            genrateDay(31);
        }

        function genrateDay(end) {
            $("#day>option").remove();
            for (var i = 1; i <= end; i++) {
                $("#day").append($("<option value='" + i + "'>").text(i));
            }
        }
    </script>
</head>
<body>
<!-- 大盒子 -->
<div class="member">
    <!-- 提示 -->
    <div class="tips">请填写真实的资料，以便更多的好友找到你哟</div>
    <form action="addvip" method="post" enctype="multipart/form-data">
        <!-- 一行 -->
        <div class="row">
            <!-- 左边提示 -->
            <div class="left">当前头像</div>
            <!-- 右边表单域 -->
            <div class="right">
                <c:if var="c" test="${not empty mem && not empty mem.head}">
                    <img src="${mem.head }" style="width:80px;height:80px">
                </c:if>
                <c:if test="${not c }">
                    <img src="imgs/1555942084522.jpeg">
                    <input type="file" name="uphead">
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="left">昵称</div>
            <div class="right">
                <input value="${mem.nickname }" type="text" name="nickname">
            </div>
        </div>
        <div class="row">
            <div class="left">真实姓名</div>
            <div class="right">
                <input value="${mem.realname }" type="text" name="realname">
            </div>
        </div>
        <div class="row">
            <div class="left">性别</div>
            <div class="right">
                <input value="男" ${mem.sex=='男'?"checked":"" } type="radio" name="sex">帅哥
                &nbsp;&nbsp;&nbsp;
                <input value="女" ${mem.sex=='女'?"checked":"" } type="radio" name="sex">美妞
            </div>
        </div>
        <div class="row">
            <div class="left">出生年月</div>
            <div class="right">
                <select id="year" name="year">
                </select>
                <select id="month" name="month">
                </select>
                <select id="day" name="day">
                    <option>2</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="left">星座</div>
            <div class="right">
                <select id="constellation" name="constellation">

                </select>
            </div>
        </div>
        <div class="row">
            <div class="left">居住地</div>
            <div class="right">
                <select id="provice" name="provice">

                </select>
                <select id="city" name="city">

                </select>
                <select id="district" name="district">

                </select>
            </div>
        </div>
        <hr>
        <input type="submit" value="保存">
    </form>
</div>
</body>
</html>
