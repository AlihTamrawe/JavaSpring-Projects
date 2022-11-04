<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
<main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content" >
 
<table class="table table-bordered table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      <th scope="col">Language</th>
      <th scope="col">Pages</th>
      
    </tr>
  </thead>
  <c:forEach var="book" items="${books}">
  <tbody>
    <tr>
      <th scope="row"><c:out value="${book.getId()}"></c:out></th>
      <td><a href="/books/${book.getId()}/"><c:out value="${book.getTitle()}"></c:out></a></td>
      <td><c:out value="${book.getDescription()}"></c:out> </td>
      <td><c:out value="${book.getLanguage()}"></c:out></td>
      <td><c:out value="${book.getNumberOfPages()}"></c:out></td>
      
    </tr>
    </tbody>
    </c:forEach>
    </table>

	</main>

</body>
</html>