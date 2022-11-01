
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="/CSS/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji Form</title>

</head>
<body>


<div class="middel">
	<h1>Send an Omikuji</h1>

</div>

		<main>
		
    <form action="/login" method="post" class="form ">
      <div class="form-group col-md-6" >
      <label>Pick a number between 5 to 50</label>
    	<select role="col-6" name="number" class="form-control">
    	<%for(int i=5;i<51;i++){ %>
    	<option value="<%=i%>">
    	<%=i%>
    	</option >
    	  
    	
    	<% }%>
    	</select>
    	</div>
    	 
    	
         <div class="form-group col-md-6">
        <label>Enter The Name of Any City: </label>
        <input type="text" name="city" class="form-control">
        </div>
                 <div class="form-group">
        
        <label>Enter The  Name of Any Real Person;</label>
        <input type="text" name="person" class="form-control col-6">
        </div>
        <div class="form-group">
        <label>Enter Professional endeavor or hobby:</label>
        <input type="text" name="hobby" class="form-control col-6">
        </div>
        <div class="form-group">
           
        <label>Enter Any Type of living things;</label>
        <input type="text" name="live" class="form-control">
        </div>
        <div class="form-group">
        <label for="comment">Say Something Nice to someone :</label>
  		<textarea class="form-control col6" cols="2" rows="2" id="comment" name="comment"></textarea>
  		</div>
  		<div class="form-group">
  		<label>Send and show a friend</label>
        <input type="submit" value="Send">
        </div>
    </form>
		</main>

</body>
</html>