<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <title>招失网</title>
    <link rel="stylesheet" type="text/css" href="Login.css">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        let img;
        window.onload =function(){
            img = document.getElementById("img");
            img.onclick = _change();
        }

        function _change(){
            /*
            1.得到img元素
            2.修改其src为/day09-1/VerifyCodeServlet
            */
            const date = new Date().getTime();
            img.src = "${pageContext.request.contextPath}/VerifyCodeServlet?a=" + date;
        }
    </script>
<%--    <script type="text/javascript">--%>
<%--        $(function (){--%>
<%--            if (window.history && window.history.pushState){--%>
<%--                $(window).on('popstate',function (){--%>
<%--                    window.history.pushState('forward', null, '#');--%>
<%--                    window.history.forward(1);--%>
<%--                });--%>
<%--            }--%>
<%--            window.history.pushState('forward', null,'#');--%>
<%--            window.history.forward(1);--%>
<%--        });--%>
<%--    </script>--%>
    <script type="text/javascript">

    </script>
</head>
<body>

<!-- 旋转开关 -->
<div class="switch"><h2>没有账号/已有帐号</h2></div>
<input type="checkbox" style="display: none;" id="change">
<label for="change" id="getChance">
    <div>快 去 注  册/登 录</div>
</label>

<div class="turn">
    <div class="over">
        <form method="post" action="${pageContext.request.contextPath}/login" class="login">
            <h1>用户登录</h1>
            <input type="text" name="user_Xh" maxlength="10" placeholder="学号" required>
            <input type="password" name="password" placeholder="密码" required>
            <input id="verifyCode" name="verifyCode" maxlength="4" placeholder="验证码" required>
            <a href="${pageContext.request.contextPath}/VerifyCodeServlet" onclick="_change()">
                <img src="VerifyCodeServlet" id="image" onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();">
            </a>
            <input type="submit" class="btn" value="登 录">
        </form>

        <form method="post" action="${pageContext.request.contextPath}/register" class="sign">
            <h1>用户注册</h1>
            <input type="text" name="user_Xh" maxlength="10" placeholder="学号" required>
            <input type="text" name="user_Name" placeholder="姓名" required>
            <input type="password" name="password" placeholder="密码" required>
            <input type="text" name="telephone" maxlength="11" placeholder="联系电话" required>
            <input type="submit" class="btn" value="完 成">
        </form>
    </div>
</div>
<canvas id="canv"></canvas>

<!--背景-->
<script>
    const c = document.getElementById('canv');
    const $ = c.getContext('2d');

    let w = c.width = window.innerWidth;
    let h = c.height = window.innerHeight;

    const draw = function (a, b, t) {
        $.lineWidth = 0.8;
        $.fillStyle = 'white';
        $.fillRect(0, 0, w, h);
        for (var i = -60; i < 60; i += 1) {
            $.strokeStyle = 'hsla(277, 95%, 15%, .15)';
            $.beginPath();
            $.moveTo(0, h / 2);
            for (var j = 0; j < w; j += 10) {
                $.lineTo(10 * Math.sin(i / 10) +
                    j + 0.008 * j * j,
                    Math.floor(h / 2 + j / 2 *
                        Math.sin(j / 50 - t / 50 - i / 118) +
                        (i * 0.9) * Math.sin(j / 25 - (i + t) / 65)));
            }
            $.stroke();
        }
    };
    let t = 0;

    window.addEventListener('resize', function() {
        c.width = w = window.innerWidth;
        c.height = h = window.innerHeight;
        $.fillStyle = 'hsla(277, 95%, 55%, 1)';
    }, false);

    const run = function () {
        window.requestAnimationFrame(run);
        t += 1;
        draw(33, 52 * Math.sin(t / 2400), t);
    };
    run();
</script>

</body>
<script>
    $(function(){
        document.onkeydown=keyDownSearch;
        function keyDownSearch(e) {
            // 兼容FF和IE和Opera
            const theEvent = e || window.event;
            const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
            if (code === 13) {
                $('#submit').click();//具体处理函数
                return false;
            }
            return true;
        }
    });
</script>

</html>
