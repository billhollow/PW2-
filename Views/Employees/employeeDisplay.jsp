<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.*"%>
<% List<Employee> employees = (List<Employee>)request.getAttribute("employees"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Demo</title>
<link rel="stylesheet" href="/css/tabla.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="employees/add?action=creating">CREATE</a>

<div align="center">
<h1> Employees </h1>
<table>
	<tr>	  	
		<td>ID</td>
		<td>NAME</td>
		<td>AGE</td>
		<td>SALARY</td>
		<td>ADDRESS</td>
		<td>DNI</td>
		<td>E-MAIL</td>
		<td>CREATION DATE</td>
	</tr>
<% for (int i = 0;i<employees.size();i++){ %>
<% Employee x = (Employee)employees.get(i); %>
<tr>
	<td> <%= x.getId()%> </td>
	<td> <%= x.getName()%> </td>
	<td> <%= x.getAge()%> </td>
	<td> <%= x.getSalary()%> </td>
	<td> <%= x.getAddress()%> </td>
	<td> <%= x.getDni() %>
	<td> <%= x.getEmail() %> </td>
	<td> <%= x.getDate() %> </td>
	<td><a href="employees/view?action=reading&employeeId=<%=x.getId()%>">view</a></td>
	<td><a href="employees/update?action=updating&employeeId=<%=x.getId()%>">update</a></td>
	<td><a href="employees/delete?action=deleting&employeeId=<%=x.getId()%>">delete</a></td>
</tr>
<% } %>
</table>
</div>

</body>
</html>