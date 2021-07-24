<%--
  Created by IntelliJ IDEA.
  User: Cyanogen
  Date: 2021/7/24
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎光临</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Person.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Menu.css">
</head>
<body>
<!--导航栏-->
<div id="menu">
    <ul>
        <li>
            <a href="http://localhost:8080/web/LostAndFound/toPerson" target="_self">
                <div class="font_style">个人中心</div>
            </a>
        </li>
        <li>
            <a href="http://localhost:8080/web/LostAndFound/toFind" target="_self">
                <div class="font_style">招领信息</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toAdd" target="_self">
                <div class="font_style">发布信息</div>
            </a>
        </li>
        <li>
            <a href="http://localhost:8080/web/LostAndFound/toLose" target="_self">
                <div class="font_style">挂失信息</div>
            </a>
        </li>
    </ul>
</div>
<div id="big" style="text-align:center">
    <div id="backImage"></div>
    <div id="top">
        <div class="top_title">
            <span>欢迎来到招失网</span>
        </div>
        <marquee direction=left scrolldelay=600 scrollamount=50>
            <font size="4" color=#FF2D2D>最 美 不 过 拾 金 不 昧 的 你</font>
        </marquee>

    </div>
    <div id="center">
        <div id="left">
            <div class = "leftTitle">我的信息</div>
            <div class="content">
                <div class="nav">
                    <div class="nav-li">
                        <div class="title">学号</div>
                        <ul class="left_ul">
                            <li class="left_li">
                                2025121025
                            </li>
                        </ul>
                    </div>
                </div>
                </br>
                </br>
                <div class="nav">
                    <div class="nav-li">
                        <div class="title">姓名</div>
                        <ul class="left_ul">
                            <li class="left_li">
                                ×××
                            </li>
                        </ul>
                    </div>
                </div>
                </br>
                </br>
                <div class="nav">
                    <div class="nav-li">
                        <div class="title">联系电话</div>
                        <ul class="left_ul">
                            <li class="left_li">
                                18588874029
                            </li>
                        </ul>
                    </div>
                </div>
                </br>
                </br>
                <div class="nav">
                    <div class="nav-li">
                        <div class="title">联系地址</div>
                        <ul class="left_ul">
                            <li class="left_li">
                                ..........
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            </br>
            </br>
            </br>
            <div class = "changeMessage">
                <a href="" style="text-decoration: none">编辑资料</a>
            </div>

        </div>
        <div id="right">
            <div id="modified">
                <div class = "rightTitle">我发布过的内容</div>
                <ul id="right_ul">
                    <li class="right_li">
                        <tbody>
                        <c:forEach var="goods" items="${requestScope.get('list')}">
                            <tr>
                                <td>${goods.getGoodsID()}</td>
                                <td>${goods.getGoodsName()}</td>
                                <td>${goods.getGoodsCounts()}</td>
                                <td>${goods.getDetail()}</td>
                                <td>
                                    <c:if test="${goods.pic !=null }">
                                        <img id="pic" alt="" src="/pic/${goods.getPic() }">
                                    </c:if>
                                </td>
                                <c:if test="${goods.getBookID() != null}">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/book/updateBook?id=${goods.getBookID()}">修改</a> |
                                        <a href="${pageContext.request.contextPath}/book/deleteBook?id=${goods.getBookID()}">删除</a>
                                    </td>
                                </c:if>
                                <c:if test="${goods.getBookID() == null}">
                                    <p>未发布过内容</p>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </li>
                </ul>
                <div class = "out">
                    <button onclick="testClick(this);">退出登录</button>
                </div>
            </div>

        </div>
    </div>

</div>
<!--背景-->
<script>

    function testClick(t){
        alert("是否确定退出？")
    }
    /*背景*/
    !function () {

        function n(n, e, t) {

            return n.getAttribute(e) || t

        }

        function e(n) {

            return document.getElementsByTagName(n)

        }

        function t() {

            var t = e("script"), o = t.length, i = t[o - 1];

            return {

                l: o, z: n(i, "zIndex", -1), o: n(i, "opacity", .5), c: n(i, "color", "0,0,0"), n: n(i, "count", 99)

            }

        }

        function o() {

            a = m.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,

                c = m.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight

        }

        function i() {

            r.clearRect(0, 0, a, c);

            var n, e, t, o, m, l;

            s.forEach(function (i, x) {

                for (i.x += i.xa, i.y += i.ya, i.xa *= i.x > a || i.x < 0 ? -1 : 1, i.ya *= i.y > c || i.y < 0 ? -1 : 1, r.fillRect(i.x - .5, i.y - .5, 1, 1), e = x + 1; e < u.length; e++) n = u[e],

                null !== n.x && null !== n.y && (o = i.x - n.x, m = i.y - n.y,

                    l = o * o + m * m, l < n.max && (n === y && l >= n.max / 2 && (i.x -= .03 * o, i.y -= .03 * m),

                    t = (n.max - l) / n.max, r.beginPath(), r.lineWidth = 0.5, r.strokeStyle = "rgb(32,184,198)", r.moveTo(i.x, i.y), r.lineTo(n.x, n.y), r.stroke()))

            }),

                x(i)

        }

        var a, c, u, m = document.createElement("canvas"),

            d = t(), l = "c_n" + d.l, r = m.getContext("2d"),

            x = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||

                function (n) {

                    window.setTimeout(n, 1e3 / 45)

                },

            w = Math.random, y = {x: null, y: null, max: 2e4};
        m.id = l, m.style.cssText = "position:fixed;top:0;left:0;z-index:" + d.z + ";opacity:" + d.o, e("body")[0].appendChild(m), o(), window.onresize = o,

            window.onmousemove = function (n) {

                n = n || window.event, y.x = n.clientX, y.y = n.clientY

            },

            window.onmouseout = function () {

                y.x = null, y.y = null

            };

        for (var s = [], f = 0; d.n > f; f++) {

            var h = w() * a, g = w() * c, v = 2 * w() - 1, p = 2 * w() - 1;
            s.push({x: h, y: g, xa: v, ya: p, max: 6e3})

        }

        u = s.concat([y]),

            setTimeout(function () {
                i()
            }, 100)

    }();

</script>
</body>
</html>
