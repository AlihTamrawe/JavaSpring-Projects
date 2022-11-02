
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="/CSS/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Gold Ninja </title>

</head>
<body>

<div class="d-flex container ">
		<h3>Golds:</h3>
		<input placeholder="0" value="${gold}" readonly /> 
			</div>
	
	<div class="d-flex container-xxl .justify-content-sm-between col">
	
	<div class="card d-flex align-items-center d-flex "  style="width: 20rem; height:20rem" >
  	<div class="card-body">
    	<h5 class="card-title d-flex justify-content-center">Farm</h5>
    	<h5 class="card-text"> (Earns 10-20 gold)</h5>
		
		<form action="/farm" method="post">
    	<button class="btn btn-primary ">Find Gold</button>
    	</form>
		
	  	</div>
	</div>
		<div class="card d-flex align-items-center" style="width: 20rem; height:20rem" >
  	<div class="card-body">
    	<h5 class="card-title d-flex justify-content-center">Cave</h5>
    	<h5 class="card-text"> (Earns 10-20 gold)</h5>
		<form action="/cave" method="post">
    	<button class="btn btn-primary ">Find Gold</button>
    	</form>
  	</div>
	</div>
		<div class="card d-flex align-items-center" style="width: 20rem; height:20rem" >
  	<div class="card-body ">
    	<h5 class="card-title d-flex justify-content-center">House</h5>
    	<h5 class="card-text"> (Earns 10-20 gold)</h5>
		<form action="/house" method="post">
    	<button class="btn btn-primary ">Find Gold</button>
    	</form>
  	</div>
	</div>
		<div class="card d-flex " style="width: 20rem; height:20rem" >
  	<div class="card-body">
    	<h5 class="card-title d-flex justify-content-center">Quest</h5>
    	<h5 class="card-text"> (Earns 0-50 gold)</h5>
    	<form action="/quest" method="post">
    	<button class="btn btn-primary ">Find Gold</button>
    	</form>
  	</div>
	</div>
		
	</div>
	
	
	<div class="d-flex container row " >
		<h3>Activities:</h3>
		<div  >
		
		<c:forEach var="item" items="${list}">
		<p style="color:green">
		<c:out value="${item}" />
		</p>
	
		</c:forEach>
		<c:forEach var="item" items="${list2}">
		<p style="color:red">
		<c:out value="${item}" />
		</p>
	
		</c:forEach>
		</div>
			</div>
			
			<div class="col-3">
			<form action="/reset" method="post">
			    	<button class="btn btn-primary ">Reset</button>
			    	</form>
			
			</div>
	

</body>
</html>