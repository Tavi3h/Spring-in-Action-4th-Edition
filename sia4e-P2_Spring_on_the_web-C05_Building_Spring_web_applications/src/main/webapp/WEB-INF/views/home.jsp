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
<title>Spittr</title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/style.css"/>">
</head>
<body>
    <h1>Welcome to Spittr!</h1>
    <a href="<c:url value="spittles" />">Spittles</a> |
    <a href="<c:url value="spitter/register" />">Register</a>
</body>
</html>