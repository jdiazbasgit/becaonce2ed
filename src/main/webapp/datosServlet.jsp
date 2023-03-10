<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="variable" value="soy variable de request" scope="request"/>
<c:set var="variable" value="soy variable de sesion" scope="session"/>
<c:set var="variable" value="soy variable de aplicacion" scope="application"/>
<jsp:forward page="/el.jsp"></jsp:forward>
</body>
</html>