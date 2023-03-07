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
		<tr><th>Nombre</th></tr>
		<tr><th>NIF</th></tr>
		<tr><th>Telefono</th></tr>
			<datos:conexion cadena ="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false" usuario = "curso" clave = "Cursocurso1;">
				<datos:consulta>
					sentencia = "SELECT NAME, NIF, PHONE FROM COMPANY.employees;">
					<tr><th><datos:valorcampo"1"/></th></tr>
					<tr><th><datos:valorcampo"2"/></th></tr>
					<tr><th><datos:valorcampo"3"/></th></tr>
				</datos:consulta>
				
					<li><once:valor tipo="true" /></li>
				
			</datos:conexion>
		
	</div>
</body>
</html>