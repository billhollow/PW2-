<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<% Employee x = (Employee)request.getAttribute("employee");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reading</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/employees/add?action=creating">CREATE</a>
	<div align="center">
<h1> Profile </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td> <%= x.getId()%> </td>
	</tr>
	<tr>
		<td>NAME</td>
		<td> <%= x.getName()%> </td>
	</tr>
	<tr>
		<td>AGE</td>
		<td> <%= x.getAge()%> </td>
	</tr>
	<tr>
		<td>SALARY</td>
	<td> <%= x.getSalary()%> </td>
	</tr>
	<tr>
		<td>ADDRESS</td>
		<td> <%= x.getAddress()%> </td>
	</tr>
	<tr>
		<td>DNI</td>
		<td> <%= x.getDni() %> </td>
	</tr>
	<tr>
		<td>E-MAIL</td>
		<td> <%= x.getEmail() %> </td>
	</tr>
	<tr>
		<td> CREATION DATE </td>
		<td> <%= x.getDate() %> </td>
	</tr>

</table>
</div>
</body>
</html>