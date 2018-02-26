package com.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/LogonServlet")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		out.println("<html>");
		out.println("<body>");

		if ("user".equals(username) && "pass".equals(password)) {
			out.println("Welcome " + username);
		} else {
			if ((username != null) || (password != null)) {
				out.println("Wrong userid or password! Please try again ");
			}

			out.println("<form method=GET  action=LogonServlet>");
			out.println("Username=<input type=text name=username> <br>");
			out.println("Password=<input type=text name=password>");
			out.println("<input type=submit value='Logon'>");
			out.println("</form>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
