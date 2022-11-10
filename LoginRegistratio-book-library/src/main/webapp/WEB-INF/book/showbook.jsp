<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showing Book</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body>


<div class="nav row">
   <div class="col"> <h1 class="nav-title col">,<c:out value="${book.title}"></c:out>   <c:out value="${user.userName}"></c:out>  </h1></div>
   <div class="col"> <a class="row" href="/logout">logout</a><a class="row" href="/books/">Return to Dashboard</a></div>
      <div class="col"><span style="color:red"> <c:out value="${book.user.userName }"></c:out></span>read<c:out value="${book.title }"></c:out>by <span style="color:green;"><c:out value="${book.author }"></c:out></span></div>
   
</div>

<div class="cont">

	<div class="lin row"></div>
	<div class="row-2">
	<p> <c:out value="${book.thoughts }"></c:out></p>
	</div>
	<div class="lin"></div>
    <c:if test="${flag==1}">
	<a href="/books/edit/${book.id}">edit</a>
	<a href="/delete/${book.id}">delete</a>
	</c:if>
</div>





</body>
</html>