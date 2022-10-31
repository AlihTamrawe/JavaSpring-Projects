<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Receipt</title>
        <link rel="stylesheet" type="text/css" href="/CSS/style.css">
        
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- For any Bootstrap that uses JS or jQuery-->

    </head>
<body>
   
   
 <main>
  <div class="middel">
  
    <h3> You have visited <a href="/show" >welcome page</a> <c:out value="${countToShow}"></c:out>Times </h3> 
  	<a href="/clear">Test another User</a>
  </div>
  
   </main>
 	<!-- <script type="text/javascript" src="js/app.js"></script>**/ -->
 <script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>