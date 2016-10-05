<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/5 0005
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Spittr--Register</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static-resources/style.css"/>">
    </head>
    <body>
        <h1>Register</h1>
        <sf:form method="POST" commandName="spittler"  >
            <sf:errors path="*" element="div" cssClass="errors" />
            <sf:label path="firstName"
                      cssErrorClass="error">First Name</sf:label>:
            <sf:input path="firstName" cssErrorClass="error" /><br/>
            <sf:label path="lastName"
                      cssErrorClass="error">Last Name</sf:label>:
            <sf:input path="lastName" cssErrorClass="error" /><br/>
            <sf:label path="email"
                      cssErrorClass="error">Email</sf:label>:
            <sf:input path="email" cssErrorClass="error" /><br/>
            <sf:label path="userName"
                      cssErrorClass="error">Username</sf:label>:
            <sf:input path="userName" cssErrorClass="error" /><br/>
            <sf:label path="passWord"
                      cssErrorClass="error">Password</sf:label>:
            <sf:password path="passWord" cssErrorClass="error" /><br/>
            <input type="submit" value="Register" />
        </sf:form>

    </body>
</html>
