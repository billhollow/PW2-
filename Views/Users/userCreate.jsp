<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<%@ page import="java.util.List"%>

<% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating users</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/users">users</a>

	<h1>Creating a user</h1>
	<fieldset>
		<legend> PERFIL </legend>
		<form method="get" action="/users/add">
			<input type="hidden" name="action" value="Created" />
			
			Role: <select name="role">
			<% for(int i = 0; i<roles.size(); i++){ %>
				<option value="<%=roles.get(i)%>"> <%=roles.get(i)%></option>
			<%} %>
			</select>
			<p>
				E-MAIL: <input type="email" name="email">
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