package com.fdmgroup.xmlparser;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fdmgroup.dto.Currency;

public class DOMParser {

	Document dom;
	List<Currency> currencyList = new ArrayList<Currency>();
	List<String> names = new ArrayList<String>();
	
	Date date;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	File fXmlFile = new File("ConversionRates.XML");


	public ArrayList<Currency> parseXMLFile() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fXmlFile);
		
		

		doc.getDocumentElement().normalize();

		NodeList nlist = doc.getElementsByTagName("Cube");

		for (int i = 0; i < nlist.getLength(); i++) {
			Node node = nlist.item(i);

			if(node.getAttributes().getNamedItem("time")!=null){
				date= formatter.parse(node.getAttributes().getNamedItem("time").toString().substring(6,16));
			}
			
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.getAttribute("currency") != "" && element.getAttribute("rate") !="") {
					 Currency currency = new Currency();
					 currency.setConversionRate(new BigDecimal(element.getAttribute("rate")));
					 currency.setCurrencyName((element.getAttribute("currency")));
					 currency.setCurrencyDate(date);
					 currencyList.add(currency);

				}
			}
		}
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<Currency>) currencyList;
	}
	
	public ArrayList<String> ParseXMLGetCurrencyNames(){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fXmlFile);
		
		doc.getDocumentElement().normalize();

		NodeList nlist = doc.getElementsByTagName("Cube");

		for (int i = 0; i < nlist.getLength(); i++) {
			Node node = nlist.item(i);

			
			if (node.getNodeType() == node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.getAttribute("currency") != "" && element.getAttribute("rate") !="") {
					String name = null;
					name = element.getAttribute("currency");
					names.add(name);

				}
			}
		}
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<String>) names;
	}
}
