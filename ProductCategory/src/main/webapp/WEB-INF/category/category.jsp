<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>


<div class="card" style="text-align: center;"> <h3>Category Page</h3></div>	
<a href="/">Home</a>

<div class="Roller"></div>
<table class="table table-bordered table-striped">
<form:form action="/category/new" method="post" modelAttribute="category">

  	<thead class="thead-dark">
    	<tr>
    	    <td><form:label path="name">name</form:label>
    	      	<form:errors path="name"></form:errors>
    	    
    	    </td>
    	    <td><form:input path="name"/></td>
    	</tr>
   	</thead>
   	<thead class="thead-dark">
    	<tr>
    	  <td>
    	  <input type="submit" value="submit">
    	  </td>
    	</tr>
   	</thead>
</form:form>
</table>

</body>
</html>