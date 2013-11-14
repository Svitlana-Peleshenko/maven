package com.epam.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
	
	

	public static final String COMPARE_LINE = ".//div[3][@class='compareLine ']/a";
	public static final String SEARCH_LABLE = "	#edit-name-1";
	public static final String SEARCH_BUTTON = "#edit-submit-1";
	
	@FindBy(xpath =Header.COMPARE_LINE)
	public WebElement compareLine;
	
	@FindBy(css = Header.SEARCH_LABLE)
	public WebElement searchLable;
	@FindBy(css =Header.SEARCH_BUTTON)
	public WebElement searchButton;
	
	public WebElement getCompareLine() {
		return compareLine;
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
