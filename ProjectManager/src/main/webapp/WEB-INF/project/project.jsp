<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make project</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<div class="cont col-3">
	<h1>Make project</h1>
<form:form action="/create/project" method="post" modelAttribute="project" class="form">
    <p>
        <form:label path="title">title</form:label>
        <form:errors path="title"/>
        <form:input type="text" path="title"/>
    </p>
    <p>
       <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:input type="text" path="description"/>
    </p>
    <p>
        <form:label path="date">Due Date</form:label>
        <form:errors path="date"/>
		<fmt:formatDate value="${blah.bla}" pattern="dd/MM/yyyy" var="myDate" />
		<form:input type="date" path="date" value="${myDate}"/>
    </p>
   
    <input type="submit" value="Create "/>
</form:form>
	
	</div>

</body>
</html>