//package com.epam.data_readers;
//
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.jdom.Document;
//import org.jdom.input.SAXBuilder;
//
//
//public class XmlRead {
//
//	
//	public List<String> read() {
//		List<String> cities = new ArrayList<String>();
//		try {
//
//			SAXBuilder parser = new SAXBuilder();
//			FileReader fr = new FileReader("words.xml");
//			Document rDoc = parser.build(fr);
//			cities = rDoc.getRootElement().getChildren();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		return cities;
//	}
//}
