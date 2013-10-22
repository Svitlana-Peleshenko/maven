package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.MyPageFactory;

public class InternalPage extends Page {

	@FindBy(xpath = ".//*[@id='head_up']/td[9]/a")
	public static WebElement logOutBtn;

	public void logOut() {
		waiter().until(ExpectedConditions.visibilityOf(logOutBtn)).click();
	}

	@Override
	public void tryToOpen() {
		MyPageFactory.getPage(driver, FirstPage.class).doLogin("svitlana-peleshenko",
				"sunrise_1");
	}

}
