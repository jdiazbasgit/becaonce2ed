<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Teléfono</th>
		</tr>
		<c:forEach items="${listaPersonas}" var="persona">
			<tr>
				<td>${persona.nombre}</td>
				<td>${persona.apellidos}</td>
				<td>${persona.telefono}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>