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
<div class="card" style="text-align: center;"> <h3><c:out value="${category.name}"/> </h3></div>	


<div class="card" style="text-align: center;"> <h5>Category Page Details</h5></div>	
<a href="/">Home</a>

<div class="Roller"></div>
		
		<ul>
			<c:forEach var="producte" items="${category.products}">
				<li><c:out value="${producte.name}"></c:out><c:out value="${product.price}"></c:out></li>
			</c:forEach>
		</ul>
<div class="Roller"></div>
<form action="/category/prod"  method="post">
<input type="hidden" name="cat" value="${category.id}">

<select name="pro">
<c:forEach var="product2"  items="${products}">
<option value="${ product2.id}"><c:out value="${product2.name }"></c:out></option>
</c:forEach>
</select>
<input type="submit" value="add">
</form>




</body>
</html>