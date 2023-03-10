<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h1 class="text-success">
			<%!int contador = 0;%>
			<!--  es propiedad -->
			<%
			String texto = request.getParameter("texto");
			%>
			<spam class="text-success">Has escrito</spam>
			<%=texto.toUpperCase()%>
			y tiene
			<%=texto.length()%>
			letras con sintaxix reducida <br>
			<%
			contador++;
			%>
		</h1>
		<h1>
			<%
			HttpSession mochila = session;
			%>
			ERES EL
			<div class="text-warning">VISITANTE</div>
			NUMERO:
			<%=contador%>
			<%
			if (mochila.getAttribute("visitas") == null) {
				mochila.setAttribute("visitas", 1);
			} else {
				int visitas = (Integer) mochila.getAttribute("visitas");
				visitas++;
				mochila.setAttribute("visitas", visitas);
			}
			%>
			<br> TU HAS VENIDO A VERME
			<%=mochila.getAttribute("visitas")%>
			VECES
		</h1>
		<jsp:useBean id="miClase" class="beans.MiClase"></jsp:useBean>
		<jsp:setProperty property="nombre" name="miClase" value="Federico" />
		<h1 class="text-primary"><jsp:getProperty property="nombre"
				name="miClase" /></h1>

	</div>

</body>
</html>










