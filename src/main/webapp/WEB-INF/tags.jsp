<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="once" uri="/WEB-INF/tlds/once.tld"%>
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
		<ol>
			<once:repeticiones texto="pepe" cantidad="10">
				
					<li><once:valor tipo="true" /></li>
				
			</once:repeticiones>
		</ol>
	</div>
</body>
</html>