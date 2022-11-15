<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<div class="nav row">
   <div class="col"> <h1 class="nav-title col">Welcome,  <c:out value="${user.userName}"></c:out>  </h1></div>
   <div class="col"> <a class="row" href="/logout">logout</a><a class="row" href="/project/new">Add new Project  for me</a></div>
</div>

<div class="cont">
	<table class="table table-bordered table-striped .table-sm">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
   
      <th scope="col">Actions</th>
    </tr>
  </thead>
  
  <c:forEach var="project" items="${projects}">
  <tbody>
    <tr>
          <th scope="row"><c:out value="${project.id}"></c:out></th>
      <th ><a href="/show/${project.id}"><c:out value="${project.title}"></c:out></a></th>
      	      <td><c:out value="${project.teamLead.userName}"></c:out></td>
      	      		<fmt:formatDate value="${project.date}" pattern="MMMM dd" var="myDate" />
      	      
	       <td><c:out value="${myDate}" ></c:out></td>
	           <c:if test="${ project.teamLead.id!=user.id}">
	          <th scope="col"><a href="/join/${project.id}/">Join</a></th>
	          </c:if>
	           <c:if test="${ project.teamLead.id==user.id}">
	          <th scope="col"><a href="/edit/${project.id}">edit</a><a href="/delete/${project.id}">delete</a></th>
	          </c:if>
	    
	      
    </tr>
    </c:forEach>
    </tbody>
    
    </table>
    
    <div>
    <h5> my projects</h5>
    </div>
    <table class="table table-bordered table-striped .table-sm bal">
  <thead class="thead-dark">
    <tr>
     <th scope="col">#</th>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
   
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <c:forEach var="project" items="${myprojects}">
  <tbody>
    <tr>
          <th scope="row"><c:out value="${project.id}"></c:out></th>
      <th ><a href="/show/${project.id}"><c:out value="${project.title}"></c:out></a></th>
	      <td><c:out value="${project.teamLead.userName}"></c:out></td>
	      	<fmt:formatDate value="${project.date}" pattern="MMMM dd" var="myDate" />
      	      
	       <td><c:out value="${myDate}" ></c:out></td>
	       <c:if test="${project.teamLead.id!=user.id}">
	      	      <td><a href="/unjoin/${project.id}">Leave team </a></td>
	          </c:if>
	           <c:if test="${ project.teamLead.id==user.id}">
	          <th scope="col"><a style="padding: 5px;" href="/edit/${project.id}">edit</a><a style="padding: 5px;" href="/delete/${project.id}">delete</a></th>
	          </c:if>
	      
    </tr>
    </c:forEach>
    </tbody>
    
    </table>
    
    
    
    
    
    
    
</div>
</body>
</html>