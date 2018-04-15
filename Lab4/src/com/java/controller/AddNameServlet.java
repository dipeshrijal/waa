package com.java.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.model.Person;

/**
 * Servlet implementation class AddNameServlet
 */
@WebServlet("/AddNameServlet")
public class AddNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key").toString();
		String firstName = request.getParameter("firstname").toString();
		String lastName = request.getParameter("lastname").toString();

		if (!(key.trim().equals("") && firstName.trim().equals("") && lastName.trim().equals(""))) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			HashMap<String, Person> list = (HashMap<String, Person>) session.getAttribute("list");
			Person person = new Person(firstName, lastName);
			if (list == null) {
				list = new HashMap<String, Person>();
				session.setAttribute("list", list);
			}
			list.put(key, person);

			request.setAttribute("list", list);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("names.jsp");
		dispatcher.forward(request, response);
	}

}
