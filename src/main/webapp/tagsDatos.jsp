<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="once" uri="/WEB-INF/tlds/datos.tld"%>
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
			<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false" usuario="curso" clave="Cursocurso1;">
					</datos:conexion>
		
		<ol>
			<datos:consulta sentencia="SELECT ID, USER FROM BANCO.USERS">
				
					<li><datos:valor campoo="1" /></li>
					<li><datos:valor campoo="2" /></li>
				
			</datos:consulta>
		</ol>
	</div>
</body>
</html>