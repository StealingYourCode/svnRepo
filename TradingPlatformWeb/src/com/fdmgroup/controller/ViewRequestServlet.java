package com.fdmgroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.Request_DAO_JPA;
import entities.Person;
import entities.Request;

/**
 * Servlet implementation class ViewRequestServlet
 */
// @WebServlet("/ViewRequestServlet")
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
		Person person = new Person();
		List<Request> requestList;

		person = (Person) request.getSession().getAttribute("thisUser");

		requestList = viewRequest.readByUserId(person.getPersonId());

		PrintWriter out = response.getWriter();

		if (requestList.size() == 0) {
			out.print("<html><head><title></title></head><body>");
			out.print("You have no requests");
			out.print("</body></html>");
		}

		out.print("<html><head><title></title></head><body>");
		for (Request result : requestList) {
			out.print("Stock ID: " + result.getStockId() + " Status: "
					+ result.getStatus() + " Time-in-Force: "
					+ result.getTimeInForce() + " Buy Or Sell:  "
					+ result.getBuySell() + " Minimum Shares: "
					+ result.getMinimumShares() + "  Request Date: "
					+ result.getRequestDate() + " Number of Shares:  "
					+ result.getShares() + " Shares Filled: "
					+ result.getSharesFilled() + " Stop Price: " + result.getStopPrice()
					 + " Limit Price: " + result.getLimitPrice());

			out.println("<br>");

		}
		// out.print("The request has been completed");
		out.print("</body></html>");

	}
}
