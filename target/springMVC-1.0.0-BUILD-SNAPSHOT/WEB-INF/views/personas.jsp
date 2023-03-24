<%@page import="java.net.URI"%>
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

	<table border=1>

		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Teléfono</th>
		</tr>
		<c:forEach var="persona" items="${personas}"> 
			<tr>
		<td>${persona.nombre}</td>
		<td>${persona.apellidos}</td>
		<td>${persona.telefono}</td>
	
			</c:forEach>
		</tr>
	</table>

</body>
</html>