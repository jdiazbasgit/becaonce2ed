<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>listado</title>
<style type="text/css">
body {
	display: grid;
	place-items: center;
	height: 100vh;
	background-color: black;
	margin: 2rem;
	overflow: hidden;
	font-family: 'Space Mono', monospace;
	font-size: 34px;
	color: white;
}

table {
	border: 2px solid;
	width: 100%;
	place-items: center;
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
			<th><h1 data-value="TABLA LISTADO">TABLA LISTADO</h1></th>
		</tr>

		<c:forEach items="${propiedadLista}" var="l">
			<tr>
				<td>${l}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>