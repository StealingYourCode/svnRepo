package com.fdmgroup.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.CurrencyDAO;
import com.fdmgroup.xmlparser.DOMParser;
import com.fdmgroup.singleton.*;

/**
 * Servlet implementation class ConverterServlet
 */
@WebServlet(
        description = "ConverterServlet", 
        urlPatterns = { "/Converter" }

        )
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverterServlet() {
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
//		 TODO Auto-generated method stub
		CurrencyDAO dao = new CurrencyDAO();
		
		String from = request.getParameter("convertFrom");
		String to = request.getParameter("convertTo");
		
		double input =  Double.parseDouble(request.getParameter("fromInput"));
		
		BigDecimal fromCurrency = dao.read(from).getConversionRate();
		BigDecimal toCurrency = dao.read(to).getConversionRate();
		
		
		
		double result1 = fromCurrency.divide(toCurrency).doubleValue();
		double result = result1*input;
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/Converter");
		rd.forward(request, response);
		
				
	}

}
