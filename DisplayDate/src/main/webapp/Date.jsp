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
   
   
   
        <div class="tim date">
         <h1 > The Date is : <c:out value="${date}"/> </h1>
        </div>
       
  	<ul class="card">
  <li class="nav-item">
  <form action="/">
    <button class="btn btn-primary" type="submit">Back </button>
    </form>
  </li>
  </ul>


   
 	<script type="text/javascript" src="js/app.js"></script>
 
</body>
</html>