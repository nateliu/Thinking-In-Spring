<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/5 0005
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Spittr--Profile</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static-resources/style.css"/>">
    </head>
        <h1>Profile</h1>
        <c:out value="${spittler.userName}" /><br/>
        <c:out value="${spittler.firstName}" /> <c:out value="${spittler.lastName}" /><br/>
        <c:out value="${spittler.email}" />
    </body>
</html>