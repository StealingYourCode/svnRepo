package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.factory.DAOFactory;
import com.fdmgroup.factory.DAOFactory.daoType;

import jpa.Request_DAO_JPA;
import entities.Person;
import entities.Request;

/**
 * Servlet implementation class ViewRequestServlet
 */
 @WebServlet("/ViewRequestServlet")
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRequestServlet() {
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

		Request_DAO_JPA viewRequest = new Request_DAO_JPA();
//		viewRequest = DAOFactory.daoFactory(daoType.REQUESTDAO);
		Person person = new Person();
		List<Request> requestList;

		person = (Person) request.getSession().getAttribute("thisUser");

		requestList = viewRequest.readByUserId(person.getPersonId()); //Cannot use a factory because readByUserId is not part of the IStorage interface

//		PrintWriter out = response.getWriter();
		
		request.getSession().setAttribute("thisRequestList", requestList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewRequestUI");
		rd.forward(request, response);




	}
}
