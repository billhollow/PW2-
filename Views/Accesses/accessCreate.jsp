<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.entity.*"%>
<%@ page import="java.util.List"%>
<% List<Role> roles = (List<Role>)request.getAttribute("roles"); %>
<% List<Resource> resources = (List<Resource>)request.getAttribute("resources"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating access</title>
<link rel="stylesheet" href="/css/formulario1.css">
<link rel="stylesheet" href="/css/boton.css">
</head>
<body>
	<a class="b" href='../'> Regresar</a>
	<a class="b" href="/accesses">accesses</a>

	<h1>Creating an access</h1>
	<fieldset>
		<legend> DATA </legend>
		<form method="get" action="/accesses/add">
		 <input type="hidden" name="action" value="Created"/>
			Role: <select name="role">
			<% for(int i = 0; i<roles.size(); i++){ %>
				<option value="<%=roles.get(i)%>"> <%=roles.get(i)%></option>
			<%} %>
			</select>
			Resource: <select name="resource">
			<% for(int i = 0; i<resources.size(); i++){ %>
				<option value="<%=resources.get(i)%>"> <%=resources.get(i)%></option>
			<%} %>
			</select>
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