<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Isert title here</title>
</head>

<body>
	<h1>DATOS PERSONALES</h1>
	<tr>
		<th>NOMBRE</th>
		<th>APALLIDO</th>
		<th>DNI</th>
	</tr>

<table border="1">
		<c:forEach items="${persona}" var="persona">
			<tr>
				<td>$[Persona.nombre]</td>
				<td>$[Persona.apellido]</td>
				<td>$[Persona.dni]</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>