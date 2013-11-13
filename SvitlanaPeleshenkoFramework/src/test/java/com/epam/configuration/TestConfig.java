package com.epam.configuration;






import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


import org.junit.runner.Runner;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.data_readers.FileRead;


public class TestConfig {


	/*
	private static  Capabilities driver = DesiredCapabilities.firefox();
	
	private static  String server = "http://pn.com.ua";

	//Work with Excel
	private static  String excelFilePath = "TestData.xls";
	
	private static  String propertiesFolderPath = "properties/";
	
	*/
	
	

	//Work with Excel
	
	private static int excelSheetForPositiveTest = 0;
	
	private static int excelSheetForNegativeTest = 1;
	

	//Getters 
	public static int getSheetForPositiveTst() {
		return excelSheetForPositiveTest;
	}
	
	public static int getSheetForNegativeTst() {
		return excelSheetForNegativeTest;
	}
	
	public static String getExcelFilePath() throws IOException {
		
		String  excelFilePath = FileRead.read("excelFilePath");
		return excelFilePath;
	}
	
	public static Capabilities getDriver() throws IOException {
		
		if(FileRead.read("driver")=="firefox")
		{
			Capabilities driver = DesiredCapabilities.firefox();
		 return driver;
	    }
		return null;
		
		
	}

	public static String getServer() throws IOException {
		String  server = FileRead.read("server");
		return server;
	}
	
	public static String getPropertiesFolderPath() throws IOException {
		String  propertiesFolderPath = FileRead.read("propertiesFolderPath");
		return propertiesFolderPath;
	}
	
}
