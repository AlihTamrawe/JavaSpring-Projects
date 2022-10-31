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
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
<body>
   
   
  
   
  

  
     
  
   <main>
   <div class="middel">
   <p>Welcome User !</p>
   <a href="/">Show</a>
   <form action="/add2">
   	<button class="btn ">increment</button>
   </form>
   <form action="/reset">
   	<button class="btn ">reset</button>
   </form>
   </div>
   </main>
 	<!-- <script type="text/javascript" src="js/app.js"></script>**/ -->
 
</body>
</html>