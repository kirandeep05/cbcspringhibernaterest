<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CBC program guide</title>
<%@ page isELIgnored="false" %>
</head>
<body>
	<h2>${HeaderText}</h2>
	<div>${CBCtext}</div>
	
	<c:forEach items="${networksList}" var="network">
		<div><a href="${network.url}">${network.name}</a></div>
	</c:forEach>
	
</body>
</html>