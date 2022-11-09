<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Book</title>
</head>
<body>

<div class="cont col-3">
	<h1>Add Book to your Self</h1>
<form:form action="/books/add" method="post" modelAttribute="book" class="form">
    <p>
        <form:label path="title">title</form:label>
        <form:errors path="title"/>
        <form:input type="text" path="title"/>
    </p>
    <p>
       <form:label path="author">author:</form:label>
        <form:errors path="author"/>
        <form:input type="text" path="author"/>
    </p>
    <p>
        <form:label path="thoughts">my Thoughts</form:label>
        <form:errors path="thoughts"/>
        <form:input  type="text"  path="thoughts"/>
    </p>
   
    <input type="submit" value="Create "/>
</form:form>
	
	</div>

</body>
</html>