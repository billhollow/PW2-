<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Demo</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/roles/add?action=creating">CREATE</a>

<div align="center">
<h1> Roles </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>NAME</td>
	</tr>
<% for (int i = 0;i<roles.size();i++){ %>
<% Role x = (Role)roles.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getName() %>  </td>

	<td><a href="/roles/view?action=reading&roleId=<%=x.getId()%>">view </a></td>
	<td><a href="/roles/update?action=updating&roleId=<%=x.getId()%>">update</a></td>
	<td><a href="/roles/delete?action=deleting&roleId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>