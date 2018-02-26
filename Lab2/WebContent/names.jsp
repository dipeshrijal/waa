<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Names</title>
</head>
<body>

	<form action="AllNamesServlet" method="get">

		<input type="submit" value="Show All Names" />

	</form>
	
	<br />

	<form action="AddNamesServlet" method="get">

		Key=<input type="text" name="key" /> First Name= <input type="text"
			name="fname" /> Last Name= <input type="text" name="lname" /> <input
			type="submit" value="Add" />
	</form>
	
	<br />

	<form action="RemoveNamesServlet" method="get">
		Key=<input type="text" name="key" /> <input type="submit"
			value="Remove" />
	</form>

</body>
</html>