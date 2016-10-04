<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/2 0002
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
	<head>
	    <title>Spittr--Home</title>
	    <link rel="stylesheet" type="text/css" href="<c:url value="/static-resources/style.css"/>">
	</head>
	<body>
		<h1>
		    Hello!Welcome to Spittr!
		</h1>

		<P> The time on the server is ${serverTime}. </P>
		<a href="<c:url value="/spittles"/>">Spittles</a>|
		<a href="<c:url value="/spittles/register"/>">Register</a>
	</body>
</html>
