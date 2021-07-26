<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyanogen
  Date: 2021/7/24
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>添加</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Add.css">
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
<form action="${pageContext.request.contextPath}/LostAndFound/adding" method="post" enctype="multipart/form-data">
    <div>
        <select class="background input" name="type" style="text-align: center" required>
            <option>寻物启事</option>
            <option>失物招领</option>
        </select>
    </div>
    <div>
        <select class="background input" name="label" style="text-align: center" required>
            <option>其他</option>
            <option>数码</option>
            <option>耳机</option>
            <option>雨伞</option>
            <option>衣物</option>
            <option>背包</option>
        </select>
    </div>
    <div><input class="input background" name="times" type="date" placeholder="日期" required></div>
    <div><input class="input background" name="place" type="text" placeholder="地点" required></div>
<%--    <div><input class="input background" name="" type="text" placeholder="联系电话" required></div>--%>
    <div><textarea class="detail background" name="descs" placeholder="详情"></textarea></div>
    <div id="preview"></div>
    <div class="button">
        <input  class="file" name="file" type="file" onchange="preview(this)">
        <div class="file_btn">上传照片</div>
    </div>
    <div class="button">
        <input class="button file" type="submit">
        <div class="file_btn">发布信息</div>
    </div>
</form>
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

                l:o,z:n(i,"zIndex",-1),o:n(i,"opacity",.5),c:n(i,"color","0,0,0"),n:n(i,"count",99)

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

                    t=(n.max-l)/n.max,r.beginPath(),r.lineWidth=0.5,r.strokeStyle="rgb(32,184,198)",r.moveTo(i.x,i.y),r.lineTo(n.x,n.y),r.stroke()))

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
<script>
    /*上传图片并显示*/
    var _URL = window.URL || window.webkitURL;

    function preview(file) {
        var prevDiv = document.getElementById('preview');
        if (file.files && file.files[0]) {
            var reader = new FileReader();
            reader.onload = function (evt) {
                prevDiv.innerHTML = '<img id="imgnode" src="' + evt.target.result + '" />';
                console.log(evt.target.result)
            }
            reader.readAsDataURL(file.files[0]);
        } else {
            prevDiv.innerHTML = '<div class="img" id="imgnode"  style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
        }
    }
</script>
</html>
