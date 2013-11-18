package com.epam.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MainMenu {

//	public static final String HOUSHOLD_APPLIANCES = "[href^='http://pn.com.ua/ct/21']";
	public static final String HOME_PAGE_CLOUD = ".home-page-cloud";
	

	@FindBy(css = MainMenu.HOME_PAGE_CLOUD)
	public WebElement homePageCloud;
//	@FindBy(css = MainMenu.HOUSHOLD_APPLIANCES)
//	public List<WebElement> housApl;

	

	public WebElement gethomePageCloud() {
		return homePageCloud;
	}

//	public List<WebElement> getHousAllApl() {
//		return housApl;
//	}

//	public String getHousApl(int i) {
//		return getHousAllApl().get(i).getText();
//	}

	public boolean GoToPages(String product) {
	Reporter.log("Find the function which title equals entered product.<br>");
	WebElement elem = gethomePageCloud().findElement(
			By.linkText(product));
	Reporter.log("Click on product link.<br>");
	elem.click();
	return true;
	}
	
}
