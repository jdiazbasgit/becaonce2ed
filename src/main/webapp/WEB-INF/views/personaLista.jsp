<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>LISTADO DE PERSONAS</title>
</head>
<body>

	<table border="1">
		<c:forEach items="${nombre}" var="n">
		<c:forEach items="${apellido}" var="a">
		<c:forEach items="${dni}" var="d">
			<tr>
				<td>$[n]</td>
				<td>$[a]</td>
				<td>$[d]</td>
			</tr>
		</c:forEach>
	</table>

</head>
<body>

</body>
</html>