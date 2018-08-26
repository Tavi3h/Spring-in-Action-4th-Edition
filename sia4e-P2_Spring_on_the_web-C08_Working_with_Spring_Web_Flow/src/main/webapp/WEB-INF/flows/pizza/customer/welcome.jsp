<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to Spizza</title>
</head>
<body>
    <h2>Welcome to Spizza!</h2>
    <form:form>
        <!-- 激活流程执行的key -->
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <input type="text" name="phoneNumber" /> 
        <!-- 触发phoneEntered事件 -->
        <input type="submit" name="_eventId_phoneEntered" value="Lookup Customer" />
    </form:form>
</body>
</html>