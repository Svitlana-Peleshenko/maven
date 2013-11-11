package com.epam.tests;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;
import com.epam.configuration.TestConfig;
import com.epam.configuration.WebDriverFactory;
import com.epam.data_readers.MailReader;



public class BaseTest {

	protected WebDriver driver;
	String URL="http://pn.com.ua";

	@BeforeTest
	public void setUp() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(System.getProperty("webdriver.browser", "firefox"));
		driver = WebDriverFactory.getDriver(cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() throws Exception {
		
		//MailReader.deleteFile(TestConfig.getMailFolderPath());		
		driver.quit();
	}

	
	public void openUrl(){
		driver.get(URL);
	}
	
}
