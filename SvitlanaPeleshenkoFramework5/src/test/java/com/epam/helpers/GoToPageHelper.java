package com.epam.helpers;

import javax.servlet.jsp.SkipPageException;

import org.apache.xpath.operations.Equals;
import org.testng.Reporter;

import com.epam.components.MainMenu;

// Select page witch contain products for sort
public class GoToPageHelper{
	
public static  void	GoToPages (String product,MainMenu menu) throws SkipPageException{
	
  if( menu.GoToPages(product)==false){
	  System.out.println("Entered product into xls file doesn't exist.");
	  Reporter.log("Entered product into xls file doesn't exist.<br>");
	  throw new  SkipPageException(" Entered product into xls file doesn't exist.");
	  
  }
	  
}

}
