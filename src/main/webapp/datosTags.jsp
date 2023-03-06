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
		
			<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY" usuario="curso" clave="Cursocurso1;">
				<datos:consulta sentencia="SELECT name, nif, phone FROM COMPANY.employees;"/>
					<datos:valor tipo="true"/>				
			</datos:conexion>
			
		</table>
	</div>
</body>
</html>