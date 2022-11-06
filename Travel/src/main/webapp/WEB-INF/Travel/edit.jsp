<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the Expense</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
		<h1>Edit Book</h1>
		<main>
<form:form action="/Expense/${id}/edit" method="post" modelAttribute="travel">
    <input type="hidden" name="_method" value="put" >
    <p>
        <form:label path="expense">expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label  path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount" />
    </p>   
    <input class="btn btn-primary " type="submit" value="Submit"/>
</form:form>
</main>
	<form class="form" action="/Expense/New" >
			   			 	<button class="btn btn-primary ">Back</button>
			    	</form>
</body>
</html>