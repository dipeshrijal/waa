<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guess Number</title>
<style>
.error {
	color: red;
}

.success {
	color: green;
}
</style>
</head>
<body>

	<%
		/* Random random = new Random();
		int numberToGuess = 1 + random.nextInt(10); */
		int numberToGuess = 5;
		String number = request.getParameter("number");
		if (number == null) {
			out.println("<p class='error'>Please Select a number between 1 and 10.</p>");
		} else if (number.trim().equals("")) {
			out.println("<p class='error'>Field Cannot be blank. Please Select a number between 1 and 10.</p>");
		} else {
			int guess = Integer.parseInt(number);
			if (guess == numberToGuess) {
				out.println("<p class='success'>Correct, congratulations!</p>");
			} else if (guess < numberToGuess) {
				out.println("<p class='error'>Too low, try again</p>");
			} else {
				out.println("<p class='error'>Too high, try again</p>");
			}
		}
		
	%>
	<form action='guessnumber.jsp' method='get'>
		Guess a number between 1 and 10 <input type=text name=number><br>
		<input type=submit value='submit' />
	</form>

</body>
</html>