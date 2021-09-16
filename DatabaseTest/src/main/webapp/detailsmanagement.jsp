<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Management App</title>
</head>
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: red">
<div>
<a href="https://www.javaguides.net" class="navbar-brand"> Details Management App </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Details</a></li>
</ul>
</nav>
</header>
 <br>
 <div class="row">
 <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
 <div class="container">
 <h3 class="text-center">List of Details</h3>
 <hr>
 <div class="container text-left">
 <a href="<%=request.getContextPath()%>/details.jsp" class="btn btn-success">
 Add New Detail</a>
 </div>
 <br>
 <table class="table table-bordered" align="left">
 <thead> <tr>
 
 <th>Event Name</th>
 <th>Date</th>
 <th>Location</th>
 <th>Time</th>
 <th>Actions</th>
 </tr>
 </thead>
 <tbody>
 <!-- for (Todo todo: todos) { -->
 <c:forEach var="user" items="${listUser}">
 <script>
 console.log("${user.name}");
 console.log("comes here");
 </script>

 <tr>
 <td>
 <c:out value="${user.name}" />
 </td>
 <td>
 <c:out value="${user.date}" />
 </td>
 <td>
 <c:out value="${user.location}" />
 </td>
 <td>
 <c:out value="${user.time}" />
 </td>
 <td><a href="Detailsmanagementservlet/edit?name=<c:out value='${user.name}' />">Edit</a> 
&nbsp;&nbsp;&nbsp;&nbsp; <a href="Detailsmanagementservlet/delete?name=<c:out value='${user.name}' />">Delete</a></td>
 </tr>
 </c:forEach> <!-- } -->
 </tbody>
 </table>
 </div>
 </div>

</body>
</html>