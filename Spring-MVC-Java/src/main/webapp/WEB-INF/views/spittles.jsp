<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/4 0004
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittr--List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static-resources/style.css"/>">
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <a href="<c:url value="/spittles/${spittle.id}"/>">
            <li id="spittle_<c:out value="spittle.id"/> ">
                <div class="spittleMessage">
                    <c:out value="${spittle.message}"></c:out>
                </div>
                <div>
                    <span class="spittleTime" >
                        <c:out value="${spittle.time}"></c:out>
                    </span>
                    <span class="spittleLocation">
                        (<c:out value="${spittle.latitude}"></c:out>,
                        <c:out value="${spittle.longitude}"></c:out>)
                    </span>
                </div>
            </li>
        </a>
    </c:forEach>
</body>
</html>
