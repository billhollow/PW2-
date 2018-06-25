<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<% Resource resource = (Resource)request.getAttribute("resource");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updating</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/resources/add?action=creating">CREATE</a>

	<h1>Updating</h1>
	<form method="get" action="/resources/update">
	<input type="hidden" name="action" value="Updated"/>
	<input type="hidden" name="resourceId" value="<%=resource.getId()%>"/>
	<fieldset>
		<legend> NEW DATA </legend>
			<p>
				Name : <input type="text" name="name" value="<%=resource.getName()%>" required minlength="3" >
			</p>
			<p> Status:
			<input type="radio" name="status" value="true" required="required"> True
			<input type="radio" name="status" value="false"> False
			</p>
			<p>
				<input type="submit" value="enviar datos">
			</p>
	</fieldset>
	</form>
</body>
</html>