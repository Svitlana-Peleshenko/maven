package com.epam.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class NavigateMenuProductInformation {
	public static final String PAGE_BREADCRUMBS = ".//*[@id='page-breadcrumbs']/a[3]";

	@FindBy(xpath = NavigateMenuProductInformation.PAGE_BREADCRUMBS)
	WebElement pageBreadcrumbs;

	public WebElement getPageBreadcrumbs() {
		return pageBreadcrumbs;
	}
	public void goToCatalog() {
	Reporter.log("Click on link 'pageBreadcrumbs' for go to catalog.<br>");
		 pageBreadcrumbs.click();
	}

}
