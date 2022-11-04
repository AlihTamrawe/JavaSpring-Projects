
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Expense of the  Travels </title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
		
		
		
		
<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
 <div>
 	<h1>Save Travels</h1>
 </div>
<table class="table table-bordered table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Expense</th>
      <th scope="col">Description</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      
    </tr>
  </thead>
  <c:forEach var="travel" items="${travels}">
  <tbody>
    <tr>
      <th scope="row"><c:out value="${travel.getId()}"></c:out></th>
      <td><a href="/books/${travel.getId()}/"><c:out value="${travel.getExpense()}"></c:out></a></td>
      <td><c:out value="${travel.getDescription()}"></c:out> </td>
      <td><c:out value="${travel.getVendor()}"></c:out></td>
      <td><c:out value="${travel.getAmount()}"></c:out>$</td>
      
    </tr>
    </tbody>
    </c:forEach>
    </table>
    
    
   
	</main>
	
	 <div>
 	<h1>Add an  Expense</h1>
 </div>
 
 <form:form action="/Travel" method="post" modelAttribute="expensess">
    <p>
        <form:label path="expense">Title</form:label>
        <form:errors path="expense" class="text-danger"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class="text-danger"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor" class="text-danger"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount" class="text-danger"/>     
        <form:input type="number" path="amount"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
 
</body>
</html>