<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>

<div align="center">

<h1>WELCOME TO OUR DETAILS PAGE</h1>

</div>

<div align="center" ">

<body style="line-height:300%">

YOU MAY POST NEW DETAILS HERE

	<form action="Detailsservlet" method="post" style="line-height:250%">
	
 		 
		 Event Name:<input type="text" name="name"/><br/>
		 Date (ddmmyyyy):<input type="text" name="date"/><br/>
		 Location: <select name="location">
		 <option>North</option>
		 <option>South</option>
		 <option>East</option>
		 <option>West</option>
		 </select> <br/>
		 Time: <select name="time">
		 <option>Morning</option>
		 <option>Afternoon</option>
		 <option>Night</option>
		 </select> <br/>
		 <input type="submit" value="Post Details"/>
		 
 	</form>

</div>


CLICK HERE TO VIEW OR EDIT DETAILS

<form action="list" method="post" style="line-height:250%">

<input type="submit" value="View/Edit Details"/>
		 
</form>

</body>
</html>