package com.epam.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparativeTable {

	public static final String COMPARATIVE_ROWS = ".//table[@class='compare']/tbody/tr[count(td) > 1]";
	public static final String DEL_COMPARE_ITEM = "a.comparep.cs";

	@FindBy(xpath = ComparativeTable.COMPARATIVE_ROWS)
	List<WebElement> compareRows;
	@FindBy(css = ComparativeTable.DEL_COMPARE_ITEM)
	List<WebElement> delCompareItem;

	public List<WebElement> getDelCompareItem() {
		return delCompareItem;
	}

	public List<WebElement> getCompareRows() {
		return compareRows;
	}

	public WebElement getCompareRow(int i) {
		return getCompareRows().get(i);
	}

	public String getTitleFromComTable(int i) {
		return getCompareRow(i).findElement(By.xpath(".//td[1]")).getText();
	}

	public String getValueFromColumn(int i, int numElement) {
		return getCompareRow(i).findElement(
				By.xpath(".//td[" + (1 + numElement) + "]")).getText();
	}
	
	public String getValueFromComTable(int i) {
		return getCompareRow(i).findElement(By.xpath(".//td[2]")).getText();
	}
	
	
	
	
	
}
