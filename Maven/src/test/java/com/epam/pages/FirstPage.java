package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.MyPageFactory;

public class FirstPage extends Page {

	@FindBy(linkText = "Войти")
	public WebElement logInButton;

	@FindBy(xpath = ".//*[@id='head_up']/td[7]/a")
	public WebElement reg;

	@FindBy(id = "provider_iframe1")
	public WebElement logInFrame;

	@FindBy(id = "login")
	public WebElement logInField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(xpath = ".//*[@id='loginForm']/div[3]/div[1]/div[3]/a")
	public WebElement loginButtonInFrame;
	@FindBy(xpath = ".//*[@id='head_up']/td[9]/a")
	public static WebElement logOutBtn;

	@Override
	public void tryToOpen() {
		waiter().until(ExpectedConditions.visibilityOf(logOutBtn)).click();

	}

	public MainPage doLogin(String login, String password) {

		waiter().until(ExpectedConditions.visibilityOf(logInButton)).click();
		;
		driver.switchTo().frame(logInFrame);
		waiter().until(ExpectedConditions.visibilityOf(logInField)).sendKeys(
				login);
		waiter().until(ExpectedConditions.visibilityOf(passwordField))
				.sendKeys(password);
		waiter().until(ExpectedConditions.visibilityOf(loginButtonInFrame))
				.click();
	
		return MyPageFactory.getPage(driver, MainPage.class);

	}

}
