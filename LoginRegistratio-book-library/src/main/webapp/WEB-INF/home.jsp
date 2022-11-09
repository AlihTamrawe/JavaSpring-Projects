<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<div class="nav row">
   <div class="col"> <h1 class="nav-title col">Welcome,  <c:out value="${user.userName}"></c:out>  </h1></div>
   <div class="col"> <a class="row" href="/logout">logout</a><a class="row" href="/books/new">Add Book for me</a></div>
</div>

<div class="cont">
	<table class="table table-bordered table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">title</th>
      <th scope="col">Author</th>
      <th scope="col">Posted By</th>
   
      
      
    </tr>
  </thead>
  <c:forEach var="book" items="${Books}">
  <tbody>
    <tr>
          <th scope="row"><c:out value="${book.id}"></c:out></th>
      <th ><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></th>
	      <td><c:out value="${book.author}"></c:out> </td>
	      <td><c:out value="${book.user.userName}"></c:out></td>
    </tr>
    </c:forEach>
    </tbody>
    
    </table>
</div>
</body>
</html>