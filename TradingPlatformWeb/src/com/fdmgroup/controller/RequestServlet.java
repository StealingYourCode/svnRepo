package com.fdmgroup.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.Request_DAO_JPA;
import entities.Person;
import entities.Request;
import exceptions.StorableNotFoundException;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//IAction request_DAO_action = Factory.getAction("request");
		Request_DAO_JPA action = new Request_DAO_JPA();
		Request newrequest = new Request();
		
//		BigDecimal price = new BigDecimal(request.getParameter("price"));
		BigDecimal minimumShares = new BigDecimal(request.getParameter("minimumShares"));
		BigDecimal shares = new BigDecimal(request.getParameter("shares"));
		BigDecimal stockid = new BigDecimal(request.getParameter("stockid"));
		
				
		String buyOrSell = request.getParameter("buyOrSell");
		String timeInForce = request.getParameter("timeInForce");
		String limitOrStop = request.getParameter("limitOrStop");
		
		if(limitOrStop.equals("Limit Order")){
			newrequest.setLimitPrice(new BigDecimal(request.getParameter("price")));
		}
		if(limitOrStop.equals("Stop Order")){
			newrequest.setStopPrice(new BigDecimal(request.getParameter("price")));
		}
		if(limitOrStop.equals("None")){
			newrequest.setStopPrice(null);
			newrequest.setLimitPrice(null);
		}
		
		newrequest.setPerson( (Person) request.getSession().getAttribute("thisUser"));
		newrequest.setBuySell(buyOrSell);
		newrequest.setMinimumShares(minimumShares);
		newrequest.setShares(shares);
		newrequest.setStatus("ACTIVE");
		newrequest.setStockId(stockid);
		newrequest.setTimeInForce(timeInForce);
		newrequest.setRequestDate(Calendar.getInstance().getTime());
		

		try {
			action.create(newrequest);
		} catch (StorableNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
		dispatcher.forward(request, response);
		
		
	}

}
