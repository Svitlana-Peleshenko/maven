package com.epam.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestConfig {
	
   private static Properties properties;

	// Work with Excel

	private static int excelSheetForPositiveTest = 0;

	private static int excelSheetForNegativeTest = 1;

	// Getters
	public static int getSheetForPositiveTst() {
		return excelSheetForPositiveTest;
	}

	public static int getSheetForNegativeTst() {
		return excelSheetForNegativeTest;
	}
	
	 static {
		  properties = new Properties();
		  try {
		   FileInputStream fis = new FileInputStream("configurations.txt");
		   properties.load (fis);
		  } catch (IOException ex) {
		   ex.printStackTrace();
		  }
		 }
	
	public static String getExcelFilePath() throws IOException {

		String excelFilePath = properties.getProperty("excelFilePath");
		return excelFilePath;
	}

//	public static Capabilities getDriver() throws IOException {
//		
//		if (FileReader.read("driver") == "firefox") {
//			Capabilities driver = DesiredCapabilities.firefox();
//			return driver;
//		}
//		return null;
//
//	}
//	
	
	public static String getDriver() throws IOException {

		String driver = properties.getProperty("driver");
		return driver;
	}

	public static String getServer() throws IOException {
		String server = properties.getProperty("server");
		return server;
	}

	public static String getPropertiesFolderPath() throws IOException {
		String propertiesFolderPath = properties
				.getProperty("propertiesFolderPath");
		return propertiesFolderPath;
	}

}
