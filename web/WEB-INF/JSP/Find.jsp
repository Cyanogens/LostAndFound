<%--
  Created by IntelliJ IDEA.
  User: Cyanogen
  Date: 2021/7/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>失物招领</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/FindOrLose.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Menu.css">
</head>
<body>
<!--导航栏-->
<div id="menu">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toPerson" target="_self">
                <div class="font_style">个人中心</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toFind" target="_self">
                <div class="font_style">招领信息</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toAdd" target="_self">
                <div class="font_style">发布信息</div>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/LostAndFound/toLose" target="_self">
                <div class="font_style">挂失信息</div>
            </a>
        </li>
    </ul>
</div>

<!--搜索框-->
<form class="top find">
    <select class="selection ">
        <option selected disabled>物品类别</option>
        <option>数码</option>
        <option>耳机</option>
        <option>雨伞</option>
        <option>衣物</option>
        <option>背包</option>
        <option>其他</option>
        </select>
            <span>
                <input class="search" type="text" placeholder="寻物启事">
            </span>
            <input class="bt" type="image" src="../imgarch.png" onClick="document.formName.submit()">
</form>
<!--主体-->
<div id="Body">
    <div class="masonry">
        <c:forEach var="goods" items="${requestScope.get('list')}">
<%--            <c:if test="${goods != null and goods != '' }">--%>
                <div class="item">
                    <a href="">
                        ${goods.getPic()}
                    </a>
                    <div class="resume">
                        ${goods.getDescs()}
                    </div>
                </div>
<%--            </c:if>--%>
        </c:forEach>
    </div>
</div>
<!--返回顶部按钮-->
<div class="back_top">
    <a onclick="pageScroll()">
        <img class="back_top_button" src="${pageContext.request.contextPath}/image/backToTop.png">
    </a>
</div>
<!--背景-->
<script>
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
<script>
    /*返回顶部按钮*/
    function pageScroll() {
        window.scrollBy(0, -100);
        scrolldelay = setTimeout('pageScroll()', 100);
        const sTop = document.documentElement.scrollTop + document.body.scrollTop;
        if (sTop === 0) clearTimeout(scrolldelay);
    }

    /*瀑布*/
    function aa() {
        const oMain = document.getElementById('main');
        const ITEM_WIDTH = 200;
        const ITEM_SPACE = 10;
        const itemArray = [];
        let itemHeight = [];

        // 求随机数
        function rand(min, max) {
            return parseInt(Math.random() * (max - min + 1) + min);
        }


        function createItem(min, max) {
            for (let i = min; i < max; i++) {
                const div = document.createElement('div');
                div.style.borderRadius = '30px';
                div.style.border = '1px solid green';
                div.style.height = '300px';
                div.style.width = ITEM_WIDTH + 'px';
                div.style.backgroundColor = 'rgba(255,255,255,0)';
                oMain.appendChild(div);
                itemArray[i] = div;
            }
            layout();
        }

        createItem(0, 30);

        //div的布局
        function layout() {
            const t = 0;
            let l = 0;
            let frist = true;
            let mainWidth = 0;
            const winWidth = document.documentElement.clientWidth || document.body.clientWidth;

            for (let i = 0; i < itemArray.length; i++) {
                if ((l + ITEM_WIDTH) >= winWidth) {
                    frist = false;
                    mainWidth = l;
                    l = 0;
                }
                if (frist) {
                    itemArray[i].style.top = t + 'px';
                    itemArray[i].style.left = l + 'px';
                    itemHeight[i] = itemArray[i].offsetHeight;
                } else {
                    const min = getMin(itemHeight);
                    for (let j = 0; j < itemHeight.length; j++) {
                        if (itemHeight[j] === min) {
                            itemArray[i].style.top = min + ITEM_SPACE + 'px';
                            itemArray[i].style.left = j * (ITEM_WIDTH + ITEM_SPACE) + 'px';
                            itemHeight[j] += (itemArray[i].offsetHeight + ITEM_SPACE);
                            break;
                        }
                    }
                }
                l += ITEM_WIDTH + ITEM_SPACE;
            }
            // oMain居中
            var w = mainWidth - ITEM_SPACE;
            oMain.style.width = w + 'px';
            oMain.style.left = (winWidth - w) / 2 + 'px';

        }


        //求最小值
        function getMin(aArray) {
            let min = aArray[0];
            for (let i = 0; i < aArray.length; i++) {
                if (min > aArray[i]) {
                    min = aArray[i];
                }
            }
            return min;
        }

        window.onresize = function () {
            itemHeight = [];
            layout();
        }


        // 滚动滚动条达到最长的一个hight时，加载出更多
        window.onscroll = function () {
            var scrollHeight = document.body.scrollTop || document.documentElement.scrollTop;
            var winHeight = document.body.clientHeight || document.documentElement.clientHeight;
            var max = Math.max.apply(null, itemHeight);
            var num = 0;
            if ((scrollHeight + winHeight) >= max - 30) {
                num = itemArray.length;
                createItem(num, num + 10);
            }
        }

    }

    aa();
</script>
</html>
