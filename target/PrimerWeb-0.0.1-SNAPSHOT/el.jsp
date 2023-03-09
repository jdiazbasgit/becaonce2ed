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
	<h1>${requestScope.variable }</h1>
	<h1>${sessionScope.variable }</h1>
	<h1>${applicationScope.variable}</h1>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>DESCRIPCION</td>
		</tr>
		<c:forEach items="${requestScope.cargos }" var="cargo">
			<tr>
				<td>${cargo.id }</td>
				<td>${cargo.descripcion }</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>