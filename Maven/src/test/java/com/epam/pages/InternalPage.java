package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.MyPageFactory;

public class InternalPage extends Page {

	@FindBy(css = "[href$='logout.php']")
	public static WebElement logOutBtn;

	public void logOut() throws InterruptedException {
		logOutBtn.click();
		Thread.sleep(2000);
	}

	@Override
	public void tryToOpen() {
		MyPageFactory.getPage(driver, FirstPage.class).doLogin("svitlana-peleshenko",
				"sunrise_1");
	}

}
