<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show the Ninjas</title>
 <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

<nav><h1><c:out value="${dojo.name}"></c:out></h1></nav>

<div class="main-cont">
	
<table class="table table-bordered table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
   
      
      
    </tr>
  </thead>
  <c:forEach var="ninja" items="${ninjas}">
  <tbody>
    <tr>
      <th scope="row"><c:out value="${ninja.firstName}"></c:out></th>
      <td><c:out value="${ninja.lastName}"></c:out> </td>
      <td><c:out value="${ninja.age}"></c:out></td>
      
 
      
    </tr>
    </c:forEach>
    </tbody>
    
    </table>
    
</div>

</body>
</html>