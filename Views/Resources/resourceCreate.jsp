<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating resources</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/resources">resources</a>

	<h1>Creating a resource</h1>
	<fieldset>
		<legend> DATA </legend>
		<form method="get" action="/resources/add">
		 <input type="hidden" name="action" value="Created"/>
			<p>
				name: <input type="text" name="name" placeholder= "name" required minlength="3">
			</p>
			<p> Status:
			<input type="radio" name="status" value="true" required="required"> True
			<input type="radio" name="status" value="false"> False
			</p>
			<p>
				<input type="submit" value="enviar datos">
			</p>
		</form>
	</fieldset>
</body>
</html>