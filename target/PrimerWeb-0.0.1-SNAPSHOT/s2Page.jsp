<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="contador" class="beans.Contador" scope="page"></jsp:useBean>
<h1>el texto es: <jsp:getProperty property="contador" name="contador"/> </h1>
</body>
</html>