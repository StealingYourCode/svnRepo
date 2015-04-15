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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fdmgroup.dto.Currency;

public class Main {

	public static void main(String[] args) {
		Document dom;
		List<Currency> currencyList = new ArrayList<Currency>();
		Currency currency = new Currency();
		Date date=null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 


		try {
			File fXmlFile = new File("ConversionRates.XML");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :"
					+ doc.getDocumentElement().getNodeName());

			NodeList nlist = doc.getElementsByTagName("Cube");

			System.out.println("----------------------------");


			for (int i = 0; i < nlist.getLength(); i++) {
				
				Element node = (Element) nlist.item(i);
				
				if(node.getAttributes().getNamedItem("time")!=null){
					System.out.println("Group Date: "+  node.getAttributes().getNamedItem("time").toString().substring(6,16));
					date= formatter.parse(node.getAttributes().getNamedItem("time").toString().substring(6,16));
				}
				
				System.out.println("Current element: " + node.getNodeName());

				if (node.getNodeType() == node.ELEMENT_NODE) {
					Element element = (Element) node;

					if (element.getAttribute("currency") != "" && element.getAttribute("rate") !="") {
						System.out.println("Currency "+ element.getAttribute("currency"));
						System.out.println("Rate " + element.getAttribute("rate"));
						System.out.println("Date: "+date);
						System.out.println("");

						 currency.setConversionRate(new BigDecimal(element.getAttribute("rate")));
						 currency.setCountryName(element.getAttribute("currency"));
						 currencyList.add(currency);
						 System.out.println("Size of currencyList: "+currencyList.size());
					
						 
					}
				}
			}
			 System.out.println("");
			System.out.println(currencyList.get(30).getCountryName());

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
		
		
	}
}
