<%--
  Created by IntelliJ IDEA.
  User: Cyanogen
  Date: 2021/7/24
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>招失网</title>
    <link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body>

<!-- 旋转开关 -->
<div class="switch"><h2>没有账号/已有帐号</h2></div>
<input type="checkbox" style="display: none;" id="change">
<label for="change" id="getChance"><div>快 去 注  册/登 录</div></label>

<div class="turn">
    <div class="over">
        <form method="post" action="${pageContext.request.contextPath}/login" class="login">
            <h1>用户登录</h1>
            <input type="text" name="user_Xh" maxlength="10" placeholder="学号" required>
            <input type="password" name="password" placeholder="密码" required>
            <input id="verifyCode" name="verifyCode" placeholder="验证码" required>
            <img src="VerifyCodeServlet" id="verify" onclick="document.getElementById('verify').src='VerifyCodeServlet?'+Math.random();">
            <input type="submit" class="btn" value="登 录">
        </form>

        <form method="post" action="http://localhost:8080/LostAndFound_war_exploded/register" class="sign">
            <h1>用户注册</h1>
            <input type="text" name="user_Xh" maxlength="10" placeholder="学号" required>
            <input type="text" name="username" placeholder="姓名" required>
            <input type="password" name="password" placeholder="密码" required>
            <input type="text" name="telephone" maxlength="11" placeholder="联系电话" required>
            <input type="submit" class="btn" value="完 成">
        </form>
    </div>
</div>
<canvas id="canv"></canvas>
<!--背景-->
<script>
    var c = document.getElementById('canv');
    var $ = c.getContext('2d');

    var w = c.width = window.innerWidth;
    var h = c.height = window.innerHeight;

    var draw = function(a, b, t) {
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
            };
            $.stroke();
        }
    }
    var t = 0;

    window.addEventListener('resize', function() {
        c.width = w = window.innerWidth;
        c.height = h = window.innerHeight;
        $.fillStyle = 'hsla(277, 95%, 55%, 1)';
    }, false);

    var run = function() {
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
            var theEvent = e || window.event;
            var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
            if (code == 13) {
                $('#submit').click();//具体处理函数
                return false;
            }
            return true;
        }
    });
</script>
</html>
