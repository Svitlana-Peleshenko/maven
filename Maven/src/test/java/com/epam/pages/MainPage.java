package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.MyPageFactory;

public class MainPage extends InternalPage {
	
	@FindBy(xpath = "html/body/div[1]/div[3]/div[2]/div[2]/div/ul/li[2]/a[1]")
	public WebElement myMail;	
	
	public AllMailsPage goToMail() {
		driver.switchTo().defaultContent();
		myMail.click();
		return MyPageFactory.getPage(driver, AllMailsPage.class);
	}

}
