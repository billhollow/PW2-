<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Resource> resources = (List<Resource>)request.getAttribute("resources"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Demo</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/resources/add?action=creating">CREATE</a>

<div align="center">
<h1> Resources </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>NAME</td>
		<td>STATUS</td>
	</tr>
<% for (int i = 0;i<resources.size();i++){ %>
<% Resource x = (Resource)resources.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getName() %>  </td>
	<td> <%= x.getStatus() %> </td>

	<td><a href="resources/view?action=reading&resourceId=<%=x.getId()%>">view </a></td>
	<td><a href="resources/update?action=updating&resourceId=<%=x.getId()%>">update</a></td>
	<td><a href="resources/delete?action=deleting&resourceId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>