<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>


<html>
<head>
<title>Details Edit</title>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-
ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
 </head>
 <body> <header>
 <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
 <div>
 <a href="https://www.javaguides.net" class="navbar-brand" style="background-color: red"> Details Management App </a>
 </div>
 <ul class="navbar-nav">
 <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Details</a></li>
 </ul>
 </nav>
 </header>
 <br>
 <div class="container col-md-5">
 <div class="card">
 <div class="card-body">
 <c:if test="${user != null}">
 <form action="update" method="post">
 </c:if>
 <c:if test="${user == null}">
 <form action="insert" method="post">
 </c:if>
 <caption>
 <h2>
 <c:if test="${user != null}">
 Edit Event
 </c:if>
 <c:if test="${user == null}">
 Add New Event
 </c:if>
 </h2>
 </caption> <c:if test="${user != null}">
 <input type="hidden" name="oriName" value="<c:out value='${user.name}' />" />
 </c:if>
 <fieldset class="form-group">
 <label>Event Name</label> <input type="text" value="<c:out value='${user.name}' />" 
class="form-control" name="name" required="required">
 </fieldset>
 <fieldset class="form-group">
 <label>Date (ddmmyyyy)</label> <input type="text" value="<c:out value='${user.date}' />" 
class="form-control" name="date">
 </fieldset>
 
 <fieldset class="form-group">
 <label>Location</label> <input type="text" value="<c:out value='${user.location}' />" 
class="form-control" name="location">
 </fieldset>
 <fieldset class="form-group">
 <label> Time</label> <input type="text" value="<c:out value='${user.time}' />" 
class="form-control" name="time">
 </fieldset>
 <button type="submit" class="btn btn-success">Save</button>
 </form>
 </div>
 </div>
 </div>
 </body>
 </html>