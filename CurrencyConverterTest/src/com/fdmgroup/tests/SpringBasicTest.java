package com.fdmgroup.tests;

import static org.junit.Assert.*;

import org.junit.Before;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.CurrencyDAO;
import com.fdmgroup.dto.Currency;

public class SpringBasicTest {
	
	static ApplicationContext context;
	
	
	@Before
	public void init(){
		
		context = new ClassPathXmlApplicationContext("file:H:/JAVA/workspace/CurrencyConverterTest/src/com/fdmgroup/tests/Beans.xml");
	}
	
	@Test
	public void testCurrency(){
		Currency currency = (Currency) context.getBean("monopolyDollars");
		double rate = currency.getConversionRate().doubleValue();
		assertTrue(rate==1000);
	}
	
	@Test
	public void testDAOSpring(){
		CurrencyDAO dao = (CurrencyDAO) context.getBean("currencyDAO");
		Currency USD = dao.read("USD");
		assertTrue(USD.getConversionRate().doubleValue()==1.06);
	}
}
