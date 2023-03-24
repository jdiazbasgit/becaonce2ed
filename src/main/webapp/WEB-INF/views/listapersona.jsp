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
	<table border="1">
		<tr>
			<th>NOMBRE</th>
			<th>DNI</th>
			<th>TELEFONO</th>
		</tr>
		<c:forEach items="${listapersona}" var="persona">
			<tr>
				<td>${persona.nombre}</td>
				<td>${persona.dni}</td>
				<td>${persona.telefono}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>