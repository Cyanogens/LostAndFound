<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>欢迎光临</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Person.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/ChangeMyMessage.css">
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
<div id="big" style="text-align:center">
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
                                ${myself.user_Xh}
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
                                ${myself.user_Name}
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
                                ${myself.telephone}
                            </li>
                        </ul>
                    </div>
                </div>
                <br>
                <br>
                <div class="nav">
                    <div class="nav-li">
                        <div class="title">联系地址</div>
                        <ul class="left_ul">
                            <li class="left_li">
                                ${myself.address}
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class = "changeMessage">
                <a href="${pageContext.request.contextPath}/LostAndFound/toUpdateMyself" style="text-decoration: none;">编辑资料</a>
            </div>
        </div>
        <div id="right">
            <div class="top_title">
                <span>编辑个人资料</span>
            </div>
            <form action="${pageContext.request.contextPath}/updateUsers" method="post" class="change">
                <input type="text" name="user_Xh" maxlength="10" value="${myself.user_Xh}" placeholder="学号" required>
                <br>
                <input type="text" name="username" value="${myself.user_Name}" placeholder="姓名" required>
                <br>
                <input type="password" name="password" value="${myself.password}" placeholder="密码" required>
                <br>
                <input type="text" name="telephone" maxlength="11" value="${myself.telephone}" placeholder="联系电话" required>
                <br>
                <input type="text" name="address" value="${myself.address}" placeholder="地址" required>
                <br>
                <input type="submit" value="修改完成">
            </form>
        </div>
    </div>

</div>
</div>
<!--背景-->
<script>
    /*背景*/
    !function(){

        function n(n,e,t){

            return n.getAttribute(e)||t

        }

        function e(n){

            return document.getElementsByTagName(n)

        }

        function t(){

            var t=e("script"),o=t.length,i=t[o-1];

            return{

                l:o,z:n(i,"zIndex",-1),o:n(i,"opacity",.5),c:n(i,"color","0,0,0"),n:n(i,"count",166)

            }

        }

        function o(){

            a=m.width=window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth,

                c=m.height=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight

        }

        function i(){

            r.clearRect(0,0,a,c);

            var n,e,t,o,m,l;

            s.forEach(function(i,x){

                for(i.x+=i.xa,i.y+=i.ya,i.xa*=i.x>a||i.x<0?-1:1,i.ya*=i.y>c||i.y<0?-1:1,r.fillRect(i.x-.5,i.y-.5,1,1),e=x+1;e<u.length;e++)n=u[e],

                null!==n.x&&null!==n.y&&(o=i.x-n.x,m=i.y-n.y,

                    l=o*o+m*m,l<n.max&&(n===y&&l>=n.max/2&&(i.x-=.03*o,i.y-=.03*m),

                    t=(n.max-l)/n.max,r.beginPath(),r.lineWidth=0.65,r.strokeStyle="rgb(43,238,255)",r.moveTo(i.x,i.y),r.lineTo(n.x,n.y),r.stroke()))

            }),

                x(i)

        }

        var a,c,u,m=document.createElement("canvas"),

            d=t(),l="c_n"+d.l,r=m.getContext("2d"),

            x=window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.oRequestAnimationFrame||window.msRequestAnimationFrame||

                function(n){

                    window.setTimeout(n,1e3/45)

                },

            w=Math.random,y={x:null,y:null,max:2e4};m.id=l,m.style.cssText="position:fixed;top:0;left:0;z-index:"+d.z+";opacity:"+d.o,e("body")[0].appendChild(m),o(),window.onresize=o,

            window.onmousemove=function(n){

                n=n||window.event,y.x=n.clientX,y.y=n.clientY

            },

            window.onmouseout=function(){

                y.x=null,y.y=null

            };

        for(var s=[],f=0;d.n>f;f++){

            var h=w()*a,g=w()*c,v=2*w()-1,p=2*w()-1;s.push({x:h,y:g,xa:v,ya:p,max:6e3})

        }

        u=s.concat([y]),

            setTimeout(function(){i()},100)

    }();

</script>
</body>
</html>
