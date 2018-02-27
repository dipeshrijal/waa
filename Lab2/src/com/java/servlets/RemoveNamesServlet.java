package com.java.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.names.Person;

/**
 * Servlet implementation class RemoveNamesServlet
 */
@WebServlet("/RemoveNamesServlet")
public class RemoveNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");

		if (!key.trim().equals("")) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Person> personList = (List<Person>) session.getAttribute("list");

			if (personList != null) {
				for (Person person : personList) {
					if (person.getKey().equals(key)) {
						personList.remove(person);
						break;
					}
				}
			}
		}

		response.sendRedirect("AllNamesServlet");
	}
}
