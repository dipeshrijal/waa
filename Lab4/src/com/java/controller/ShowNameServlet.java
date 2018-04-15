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
 * Servlet implementation class ShowNameServlet
 */
@WebServlet("/ShowNameServlet")
public class ShowNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		HashMap<String, Person> list = (HashMap<String, Person>) session.getAttribute("list");
		if (list == null) {
			list = new HashMap<String, Person>();
		}
		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("names.jsp");
		dispatcher.forward(request, response);
	}

}
