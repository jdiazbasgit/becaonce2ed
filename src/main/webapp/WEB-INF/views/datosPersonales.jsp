<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos personales</h1> 
	<tr>
		<th>NOMBRE</th>
		<th>APELLIDOS</th>
		<th>DNI</th>
	</tr>
	<table border="1">
		<c:forEach items="${datosPersonales}" var="persona">
		<tr>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
			<td>${persona.dni}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>