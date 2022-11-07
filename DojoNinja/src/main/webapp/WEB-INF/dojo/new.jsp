<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new Dojo </title>

 <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<nav> Create new Dojo</nav>
<div class="main-cont">


 <form:form action="/dojo/new" method="post" modelAttribute="dojo">
  
    
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class="text-danger"/>     
        <form:input  path="name"/>
    </p>    
    <input class="btn btn-primary " type="submit" value="Submit"/>
</form:form>



</div>



</body>
</html>