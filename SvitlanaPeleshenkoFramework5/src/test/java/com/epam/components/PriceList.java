package com.epam.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PriceList {
	
	public static final String PRICE_LIST_DESCRIPTION = ".description-link";
	@FindBy(css = PriceList.PRICE_LIST_DESCRIPTION)
	public  List<WebElement> priceListDescriptions;
	
	public  List<WebElement> getDescriptionList() {
		return priceListDescriptions;
	}
	
	public String getDescription( int i) {
		Reporter.log("Get product description.<br>");
		return priceListDescriptions.get(i).getText();
	}
	
	public String getHrefOfDescription( int i) {
		Reporter.log("Get 'href' product description with section 'PriceList'.<br>");
		return priceListDescriptions.get(i).getAttribute("href");
	}
	
	
	

}
