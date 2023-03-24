<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="login"> -->
	<spring:form action="login" modelAttribute="login">
		<table border="1">
			<tr>
				<td>Usuario:</td>
				<td>
					<!-- <input type="text" name="usuario"> -->
					<spring:input path="usuario"/>
				</td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td>
					<!-- <input type="password" name="clave"> -->
					<spring:password path="clave"/>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit">ENVIAR</button></td>

			</tr>
		</table>
		<!-- </form> -->
	</spring:form>
</body>
</html>