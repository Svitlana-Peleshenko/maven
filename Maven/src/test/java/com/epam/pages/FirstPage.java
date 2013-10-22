package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.MyPageFactory;

public class FirstPage extends Page {

	@FindBy(xpath = "html/body/div[1]/div[3]/div[2]/div[2]")
	public WebElement loginForm;
	@FindBy(id = "username")
	public WebElement userNameField;
	@FindBy(id = "userpswd")
	public WebElement userPasswordField;
	@FindBy(xpath = ".//div[@class='mail-enter']//input[@type='submit']")
	public WebElement loginButton;
	@FindBy(css = "[src^='http://secure.online.ua/']")
	public WebElement loginFrame;
	@FindBy(xpath = ".//*[@id='head_up']/td[9]/a")
	public static WebElement logOutBtn;

	@Override
	public void tryToOpen() {
		waiter().until(ExpectedConditions.visibilityOf(logOutBtn)).click();

	}

	public MainPage doLogin(String login, String password) {

		driver.switchTo().frame(loginFrame);
		userNameField.clear();
		userNameField.sendKeys(login);
		userPasswordField.clear();
		userPasswordField.sendKeys(password);
		loginButton.click();
		return MyPageFactory.getPage(driver, MainPage.class);

	}

}
