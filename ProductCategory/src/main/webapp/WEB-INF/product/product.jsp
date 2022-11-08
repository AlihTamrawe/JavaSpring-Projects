<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>


<div class="card" style="text-align: center;"> <h3>Product Page</h3></div>	
<a href="/">Home</a>

<div class="Roller"></div>
<form:form action="/product/new" method="post" modelAttribute="product">
<table class="table table-bordered table-striped">
  	<thead class="thead-dark">
    	<tr>
    	    <td>
    	    <form:label path="name"> Name</form:label>
    	    <form:errors path="name"></form:errors>
    	    </td>
    	    <td><form:input path="name"/></td>
    	    
    	</tr>
   	</thead>
   		<thead class="thead-dark">
    	<tr>
    	    <td>
    	    <form:label path="description">description</form:label>
    	    <form:errors path="description">
    	    </form:errors>
    	    
    	    </td>
    	    <td><form:input path="description"/></td>
    	    
    	</tr>
   	</thead>
   	<thead>
   		<thead class="thead-dark">
    	<tr>
    	    <td>
        <form:label path="price">price</form:label>
    	    <form:errors path="price"></form:errors>
    	    </td>
    	    <td><form:input type="number" path="price"/></td>
    	    
    	</tr>
   	</thead>
   	<thead class="thead-dark">
    	<tr>
    	  <td>
    	  <input type="submit" value="submit">
    	  </td>
    	</tr>
   	</thead>
</table>
</form:form>
</body>
</html>