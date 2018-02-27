package com.java.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.names.Person;

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

			@SuppressWarnings("unchecked")
			List<Person> personList = (List<Person>) session.getAttribute("list");

			if (personList == null) {
				personList = new ArrayList<>();
				session.setAttribute("list", personList);
			}
			
			// to check if the person with same key is inserted

			boolean exists = false;

			for (Person p : personList) {
				if (p.getKey().equals(key)) {
					exists = true;
					break;
				}
			}

			if (!exists) {
				Person person = new Person(key, fname, lname);
				personList.add(person);
			}
		}

		response.sendRedirect("AllNamesServlet");
	}

}
