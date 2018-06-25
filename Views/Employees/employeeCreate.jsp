<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating employee</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/employees">Empleados</a>

	<h1>Creating an employee</h1>
	<fieldset>
		<legend> PERFIL </legend>
		<form method="get" action="/employees/add">
		 <input type="hidden" name="action" value="Created"/>
			<p>
				Name: <input type="text" name="name" placeholder= "name" required minlength="3">
			</p>
			<p>
				Age: <input type="number" name="age" placeholder= "age" min="18" required>
			</p>
			<p>
				Salary: <input type="number" name="salary" placeholder= "number" min="850" step="1" required>
			</p>
			<p>
				Address: <input type="text" name="address" placeholder="address" required minlength="5">
			</p>
			<p>
				DNI: <input type="number" name="dni" placeholder="DNI" required min="10000000" max="99999999">
			</p>
			<p>
				E-MAIL: <input type="email" name="email">
			</p>
			<p>
				<input type="submit" value="enviar datos">
			</p>
		</form>
	</fieldset>
</body>
</html>