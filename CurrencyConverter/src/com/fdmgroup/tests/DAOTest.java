package com.fdmgroup.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fdmgroup.dao.CurrencyDAO;
import com.fdmgroup.dto.Currency;
import com.fdmgroup.xmlparser.DOMParser;

public class DAOTest {
	DOMParser parser = new DOMParser();
	CurrencyDAO dao = new CurrencyDAO();
	ArrayList<Currency> currencyList = parser.parseXMLFile();
	ArrayList<String> names = parser.ParseXMLGetCurrencyNames();

	@Before
	public void setUp() {

	}

	@Test
	public void testParseXMLFileReturnsCorrectListSize() {
		assertTrue(currencyList.size() == 31);
	}

	@Ignore
	@Test
	public void testFieldsInCurrencyNotNull() {
		assertTrue(currencyList.get(5).getConversionRate() != null);
		for (Currency currency : currencyList)
			System.out.println(currency.getCurrencyName());
	}

	@Ignore
	@Test
	public void createFirstPersist() {
		for (Currency currency : currencyList) {
			dao.create(currency);
		}
	}
	
	@Test
	public void testArrayListOfNames(){
		for(String name : names)
			System.out.println(name);
	}
}
