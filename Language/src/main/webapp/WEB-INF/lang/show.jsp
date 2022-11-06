<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Language </title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
		<div style="width: 100%; display: flex; margin: auto;padding: 20px; align-content: space-between;justify-content: space-around;"> <a href="/Languages" >Dashboard</a>     <span>   </span><a href="/delete/${language.id}">Delete</a>    </div>

	<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
		<div class="card">
			<h1>Language Name:  <c:out value="${language.name}"></c:out> </h1>
				<h3>Creator : <c:out value="${language.creator}"></c:out> </h3>
				<h3>Version : <c:out value="${language.version}"></c:out> </h3>
				
			
			</div>

				
			    	
	</main>
</body>
</html>