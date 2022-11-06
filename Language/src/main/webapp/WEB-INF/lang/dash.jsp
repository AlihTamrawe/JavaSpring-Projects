<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBord</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>

 <div class="card">
 	<h1>The Dashboard</h1>
     </div>

		<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
 
 
<table class="table table-bordered table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">Version</th>
      <th scope="col">Editing Field</th>
      
      
    </tr>
  </thead>
  
  <c:forEach var="language" items="${languages}">
  <tbody>
    <tr>
      <th scope="row"><c:out value="${language.id}"></c:out></th>
      <td><a href="/Languages/${language.id}"><c:out value="${language.name}"></c:out></a></td>
      <td><c:out value="${language.creator}"></c:out></td>
      <td><c:out value="${language.version}"></c:out> </td>
      <td><a href="/Languages/edit/${language.id}">Edit</a><span> </span><a href="/delete/${language.id}">Delete</a></td>      
    </tr>
    </c:forEach>
    </tbody>
    
    </table>
    
    
   
	
	 <div>
 	<h1>Add an  Expense</h1>
     </div>
 
 <form:form action="/Languages/create" method="post" modelAttribute="lang">
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