<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
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
<link rel="stylesheet" type="text/css" href="<s:url value="resources/style.css"/>">
</head>
<body>
    <!-- 插入头部 -->
	<div id="header">
		<t:insertAttribute name="header" />
	</div>

    <!-- 插入主体内容 -->
	<div id="content">
		<t:insertAttribute name="body" />
	</div>

    <!-- 插入底部 -->
	<div id="footer">
		<t:insertAttribute name="footer" />
	</div>
</body>
</html>