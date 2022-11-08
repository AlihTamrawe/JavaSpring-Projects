<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>


<div class="card" style="text-align: center;"> <h3>Home Page</h3></div>	
<a href="/product">Create Product</a>
<a href="/category">Create Category</a>

<div class="Roller"></div>
<table class="table table-bordered table-striped">
  	<thead class="thead-dark">
    	<tr>
    	    <td>Products</td>
    	    <td>Categories</td>
    	</tr>
   	</thead>
   	<thead class="thead-dark " >
    	<tr>
    	    <td>
    	    	<ul>
    	    	<c:forEach var="product"  items="${products}">
						<li>
						<a href="/product/${product.id}"><c:out value="${product.name }"></c:out></a>
						</li>    
						</c:forEach>	    	
    	    	</ul>
    	    
    	    </td>
    	   <td>
    	    	<ul>
    	    	<c:forEach var="category"  items="${categories}">
						<li>
							<a href="/category/${category.id}"><c:out value="${category.name}"></c:out></a>
						</li>    
						</c:forEach>	    	
    	    	</ul>
    	    
    	    </td>
    	</tr>
   	</thead>
</table>

</body>
</html>