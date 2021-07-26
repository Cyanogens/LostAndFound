<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head  lang="en">
    <title>信息详情</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/detailMessage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Menu.css">
</head>
<body>
<div id="menu">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toPerson" target="_self">
                <div class="font_style">个人中心</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toLose" target="_self">
                <div class="font_style">招领信息</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toAdd" target="_self">
                <div class="font_style">发布信息</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toFind" target="_self">
                <div class="font_style">挂失信息</div>
            </a>
        </li>
    </ul>
</div>
<div id="bigBox">
    <h2 style="text-align: center">物品详情</h2>
    <div id="detail">
        <div id="centerPicture">
            <img src="/pic/${goods.pic}" alt="">
        </div>
        <div id="detailMessage">
                <tr id="detailTable">
                    &nbsp;发布类型：<td>${goods.typeTable}</td><br><br>
                    &nbsp;物品类型：<td>${goods.label}</td><br><br>
                    &nbsp;地点：<td>${goods.place}</td><br><br>
                    &nbsp;时间：<td>${goods.times}</td><br><br>
                    &nbsp;联系人：<td>${goods.user.user_Name}</td><br><br>
                    &nbsp;联系电话：<td>${goods.user.telephone}</td><br><br>
                    &nbsp;详情介绍：<td>${goods.descs}</td>
                </tr>
        </div>
    </div>
</div>
<!--背景-->
<script>
    /*背景*/
    !function () {

        let a;
        let c;
        let u;
        let m = document.createElement("canvas");
        let r = m.getContext("2d");
        let x = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||

            function (n) {

                window.setTimeout(n, 1e3 / 45)

            };
        let y = {x: null, y: null, max: 2e4};

        function n(n, e, t) {

            return n.getAttribute(e) || t

        }

        function e(n) {

            return document.getElementsByTagName(n)

        }

        function t() {

            const t = e("script"), o = t.length, i = t[o - 1];

            return {

                l: o, z: n(i, "zIndex", -1), o: n(i, "opacity", .5), c: n(i, "color", "0,0,0"), n: n(i, "count", 166)

            }

        }

        function o() {

            a = m.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,

                c = m.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight

        }

        function i() {

            r.clearRect(0, 0, a, c);

            let n, e, t, o, m, l;

            s.forEach(function (i, x) {

                for (i.x += i.xa, i.y += i.ya, i.xa *= i.x > a || i.x < 0 ? -1 : 1, i.ya *= i.y > c || i.y < 0 ? -1 : 1, r.fillRect(i.x - .5, i.y - .5, 1, 1), e = x + 1; e < u.length; e++) n = u[e],

                null !== n.x && null !== n.y && (o = i.x - n.x, m = i.y - n.y,

                    l = o * o + m * m, l < n.max && (n === y && l >= n.max / 2 && (i.x -= .03 * o, i.y -= .03 * m),

                    t = (n.max - l) / n.max, r.beginPath(), r.lineWidth = 0.65, r.strokeStyle = "rgb(43,238,255)", r.moveTo(i.x, i.y), r.lineTo(n.x, n.y), r.stroke()))

            }),

                x(i)

        }

        let d = t(), l = "c_n" + d.l,

            w = Math.random;
        m.id = l, m.style.cssText = "position:fixed;top:0;left:0;z-index:" + d.z + ";opacity:" + d.o, e("body")[0].appendChild(m), o(), window.onresize = o,

            window.onmousemove = function (n) {

                n = n || window.event, y.x = n.clientX, y.y = n.clientY

            },

            window.onmouseout = function () {

                y.x = null, y.y = null

            };

        for (let s = [], f = 0; d.n > f; f++) {

            const h = w() * a, g = w() * c, v = 2 * w() - 1, p = 2 * w() - 1;
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
