package com.java.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.names.Person;
import com.java.names.PersonList;

/**
 * Servlet implementation class AddNamesServlet
 */
@WebServlet("/AddNamesServlet")
public class AddNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		if (!(key.trim().equals("") && fname.trim().equals("") && lname.trim().equals(""))) {
			HttpSession session = request.getSession();
			PersonList personlist = (PersonList) session.getAttribute("list");
			if (personlist == null) {
				personlist = new PersonList();
				session.setAttribute("list", personlist);
			}
			Person person = new Person(key, fname, lname);
			personlist.addPerson(person);
		}

		response.sendRedirect("AllNamesServlet");
	}

}
