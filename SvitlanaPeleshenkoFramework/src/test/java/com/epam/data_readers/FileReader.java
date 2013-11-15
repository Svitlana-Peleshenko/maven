package com.epam.data_readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;

public class FileReader {

	public static String read(String param) throws IOException {

		FileInputStream fis = new FileInputStream("configurations.txt");

		Properties p = new Properties();
		p.load(fis);
		String prop;
		switch (param) {
		case "driver":
			prop=p.getProperty("driver");
			return prop;
		case "server":
			prop=p.getProperty("server");
			return prop;
		case "excelFilePath":
			prop=p.getProperty("excelFilePath");
			return prop;
		case "propertiesFolderPath":
			prop=p.getProperty("propertiesFolderPath");
			return prop;
		}
		return null;
	}

}
