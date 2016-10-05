<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/5 0004
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Spittr--Detail</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static-resources/style.css"/>">
    </head>
    <body>
        <div class="spittleView">
            <div class="spittleMessage"><c:out value="${spittle.message}"></c:out></div>
            <div class="spittleTime"><c:out value="${spittle.time}"></c:out></div>
        </div>
    </body>
</html>
