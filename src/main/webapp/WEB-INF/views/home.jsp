<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<table border="1">
		<c:forEach items="${lista}" var="items">
			<tr>
				<td>${items}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
