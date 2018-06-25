<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Access> accesses = (List<Access>)request.getAttribute("accesses"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Demo</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/accesses/add?action=creating">CREATE</a>

<div align="center">
<h1> Accesses </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>ROLE</td>
		<td>RESOURCE</td>
		<td>STATUS</td>
	</tr>
<% for (int i = 0;i<accesses.size();i++){ %>
<% Access x = (Access)accesses.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getRole() %>  </td>
	<td> <%= x.getResource()%> </td>
	<td> <%= x.getStatus() %> </td>

	<td><a href="accesses/view?action=reading&accessId=<%=x.getId()%>">view </a></td>
	<td><a href="accesses/update?action=updating&accessId=<%=x.getId()%>">update</a></td>
	<td><a href="accesses/delete?action=deleting&accessId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>