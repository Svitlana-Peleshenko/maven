package com.epam.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

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
	Reporter.log("Click on link 'compareLine'.<br>");
		compareLine.click();
	}
	public void Search() {
	Reporter.log("Click on button 'searchButton'.<br>");
		searchButton.click();
	}
	
	public void TypeRequest(String title) {
	Reporter.log("Type href into 'searchLable'.<br>");
		searchLable.sendKeys(title);
	}
	
	public void ClearLabel() {
	Reporter.log("Clear 'searchLable'.<br>");
		searchLable.clear();
	}
	

}
