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
   
   
    <main class="col-6 card" style=" display:grid; position:relative; width:100%">
	
  
        <div style="font-size:20px; margin:20px"  >
        <h1  >Name : <c:out value="${name}"/> </h1>
   		<p>Item :<c:out value="${itemname}" /></p>
 		<p>Price :<c:out value="${price}"/></p>
   	   	<p>Description :<c:out value="${description}"/></p>
       	<p>vendor :<c:out value="${vendor}"/> </p>
       	
</div>
   </main>
   
 	<script type="text/javascript" src="js/app.js"></script>
 
</body>
</html>