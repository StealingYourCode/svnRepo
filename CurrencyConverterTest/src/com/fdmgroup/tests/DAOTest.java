package com.fdmgroup.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.dao.CurrencyDAO;
import com.fdmgroup.dto.Currency;
import com.fdmgroup.xmlparser.DOMParser;

public class DAOTest {
	DOMParser parser = new DOMParser();
	CurrencyDAO dao = new CurrencyDAO();
//	ArrayList<Currency> currencyList = parser.parseXMLFile();
//	ArrayList<String> names = parser.ParseXMLGetCurrencyNames();
	ArrayList<Date> dateList;
//	ArrayList<Currency> ninetydays = parser.parseXMLFile90days();
//
	@Before
	public void setUp() {
		 dateList = parser.ParserXMLGetDates();

	}
//	@Ignore
//	@Test
//	public void testParseXMLFileReturnsCorrectListSize() {
////		assertTrue(currencyList.size() == 31);
//		System.out.println(currencyList.size());
//	}
//
//	@Ignore
//	@Test
//	public void testFieldsInCurrencyNotNull() {
//		assertTrue(currencyList.get(5).getConversionRate() != null);
//		for (Currency currency : currencyList)
//			System.out.println(currency.getCurrencyName());
//	}

//	@Ignore
//	@Test
//	public void createFirstPersist90days() {
////		for(Currency currency: ninetydays)
//		dao.create(ninetydays);
//	}
	
//	@Test
//	public void createFirstPersist(){
////		for(Currency currency: currencyList)
//			dao.create(currencyList);
//	}
//	
//	@Ignore
//	@Test
//	public void testArrayListOfNames(){
//		int count =0;
//		for(String name : names){
//			System.out.println(name);
//			count++;
//			System.out.println(count);
//		}
//	}
//	
//	@Ignore
//	@Test
//	public void testingListener(){
//		DOMParser parser = new DOMParser();
//		ArrayList<String> names = parser.ParseXMLGetCurrencyNames();
//		int count=0;
//		for(String name: names){
//		System.out.println(name);
//		count++; System.out.println(count);
//		}
//	}
	
	
//	@Ignore
//	@Test
//	public void testRead(){
//		assertTrue(dao.read("RUB").getConversionRate().doubleValue()==54.94);
////		System.out.println(dao.read("RUB").getConversionRate().doubleValue());
//	}
	
//	@Test
//	public void testAverageCurrencyQuery(){
//		System.out.println(dao.avgCurrency("USD"));
//	}
	
	@Test
	public void testDateList(){
//		assertTrue(dateList.size()==90);
		System.out.println(dateList.size());
	}
}
