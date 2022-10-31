<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Receipt</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
<body>
   
   
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
      </tr>
    </thead>
    <tbody>
    
   
   <c:forEach var="one" items="${fruits}">
   		<tr>
        <th scope="col"><c:out value="${one.getindex()}"></c:out></th>
        <th  scope="col"><c:out value="${one.getName()}"></c:out></th>
        <th  scope="col"><c:out value="${one.getPrice()}"></c:out></th>
       </tr>	
   		 
   </c:forEach>
  

  
     
    </tbody>
</table>
 
   
 	<!-- <script type="text/javascript" src="js/app.js"></script>**/ -->
 
</body>
</html>