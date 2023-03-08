<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@taglib prefix="datos" uri="/WEB-INF/tlds/datos.tld" %>
		<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Tabla de Empleados</title>
				<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
				<style>
					@import url('https://fonts.googleapis.com/css2?family=Allerta+Stencil&display=swap');


					body {
						background: linear-gradient(135deg, rgb(161, 160, 150), rgb(44, 39, 28));
						background-repeat: no-repeat;
						background-attachment: fixed;
					}

					th {
						font-size: 35px;
					}

					tr:hover {
						animation-name: respiracion;
						animation-duration: 0.3s;
						animation-iteration-count: infinite;
						animation-direction: alternate;
						animation-timing-function: ease-in-out;
					}

					#texto {
						font-family: 'Allerta Stencil', sans-serif;
						font-size: 22px;
						text-shadow: 2px 2px 4px #000000;
						box-shadow: 0px 0px 0px #0c0000;
						outline: none;
						user-select: none;
					}

					.filaimpar {
						color: rgb(25, 25, 250);
						text-shadow: 1px 1px 0px #f0f0f0;
						outline: none;
						user-select: none;
						animation-name: desliz;
						animation-duration: 2s;
						animation-iteration-count: infinite;
						animation-direction: alternate;
						animation-timing-function: ease-in-out;
					}

					.filapar {
						color: rgb(250, 20, 25);
						text-shadow: 1px 1px 0px #f0f0f0;
						outline: none;
						user-select: none;
						animation-name: desliz;
						animation-duration: 2s;
						animation-iteration-count: infinite;
						animation-direction: alternate-reverse;
						animation-timing-function: ease-in-out;
					}

					@keyframes desliz {
						0% {
							transform: translateX(20px);
							opacity: 1;
						}

						100% {
							transform: translateX(-20px);
							opacity: 0.6;
						}
					}

					@keyframes respiracion {
						from {
							box-shadow: 0px 3px 6px #f0f0f0;
						}

						to {
							box-shadow: 0px 3px 16px #f0f0f0;
						}
					}
				</style>


			</head>

			<body>
				<div class="container mt-5">
					<table class="table table-dark" id="texto">
						<tr>
							<th>Nombre</th>
							<th>NIF</th>
							<th>Telefono</th>
						</tr>
						<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false" usuario="curso"
							clave="Cursocurso1;">
							<c:set var="contador" value="1"></c:set>
							<datos:consulta sentencia="SELECT NAME, NIF, PHONE FROM COMPANY.employees">

								<c:choose>
									<c:when test="${contador mod 2 eq 0}"><!--es igual que (contador % 2==0) -->												
										<tr class="filapar" id="${contador}">
											<td>
												<datos:valor campo="1" />
											</td>
											<td>
												<datos:valor campo="2" />
											</td>
											<td>
												<datos:valor campo="3" />
											</td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr class="filaimpar" id="${contador}">
											<td>
												<datos:valor campo="1" />
											</td>
											<td>
												<datos:valor campo="2" />
											</td>
											<td>
												<datos:valor campo="3" />
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
								<c:set var="contador" value="${contador+1}"></c:set>
							</datos:consulta>
						</datos:conexion>

						
					</table>
				</div>
			</body>

			</html>