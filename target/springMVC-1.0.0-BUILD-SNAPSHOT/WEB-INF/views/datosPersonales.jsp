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
		<th>Nombre</th>
		<th>apellidos</th>
		<th>DNI</th>
	</tr>
	<table border="1">
		<c:forEach items="${datosPersonales}" var="persona"></c:forEach>
		<tr>
			<td>$persona.nombre</td>
			<td>$persona.apellidos</td>
			<td>$persona.dni</td>
		</tr>
	</table>
</body>
</html>