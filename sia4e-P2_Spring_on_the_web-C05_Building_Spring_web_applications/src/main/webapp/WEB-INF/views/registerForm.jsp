<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form action="spitter/register" method="POST">
		<label>
			First Name:
			<input type="text" name="firstName" />
		</label>
		<br>
		<label>
			Last Name:
			<input type="text" name="lastName" />
		</label>
		<br>
		<label>
			Username:
			<input type="text" name="username" />
		</label>
		<br>
		<label>
			Password:
			<input type="text" name="password" />
		</label>
		<br>
		<input type="submit" value="Register" />
	</form>
</body>
</html>