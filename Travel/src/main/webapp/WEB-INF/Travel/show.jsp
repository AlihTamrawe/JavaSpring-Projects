<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Expense </title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
		<div class="card">
			<h1>Expense Details:  <c:out value="${travel.getExpense()}"></c:out> </h1>
				<p>Description : <c:out value="${travel.getDescription()}"></c:out> </p>
				<p>Vendor : <c:out value="${travel.getVendor()}"></c:out> </p>
				<p> Amount :<c:out value="${travel.getAmount()}"></c:out> </p>
				
			
			</div>

					<form class="form" action="/Expense/New" >
			   			 	<button class="btn btn-primary ">Back</button>
			    	</form>
			    	
	</main>
</body>
</html>