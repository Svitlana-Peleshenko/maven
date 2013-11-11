package com.epam.helpers;

import org.apache.xpath.operations.Equals;

import com.epam.components.MainMenu;

// Select page witch contain products for sort
public class GoToPageHelper{
	
public static  void	GoToPages (String product,MainMenu menu){
	
	
	for( int i=0;i<menu.getHousApl().size();i++){
		if(menu.getHousApl().get(i).getText().compareToIgnoreCase(product)==0){
			menu.getHousApl().get(i).click();
		}
		
	}

}

}
