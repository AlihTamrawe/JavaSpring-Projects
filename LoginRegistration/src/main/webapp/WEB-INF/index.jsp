<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login & Register</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">

<link>
</head>
<body>

<div class="cont">
	<div class="reg">
	<h1>Register new User</h1>
<form:form action="/register" method="post" modelAttribute="newUser">
    <input type="hidden" name="_method" value="post">
    <p>
        <form:label path="userName">username</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
    <p>
       <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>
        <form:input type="password" path="password"/>
    </p>
    <p>
        <form:label path="confirm">confirm pw</form:label>
        <form:errors path="confirm"/>
        <form:input type="password" path="confirm"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>
	
	</div>
	<div class="log">
	<form:form action="/login" method="post" modelAttribute="newLogin">
    <input type="hidden" name="_method" value="post">
    <p>
       <form:label path="email">Email:</form:label>
        <form:errors path="email"/>
        <form:input type="email" path="email"/>
    </p>
    <p>
        <form:label path="password">password</form:label>
        <form:errors path="password"/>
        <form:input type="password" path="password"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>
	</div>

</div>

</body>
</html>