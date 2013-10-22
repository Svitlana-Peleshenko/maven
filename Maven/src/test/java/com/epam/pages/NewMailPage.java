package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.Letter;
import com.epam.onlineUa.MyPageFactory;

public class NewMailPage extends InternalPage {
	
	/*@FindBy(xpath = ".//*[@id='bfld_0']/a")
	public WebElement inboxUrl;

	@FindBy(xpath = ".//*[@id='bfld_0']/span/a")
	public WebElement refreshMail;

	@FindBy(xpath = ".//*[@id='new-letter']/a")
	public WebElement newMailUrl;

	@FindBy(id = "msg_to")
	public WebElement mailDest;

	@FindBy(id = "msg_subject")
	public WebElement subject;

	@FindBy(id = "msg_body")
	public WebElement msgBody;

	@FindBy(xpath = ".//*[@id='c_msg_new']/div[1]/div/input[1]")
	public WebElement sendMailBtn;
	
	@FindBy (xpath = ".//*[@id='c_msg_new']/div[1]/div/input[2]")
	public WebElement createDraftMailBtn;*/
	
	@FindBy(css = "div#new-letter.new-letter span")
	public WebElement writeLetter;
	@FindBy(id = "msg_to")
	public WebElement msgTo;
	@FindBy(id = "msg_subject")
	public WebElement msgSubject;
	@FindBy(id = "msg_body")
	public WebElement msgBody;
	@FindBy(xpath = ".//*[@id='c_msg_new']/div[1]/div/input[1]")
	public WebElement send;

	public AllMailsPage sendMail(Letter letter) {
		/*waiter().until(ExpectedConditions.visibilityOf(mailDest)).clear();
		mailDest.sendKeys(letter.author);
		waiter().until(ExpectedConditions.visibilityOf(subject)).clear();
		subject.sendKeys(letter.subject);
		waiter().until(ExpectedConditions.visibilityOf(msgBody)).clear();
		msgBody.sendKeys(letter.msgBody);
		waiter().until(ExpectedConditions.visibilityOf(sendMailBtn)).click();*/
		writeLetter.click();
		msgTo.clear();
		msgTo.sendKeys(letter.author);
		msgSubject.clear();
		msgSubject.sendKeys(letter.subject);
		msgBody.clear();
		msgBody.sendKeys(letter.msgBody);
		send.click();

		return MyPageFactory.getPage(driver, AllMailsPage.class);
	}
	

}
