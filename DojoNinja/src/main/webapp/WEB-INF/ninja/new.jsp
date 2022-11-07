<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninjas</title>

 <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
		
		
		<div class="main-cont">
		
 <form:form action="/ninja/new" method="post" modelAttribute="ninja">
    <form:select path="dojo">
            <c:forEach var="onedojo" items="${dojos}">
    
       <form:option value="${onedojo.id}" path="dojo">
                <c:out value="${onedojo.name}"/>
            </form:option>
        </c:forEach>
            
   </form:select>
    <p>
        <form:label path="firstName">first name</form:label>
        <form:errors path="firstName" class="text-danger"/>
        <form:input path="firstName"/>
    </p>
      <p>
        <form:label path="lastName">last name</form:label>
        <form:errors path="lastName" class="text-danger"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age" class="text-danger"/>
        <form:textarea path="age"/>
    </p>
    
     
    <input class="btn btn-primary " type="submit" value="Submit"/>
</form:form>
</div>
		
</body>
</html> 	