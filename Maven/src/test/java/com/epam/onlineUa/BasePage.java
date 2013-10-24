package com.epam.onlineUa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.pages.FirstPage;
import com.epam.pages.InternalPage;



public class BasePage {
	
	private WebDriver driver;

	
	private static final String BaseUrl = "http://www.online.ua/";

	@BeforeClass()
	public FirstPage toFirstPage() {
		driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
		driver.get(BaseUrl);
		return MyPageFactory.getPage(driver, FirstPage.class);
	}
	
	@AfterClass()
	public void closeBrowser() throws InterruptedException {
		MyPageFactory.getPage(driver, InternalPage.class).logOut();
		driver.quit();
	}

}
