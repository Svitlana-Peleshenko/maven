package com.epam.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ComparativeTable {
	
	public static final String COMPARATIVE_ROWS = "html/body/div[2]/div[3]/div[1]/div[4]/div[2]/div/div[2]//*[count(td) > 1]";
	public static final String DEL_COMPARE_ITEM ="a.comparep.cs";
	
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
}
