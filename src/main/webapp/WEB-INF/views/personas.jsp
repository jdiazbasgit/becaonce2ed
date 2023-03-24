<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Datos personales</h1>
<table border="1">
		<c:forEach items="${lista}" var="datos">
			<tr>
				<td>${datos.nombre}</td>
				<td>${datos.apellidos}</td>
				<td>${datos.telefono}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>