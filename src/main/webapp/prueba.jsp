<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="datos" uri="/WEB-INF/tlds/datos.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<table>
			<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false"
				usuario="curso" clave="Cursocurso1;">
				
					<datos:consulta sentencia="SElECT NAME.PHONE FROM COMPANY.employees">
					<datos:valor campo ="1"/>
					<datos:valor campo ="2"/>
					</datos:consulta>
				
			</datos:conexion>
		</table>
	</div>
</body>
</html>