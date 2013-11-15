package com.epam.helpers;

import org.apache.xpath.operations.Equals;

import com.epam.components.MainMenu;

// Select page witch contain products for sort
public class GoToPageHelper{
	
public static  void	GoToPages (String product,MainMenu menu){
	
  if( menu.GoToPages(product)==false){
	  System.out.println("Product entered into xls file doesn't exist.");
	  
  }
	  
}

}
