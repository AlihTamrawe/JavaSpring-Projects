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
<title>Showing Project</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body>


<div class="nav row">
   <div class="col"> <h1 class="nav-title col">,<c:out value="${project.title}"></c:out>   <c:out value="${user.userName}"></c:out>  </h1></div>
   <div class="col"> <a class="row" href="/logout">logout</a><a class="row" href="/dashboard/">Return to Dashboard</a></div>
      <div class="col"><span style="color:red"> <c:out value="${project.teamLead.userName }"></c:out></span>read<c:out value="${project.title }"></c:out>by <span style="color:green;"><c:out value="${project.teamLead }"></c:out></span></div>
   
</div>

<div class="cont">

	<div class="lin row"></div>
	<div class="row-2">
	<form action="/new/task/${project.id}" method="post" >
	<p>
	<label>Title of task</label>
	<input name="title" type="text">
		</p>
		
		<input type="submit" value="create">
	</form>
</div>
</div>

<div>
	<ul>
	<c:if test="${tasks!=null}">
	<c:forEach var="task" items="${tasks}">
		<li> <p style="font-weight: bold;">Added by <c:out value="${task.owner.userName}"/>at <c:out value="${task.date}"/></p><p> <c:out value="${task.title}"/></p> </li>
		</c:forEach>
		</c:if>
	</ul>
</div>

	

</body>
</html>