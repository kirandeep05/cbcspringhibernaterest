<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CBC program guide</title>
<%@ page isELIgnored="false" %>
</head>
<body>
	<h2>${HeaderText}</h2>
	<div>${CBCtext}</div>
	
	<form action="createNetwork" method="post">
		<table>
			<tr><td>Name: </td><td><input name="name" type="text"></td></tr>
			<tr><td>URL: </td><td><input name="url" type="text"></td></tr>			
			<tr><td colspan="2"><input name="submit" type="submit"></td></tr>
		</table>
	</form>
</body>
</html>