<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" %>
<%@taglib prefix="once" uri="/WEB-INF/tlds/once.tld"%>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="datos" uri="/WEB-INF/tlds/datos.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
>>>>>>> c9113e36c1d5ecc891b54577fa6d82353b72dd96
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<td>NOMBRE</td>
			<td>DNI</td>
			<td>FECHA DE NACIMIENTO</td>
		</tr>
		<c:set var="contador" value="1" />
		<c:set var="estilo" value="" />
		<datos:conexion>
			<datos:consulta
				sentencia="select nombre,dni,fecha_nacimiento from empleados">
				<c:choose>
					<c:when test="${contador mod 2 eq 0}">
						<c:set var="estilo" value="bg-danger"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="estilo" value="bg-success"></c:set>
					</c:otherwise>
				</c:choose>
				<tr class="${estilo }">
					<td><datos:valor campo="1" /></td>
					<td><datos:valor campo="2" /></td>
					<td><datos:valor campo="3" /></td>
				</tr>
				<c:set var="contador" value="${contador+1}"/>
			</datos:consulta>
		</datos:conexion>

	</table>
	<h1>${4+3}</h1>
</body>
</html>