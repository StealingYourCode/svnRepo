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

import jpa.Trade_DAO_JPA;
import entities.Person;
import entities.Trade;

/**
 * Servlet implementation class TradeServlet
 */
@WebServlet("/TradeServlet")
public class TradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TradeServlet() {
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
		Trade_DAO_JPA viewTrades = new Trade_DAO_JPA();

		Person person = new Person();
		List<Trade> tradeList = new ArrayList<Trade>();

		person = (Person) request.getSession().getAttribute("thisUser");

		tradeList = viewTrades.readTradeByShareholderId(person.getPersonId());
		
		request.getSession().setAttribute("thisTradeList", tradeList);
		RequestDispatcher rd = request.getRequestDispatcher("ViewTrades");
		rd.forward(request, response);
//		PrintWriter out = response.getWriter();
//
//		if (tradeList.size() == 0) {
//			out.print("<html><head><title></title></head><body>");
//			out.print("You have no trade history");
//			out.print("</body></html>");
//		}
//
//		out.print("<html><head><title></title></head><body>");
//		for (Trade trade : tradeList) {
//			out.print("Stock ID: " + trade.getStockId() + " Transaction Time: "
//					+ trade.getTransactionTime() + " Number of Shares: "
//					+ trade.getShares() + " Share Price: "
//					+ trade.getSharePrice() + " Buyer: "
//					+ trade.getPerson1().getUserName() + " Seller: "
//					+ trade.getPerson2().getUserName());
//			
//			out.print("<br>");
//		}
//		
//		out.print("</body></html>");

	}
}
