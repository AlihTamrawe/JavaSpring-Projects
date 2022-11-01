<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
 <link rel="stylesheet" type="text/css" href="/CSS/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />


</head>
<body>
<div class="container overflow-hidden text-center">
  <div class="card gx-5 sizee">
   <div class="middel " >
     
     <p> In   <c:out value = "${Omikuji.getNum()}"/> years<p>
        </div>
    <div class="col " >
     
     <p> , you will live in<c:out value = "${Omikuji.getCity()}"/> years<p>
        </div>
         <div class="col">
         <p>  , with  <c:out value = "${Omikuji.getPerson()}"/><p>
          </div>
      <div class="col">
          <p> as your  <c:out value = "${Omikuji.getLive()}"/> <p>
     </div>
      <div class="col">
          <p>  room mate , <c:out value = "${Omikuji.getHobby()}"/> for living .<p>
           </div>
            <div class="col">
                    <p>  The Next time you see a <c:out value = "${Omikuji.getLive()}"/><p>
          
           </div>
            <div class="col">
          <p> you will have good luck Also,  <c:out value = "${Omikuji.getComment()}"/><p>
     
      </div>
 
   
  </div>
</div>

		<div class="callout-danger ">
		<a href="/"> back</a>
		</div>

</body>
</html>