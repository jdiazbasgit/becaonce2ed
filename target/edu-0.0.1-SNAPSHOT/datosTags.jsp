<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="datos" uri="/WEB-INF/tlds/datos.tld"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="content-language" content="es-ES">
	<meta charset="utf-8">
	<!-- Bootstrap 5.2 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" media="all">
	<title>LISTADO DE TRABAJADORES</title>
		<style>
			body{
				background-color: #FFFCFC;
			}
			tr:nth-child(even) {
			  background-color: #f2f2f2;
			}
		</style>
</head>
<body>
	<div class="container" >
		<table class="table">
			<thead>
				<tr style="background-color: #AFD8FF;">
					<th scope="col">NOMBRE</th>
					<th scope="col">NIF</th>
					<th scope="col">TELEFONO</th>
				</tr>
			</thead>
			<tbody>
				<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false" usuario="curso" clave="Cursocurso1;">
					<datos:consulta sentencia="SELECT NAME, NIF, PHONE FROM employees">
						<tr>
							<td><datos:valor campo="1" /></td>
							<td><datos:valor campo="2" /></td>
							<td><datos:valor campo="3" /></td>
						</tr>		
					</datos:consulta>
				</datos:conexion>
			</tbody>
		</table>
	</div>
</body>
</html>