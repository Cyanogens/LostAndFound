<%--
  Created by IntelliJ IDEA.
  User: Cyanogen
  Date: 2021/7/25
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head  lang="en">
    <title>信息详情</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/detailMessage.css">
</head>
<body>
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
                    &nbsp;详情介绍：<td>${goods.descs}</td>
                </tr>
        </div>
    </div>
</div>
</body>
</html>
