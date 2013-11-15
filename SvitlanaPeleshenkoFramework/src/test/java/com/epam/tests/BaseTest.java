package com.epam.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import com.epam.configuration.TestConfig;
import com.epam.configuration.WebDriverFactory;
import com.epam.helpers.ScreenshotsForReporting;


public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
	    String titleDriver=TestConfig.getDriver();
		cap.setBrowserName(System.getProperty("webdriver.browser",titleDriver ));
		driver = WebDriverFactory.getDriver(cap);
		ScreenshotsForReporting.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	public void openUrl() throws IOException {
		String URL = TestConfig.getServer();
		driver.get(URL);
	}

}
