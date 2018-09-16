<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/style.css"/>">
</head>
<body>
	<h1>Register</h1>
	<sf:form action="spitter/register" method="POST" commandName="spitter">
		<sf:errors path="*" element="div" cssClass="errors" />
		<sf:label path="firstName" cssErrorClass="error">First Name</sf:label>: 
        <sf:input path="firstName" cssErrorClass="error" />
		<br />
		<sf:label path="lastName" cssErrorClass="error">Last Name</sf:label>: 
        <sf:input path="lastName" cssErrorClass="error" />
		<br />
		<sf:label path="username" cssErrorClass="error">Username</sf:label>: 
        <sf:input path="username" cssErrorClass="error" />
		<br />
		<sf:label path="password" cssErrorClass="error">Password</sf:label>: 
        <sf:password path="password" cssErrorClass="error" />
		<br />
		<input type="submit" value="Register" />
	</sf:form>
</body>
</html>