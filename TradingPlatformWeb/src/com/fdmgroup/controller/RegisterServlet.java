package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.User_DAO_JPA;
import userManager.JPAUserActions;
import entities.Person;
import exceptions.StorableNotFoundException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Person newUser = new Person();
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");

		User_DAO_JPA register = new User_DAO_JPA();

		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setPassword(password);
		newUser.setUserName(userName);

		try {
			register.read(userName);
			// TODO Auto-generated catch block
			out.print("<html><head><title></title></head><body>");
			out.print("This username already exists");
			out.print("</body></html>");
		} catch (StorableNotFoundException e) {

			try {
				register.create(newUser);
			} catch (StorableNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			out.print("<html><head><title></title></head><body>");
			out.print(userName + " has been created");
			out.print("</body></html>");

		}

		// try {
		//
		// } catch (StorableNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// out.print("<html><head><title></title></head><body>");
		// out.print("This username already exists");
		// out.print("</body></html>");
		// }

		// else
		// out.print("<html><head><title></title></head><body>");
		// out.print("This username already exists");
		// out.print("</body></html>");
		// }

	}
}
