package com.epam.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
	
	
	public static final String PRODUCTS_SERVICES = ".//div[1][@class='mmenu']/a[1]";
	public static final String ADVERTISEMENTS = ".//div[1][@class='mmenu']/a[2]";
	public static final String CAR_FIRMS = ".//div[1][@class='mmenu']/a[3]";
	public static final String COMPARE_LINE = ".//div[3][@class='compareLine ']/a";
	public static final String SEARCH_LABLE = "	#edit-name-1";
	public static final String SEARCH_BUTTON = "#edit-submit-1";
	

	
	@FindBy(xpath = Header.PRODUCTS_SERVICES)
	public WebElement productsServices;
	@FindBy(xpath =Header.ADVERTISEMENTS)
	public WebElement advertisements;
	@FindBy(xpath =Header.CAR_FIRMS)
	public WebElement carFirms;
	@FindBy(xpath =Header.COMPARE_LINE)
	public WebElement compareLine;
	
	@FindBy(css = Header.SEARCH_LABLE)
	public WebElement searchLable;
	@FindBy(css =Header.SEARCH_BUTTON)
	public WebElement searchButton;
	
	public WebElement getCompareLine() {
		return compareLine;
	}
	public WebElement getProductsServices() {
		return productsServices;
	}
	public WebElement getAdvertisements() {
		return advertisements;
	}
	public WebElement getCarFirms() {
		return carFirms;
	}
	
	public void goToCompareTable() {
		compareLine.click();
	}
	public void Search() {
		searchButton.click();
	}
	
	public void TypeRequest(String title) {
		searchLable.sendKeys(title);
	}
	
	public void ClearLabel() {
		searchLable.clear();
	}
	

}
