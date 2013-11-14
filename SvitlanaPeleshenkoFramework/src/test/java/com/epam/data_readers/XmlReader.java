package com.epam.data_readers;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;


public class XmlReader {

	
	public Object[][] read() {
		Object[][] data = null;
		try {

			SAXBuilder parser = new SAXBuilder();
			FileReader fr = new FileReader("properties.xml");
			Document rDoc = parser.build(fr);
			//data[][] = rDoc.getRootElement().getChildren();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return data;
	}
}
