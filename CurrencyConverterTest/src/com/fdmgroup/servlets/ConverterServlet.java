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

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
	ApplicationContext context = new ClassPathXmlApplicationContext("file:H:/JAVA/workspace/CurrencyConverterTest/src/com/fdmgroup/tests/Beans.xml");

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverterServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CurrencyDAO dao = (CurrencyDAO) context.getBean("currencyDAO");
		
		String from = request.getParameter("convertFrom");
		String to = request.getParameter("convertTo");
		
		double input =  Double.parseDouble(request.getParameter("fromInput"));
		
		double fromCurrency = dao.read(from).getConversionRate().doubleValue();
		double toCurrency = dao.read(to).getConversionRate().doubleValue();
		
		double result1 =  (toCurrency/fromCurrency)*100;
		double result = Math.round((result1*input))/100;
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
		rd.forward(request, response);
		
	}

}
