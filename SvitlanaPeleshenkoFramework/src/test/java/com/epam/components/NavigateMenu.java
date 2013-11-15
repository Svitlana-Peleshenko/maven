package com.epam.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigateMenu {

	public static final String PRICE =".//div[@class='order']/a[1]";
	public static final String TITLE = "название";
	public static final String PREVIOUS = ".//li[1][@class='pager-previous first']/span";
	public static final String NEXT = "ul.pager li.pager-next a";
	public static final String PRICE_LIST_LINK = ".//div[@class='link']/a[@class='green']";
	
	@FindBy(xpath = NavigateMenu.PRICE)
	public WebElement price;
	@FindBy(linkText = NavigateMenu.TITLE)
	public WebElement title;
	@FindBy(css = NavigateMenu.PREVIOUS)
	public WebElement back;
	@FindBy(css = NavigateMenu.NEXT)
	public WebElement next;

	@FindBy(xpath = NavigateMenu.PRICE_LIST_LINK)
	public WebElement priceList;
	
	public void priceSortClick() {
	
		price.click();
		
	}
	public void titleSortClick() {
		
		title.click();
		
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getBack() {
		return back;
	}

	public void  goToNextPage() {
		 next.click();
	}
	
	public void  goToPriceList() {
		 priceList.click();
	}

}
