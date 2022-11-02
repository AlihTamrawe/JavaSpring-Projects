<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your book </title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" `>
		<div class="card">
			<h1>Title:  <c:out value="${title}"></c:out> </h1>
				<p>Description : <c:out value="${desc}"></c:out> </p>
				<p>Language : <c:out value="${lang}"></c:out> </p>
				<p> Number OF Pages :<c:out value="${pages}"></c:out> </p>
				
			
			</div>

					<form class="form" action="/books/" method="get">
			   			 	<button class="btn btn-primary ">Back</button>
			    	</form>
			    	
	</main>
</body>
</html>