<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personas</title>
</head>
<body>
	<table border="1">
	<tr>
	<th>NOMBRE</th>
	<th>APELLIDO</th>
	<th>TELEFONO</th>
	</tr>	
		<c:forEach items="${lista}" var="persona">
			<tr>
				<td>${persona.nombre}</td>
				<td>${persona.apellidos}</td>
				<td>${persona.telefono}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>