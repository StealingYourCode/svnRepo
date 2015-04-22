package com.fdmgroup.servlets;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.xmlparser.DOMParser;

/**
 * Application Lifecycle Listener implementation class CurrencyStartupListener
 *
 */
@WebListener
public class CurrencyStartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
	
	ApplicationContext context = new ClassPathXmlApplicationContext("file:H:/JAVA/workspace/CurrencyConverterTest/src/com/fdmgroup/tests/Beans.xml");
//	ArrayList<String> dateListString;
	

    public CurrencyStartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	DOMParser parser = (DOMParser) context.getBean("parser");
//    	DOMParser parser = new DOMParser();
		ArrayList<String> names = parser.ParseXMLGetCurrencyNames();
		
//		ArrayList<Date> dateList = parser.ParserXMLGetDates();
		
		
//		for(Date date: dateList){
//			String thisDate;
//			thisDate=date.toString();
//			dateListString.add(thisDate);
//		}
			
		
//		arg0.getServletContext().setAttribute("dateList", dateListString);		
		arg0.getServletContext().setAttribute("names", names);
	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
