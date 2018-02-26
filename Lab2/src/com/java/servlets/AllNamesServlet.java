package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.names.Person;
import com.java.names.PersonList;

/**
 * Servlet implementation class AllNamesServlet
 */
@WebServlet("/AllNamesServlet")
public class AllNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		PersonList personlist = (PersonList) session.getAttribute("list");
		if (personlist == null) {
			personlist = new PersonList();
			session.setAttribute("list", personlist);
		}

		out.println("<html>");
		out.println("<body>");

		List<Person> plist = personlist.getPersonList();

		if (plist.size() > 0) {
			out.println("List of Names");
			out.println("<table>");
			for (Person p : plist) {
				out.println("<tr><th>" + p.getKey() + "</th><th>" + p.getFirstName() + "</th><th>" + p.getLastName()
						+ "</th><th>");
			}
			out.println("</table>");
		}
		
		
		out.println("<form method=GET action=AllNamesServlet>");
		out.println("<input type=submit value='Show All Names'>");
		out.println("</form>");
		out.println("<form method=GET action=AddNamesServlet>");
		out.println("Key=<input type=text name=key>");
		out.println("First Name=<input type=text name=fname>");
		out.println("Last Name=<input type=text name=lname>");
		out.println("<input type=submit value='Add'>");
		out.println("</form>");
		out.println("<form method=GET action=RemoveNamesServlet>");
		out.println("Key=<input type=text name=key>");
		out.println("<input type=submit value='Remove'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
