package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public static WebDriver driver;
	
	public boolean isOnThisPage(){
		return true;
	}
	
	public abstract void tryToOpen();
	
	public static WebDriverWait waiter(){
		return new WebDriverWait(driver, 10);
	}

}
