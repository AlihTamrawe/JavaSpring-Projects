<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the Language</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>


		<div class="form group">
		<h1>Edit Language</h1>
		<div style="width: 100%; display: flex; margin: auto;padding: 20px; align-content: space-between;justify-content: space-around;"> <a href="/Languages" >Dashboard</a>     <span>   </span><a href="/delete/${language.id}">Delete</a>    </div>
		 
		 </div>
		<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
<form:form action="/Languages/edit/${id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put" >
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label  path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
  
    <input class="btn btn-primary " type="submit" value="Submit"/>
</form:form>
</main>
	
</body>
</html>