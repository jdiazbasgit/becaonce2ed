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
<jsp:setProperty property="contador" name="contador" value="<%=3524%>"/>
<%//response.sendRedirect("s2Request.jsp"); %>
<jsp:forward page="/s2Page.jsp"></jsp:forward>

</body>
</html>