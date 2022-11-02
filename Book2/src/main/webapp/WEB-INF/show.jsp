<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
	<h1> <c:out value="${title}"></c:out> </h1>
		<p> <c:out value="${desc}"></c:out> </p>
		<p> <c:out value="${lang}"></c:out> </p>
		<p> <c:out value="${pages}"></c:out> </p>
		
	
</div>

</body>
</html>