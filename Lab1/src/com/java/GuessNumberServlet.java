package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuessNumberServlet
 */
@WebServlet("/GuessNumberServlet")
public class GuessNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int randomNumber;

	public void init() {
		Random random = new Random();
		randomNumber = 1 + random.nextInt(10);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String number = request.getParameter("number");

		out.println("<html>");
		out.println("<body>");

		if (number != null) {
			int guess = Integer.parseInt(number);

			if (guess == randomNumber) {
				out.println("Correct, congratulations!");
			} else if (guess < randomNumber) {
				out.println("Too low, try again");
			} else {
				out.println("Too high, try again");
			}
		}

		out.println("<form method=GET action=GuessNumberServlet>");
		out.println("Guess a number=<input type=number name=number> <br>");
		out.println("<input type=submit value='Submit'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
