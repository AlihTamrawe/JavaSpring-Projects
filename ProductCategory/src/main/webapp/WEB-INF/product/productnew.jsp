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
<div class="card" style="text-align: center;"> <h3><c:out value="${product.name}"/> </h3></div>	


<div class="card" style="text-align: center;"> <h5>Product Page Details</h5></div>	
<a href="/">Home</a>

<div class="Roller"></div>
		
		<ul>
			<c:forEach var="categoryi" items="${product.categories}">
				<li><c:out value="${categoryi.name}"></c:out></li>
			</c:forEach>
		</ul>
<div class="Roller"></div>
<form action="/product/cat" method="post">
<input type="hidden" name="pro" value="${product.id}">

<select name="cat">
<c:forEach var="cat"  items="${categories}">
<option value="${ cat.id}"><c:out value="${cat.name}"/> </option>
</c:forEach>
</select>
<input type="submit" value="add">
</form>




</body>
</html>