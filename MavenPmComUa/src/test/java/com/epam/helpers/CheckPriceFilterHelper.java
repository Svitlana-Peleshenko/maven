package com.epam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Filter;
import com.epam.components.NavigateMenu;

//Task3
public class CheckPriceFilterHelper {
	public static void CheckPriceFilter(NavigateMenu menu,Catalog catalog, Filter filter,
			Double minPr, Double maxPr, WebDriver driver) {
	
	int minPrice = minPr.intValue();
	int maxPrice=maxPr.intValue();
    ChooseMinMaxPrice( filter,  minPrice,  maxPrice);
	do{
		for (int j = 0; j < catalog.getItems().size(); j++) {
			Assert.assertTrue(minPrice<= catalog.getPrice(j));
			Assert.assertTrue(catalog.getPrice(j)<=maxPrice);
		}
	
		menu.goToNextPage();
	
	}
	while(driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
    
   
	
}
	public static void ChooseMinMaxPrice(Filter filter,int minPr, int maxPr){
		String minPrice = String.valueOf(minPr);
		String maxPrice=String.valueOf(maxPr); 
	for( int i=0;i<filter.getListMinPrice().size();i++){
		if(filter.getListMinPrice().get(i).getText().compareToIgnoreCase(minPrice)==0){
			filter.getListMinPrice().get(i).click();
			
		}
		
	}
	
	for( int i=0;i<filter.getListMaxPrice().size();i++){
		if(filter.getListMaxPrice().get(i).getText().compareToIgnoreCase(maxPrice)==0){
			filter.getListMaxPrice().get(i).click();
		}	
	}

}
	}
