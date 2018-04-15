<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Names</title>
</head>
<body>
	<c:if test="${list!=null}">
		<p>List of Names</p>
		<table>
			<c:forEach var="key" items="${list}">
				<tr>
					<td>key=${key.key}</td>
					<td>firstName=${key.value.firstName}</td>
					<td>lastName=${key.value.lastName}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
	</c:if>
	<div>
		<form method="get" action="AddNameServlet">
			key=<input type="text" name="key" /> First Name=<input type="text"
				name="firstname" /> Last Name=<input type="text" name="lastname" />
			<input type="submit" value="Add" />
		</form>
	</div>
	<hr />
	<div>
		<form method="get" action="RemoveNameServlet">
			key=<input type="text" name="key" /> <input type="submit"
				value="Remove" />
		</form>
	</div>

</body>
</html>