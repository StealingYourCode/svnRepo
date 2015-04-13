package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Person;
import exceptions.StorableNotFoundException;
import jpa.User_DAO_JPA;
import userManager.JPAUserActions;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
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
		Person user = new Person();
		// PrintWriter out = response.getWriter();

		String uName = request.getParameter("Username");
		String pWord = request.getParameter("Password");

		JPAUserActions login = new JPAUserActions();

		try {
			user = login.Login(uName, pWord);
			request.getSession().setAttribute("thisUser", user);
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			request.setAttribute("thisUser", user);
//			RequestDispatcher rd = request.getRequestDispatcher("Login");
//			rd.forward(request, response);
			PrintWriter out = response.getWriter();
			out.print("<html><head><title></title></head><body>");
			out.print("Incorrect username or password");
			out.print("</body></html>");
		}

//		if (user.getUserName().equals(null)) {
//			request.setAttribute("thisUser", user);
//			RequestDispatcher rd = request.getRequestDispatcher("Login");
//			rd.forward(request, response);
//		}

		// if(user.getFirstName()!=null){
		// out.print("<html><head><title></title></head><body>");
		// out.print(user.getFirstName()+" "+user.getLastName()+" has logged in.");
		// out.print("</body></html>");
		// }
		// else{
		// PrintWriter out = response.getWriter();
		// out.print("<html><head><title></title></head><body>");
		// out.print("Incorrect username or password");
		// out.print("</body></html>");
		// }

	}

}
