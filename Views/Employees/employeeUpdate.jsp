<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<% Employee employee = (Employee)request.getAttribute("employee");%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/employees/add?action=creating">CREATE</a>

	<h1>Updating</h1>
	<form method="get" action="/employees/update">
	<input type="hidden" name="action" value="Updated"/>
	<input type="hidden" name="employeeId" value="<%=employee.getId()%>"/>
	<fieldset>
		<legend> NEW DATA </legend>
			<p>
				Name: <input type="text" name="name" value="<%=employee.getName()%>" required minlength="3" >
			</p>
			<p>
				new Age: <input type="number" name="age" value="<%=employee.getAge()%>"  min="18" step="1" required>
			</p>
			<p>
				new Salary: <input type="number" name="salary" value="<%=employee.getSalary()%>" min="850" step="1" required>
			</p>
			<p>
				new Address: <input type="text" name="address" value="<%=employee.getAddress()%>" required minlength="5">
			</p>
			<p>
				new DNI: <input type="number" name="dni" value="<%=employee.getDni()%>" required min="10000000" max="99999999">
			</p>
			<p>
				E-MAIL: <input type="email" name="email">
			</p>
	
			<p>
				<input type="submit" value="enviar datos">
			</p>
		
	</fieldset>
	</form>
</body>
</html>