<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<% Access x = (Access)request.getAttribute("access");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reading</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/accesses/add?action=creating">CREATE</a>
	<div align="center">
<h1> DATA </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td> <%= x.getId()%> </td>
	</tr>
	<tr>
		<td>Role</td>
		<td> <%= x.getRole()%> </td>
	</tr>
	<tr>
		<td>Resource</td>
		<td> <%= x.getResource()%> </td>
	</tr>
	<tr>
		<td>Status</td>
		<td> <%= x.getStatus() %> </td>
	</tr>

</table>
</div>
</body>
</html>