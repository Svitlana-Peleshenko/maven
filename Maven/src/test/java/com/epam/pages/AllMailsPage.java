package com.epam.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.epam.onlineUa.Letter;
import com.epam.onlineUa.MyPageFactory;

public class AllMailsPage extends InternalPage {

	@FindBy(xpath = ".//*[@id='bfld_0']/a")
	public WebElement inboxUrl;

	@FindBy(xpath = ".//*[@id='bfld_0']/span/a")
	public WebElement refreshMail;

	@FindBy(xpath = ".//*[@id='new-letter']/a")
	public WebElement newMailUrl;

	@FindBy(xpath = "html/body/div[2]/div[5]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[6]/a")
	public WebElement lastMailAdr;

	@FindBy(xpath = "html/body/div[2]/div[5]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[8]/a/span[1]")
	public WebElement lastMailSubj;

	@FindBy(xpath = "html/body/div[2]/div[5]/div[2]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[8]/a/span[2]")
	public WebElement lastMailBody;

	@FindBy(xpath = ".//*[@id='letters-list']/tbody/tr")
	public List<WebElement> lettersRow;


	public NewMailPage goToNewMail() {
		waiter().until(ExpectedConditions.visibilityOf(newMailUrl)).click();
		return MyPageFactory.getPage(driver, NewMailPage.class);
	}
	public MailPage checkMail() throws InterruptedException {
		Thread.sleep(2000);
		waiter().until(ExpectedConditions.visibilityOf(refreshMail)).click();
		return MyPageFactory.getPage(driver, MailPage.class);
	}
	public List<Letter> getLetter() {
		List<Letter> letters = new ArrayList<Letter>();
		for (WebElement row : lettersRow) {
			letters.add(convertRowToLetter(row));
		}
		return letters;
	}
	public Letter getLastLetter() {
		return new Letter(lastMailAdr.getText(), lastMailSubj.getText(),
				lastMailBody.getText());
	}
	private Letter convertRowToLetter(WebElement row) {
		List<WebElement> cells = row.findElements(By.tagName("td"));
		return new Letter(cells.get(5).getText(), cells.get(7)
				.findElement(By.className("subject")).getText(),cells.get(7)
				.findElement(By.className("text")).getText());
	}

}
