package com.epam.provider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import com.epam.configuration.TestConfig;
import com.epam.data_readers.ExcelRead;

public class TestDataProvider {
/*
	@DataProvider
	public static Object[][] readPositiveTest() throws IOException {

		ExcelRead read = new ExcelRead(TestConfig.getExcelFilePath());

		return read.readExcel(TestConfig.getSheetForPositiveTst());

	}

	@DataProvider
	public static Object[][] readNegativeTest() throws IOException {

		ExcelRead read = new ExcelRead(TestConfig.getExcelFilePath());

		return read.readExcel(TestConfig.getSheetForNegativeTst());

	}
	
	*/
	
	
	@DataProvider()
	 public static Object[][] baseDataProvider(Method method) throws IOException {
	  String fileName = getDataFileName(method);
	  String sheetName = method.getName();
	  ExcelRead read = new ExcelRead(fileName);
	  return read.readExcel(sheetName);
	 
	 }

	private static String getDataFileName(Method method) throws IOException{
		return TestConfig.getPropertiesFolderPath() + method.getDeclaringClass().getSimpleName() + ".xls";
	 }
	


}
