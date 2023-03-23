<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listadoConPersonas</title>
<style type="text/css">
body {
	display: grid;
	place-items: center;
	height: 100vh;
	background-color: black;
	margin: 2rem;
	font-family: 'Space Mono', monospace;
	font-size: 34px;
	color: white;
}

table {
	border: 2px solid;
	width: 100%;
	padding-bottom: 2rem;
}

table:hover {
	background-color: white;
	color: black;
}

td {
	text-align: center;
}
</style>
</head>
<body>


	<table>
		<tr>
			<th><h4>NOMBRE</h4></th>
			<th><h4>DNI</h4></th>
			<th><h4>TELEFONO</h4></th>
		</tr>

		<c:forEach items="${propiedadGrupoPersonas}" var="l">
			<tr>
				<td>${l.getNombre()}</td>
				<td>${l.getDni()}</td>
				<td>${l.getTelefono()}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>