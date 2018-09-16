<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Spizza</title>
</head>
<body>
	<h2>Delivery Unavailable</h2>
	<p>The address is outside of our delivery area. You may still place the order, but you will need to pick it up yourself.</p>
	<a href="${flowExectuionUrl}&_eventId=accept">Contiune, I'll pick up the order</a> |
	<a href="${flowExecutionUrl}&_eventId=cancel">Never mind</a>
</body>
</html>