<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="datos" uri="/WEB-INF/tlds/datos.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Allerta+Stencil&display=swap');
	body {
    background: linear-gradient(135deg, rgb(161, 160, 150), rgb(44, 39, 28));
    background-repeat: no-repeat;
    background-attachment: fixed;
		}
	#texto {
    font-family: 'Allerta Stencil', sans-serif;
    font-size: 22px;
    text-shadow: 2px 2px 4px #000000;
    box-shadow: 5px 0px 5px #0c0000;
    outline: none;       
    user-select: none;
    animation-name: desliz2;
    animation-duration: .03s;
    animation-iteration-count: infinite;
    animation-direction: alternate;
    animation-timing-function: ease-in;
		}
	@keyframes desliz {
    0% {
        transform: translateX(.5px);
        opacity: 1;
    }

    40%,
    50% {
        transform: translateX(-1px);
        opacity: 0.5;
    }

    60% {
        transform: translateX(.5px);
        opacity: 1;
    }}
    @keyframes respiracion {
    from {
        box-shadow: 0px 3px 6px #f0f0f0;
    }

    to {
        box-shadow: 0px 3px 16px #f0f0f0;
    }
}

#texto:hover {
    animation-name: respiracion;
    animation-duration: 0.3s;
    animation-iteration-count: infinite;
    animation-direction: alternate;
    animation-timing-function: ease-in-out;
}
	</style>
</head>
<body>
	<div class="container mt-5" >
		<table class= "table table-dark table-striped" id="texto">
		<tr style="font-size: 35px">
		<th>Nombre</th>
		<th>NIF</th>
		<th>Teléfono</th>
		</tr>
			<datos:conexion cadena="jdbc:mysql://82.223.202.137:3306/COMPANY?useSSL=false"
				usuario="curso" clave="Cursocurso1;">
				<datos:consulta
					sentencia="SELECT NAME, NIF, PHONE FROM COMPANY.employees;">
					<tr>
					<td><datos:valor campo="1" /></td>
					<td><datos:valor campo="2" /></td>
					<td><datos:valor campo="3" /></td>
					</tr>					
				</datos:consulta>
			</datos:conexion>

		</table>
	</div>
</body>
</html>