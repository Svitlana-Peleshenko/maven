package com.epam.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Catalog extends Component {
	public static final String ITEMS = ".item";
	public static final String PRICES = ".price>strong";
	public static final String DESCRIPTIONS = ".description";
	public static final String TITLES = ".name>a";
	public static final String CATALOG = ".//div[3][@class='catalog']";
	public static final String ADD_TO_COMPARE = ".compare_add_link.comparep.cs";
	public static final String COMPARE_BUTTONS = ".head-compare-link";
	public static final String POPULARITY = ".//div[2][@class='order']/span[2]";

	@FindBy(css = Catalog.ITEMS)
	private List<WebElement> items;
	@FindBy(css = Catalog.PRICES)
	private List<WebElement> prices;
	@FindBy(css = Catalog.DESCRIPTIONS)
	private List<WebElement> descriptions;
	@FindBy(css = Catalog.TITLES)
	private List<WebElement> titles;

	@FindBy(xpath = Catalog.CATALOG)
	private WebElement catalog;
	@FindBy(css = Catalog.ADD_TO_COMPARE)
	private List<WebElement> addCompare;
	@FindBy(css = Catalog.COMPARE_BUTTONS)
	private List<WebElement> compareButtons;
	@FindBy(xpath = Catalog.POPULARITY)
	private WebElement popularity;

	public List<WebElement> getTitles() {
		return titles;
	}

	public int getPrice(int i) {

		return Integer.parseInt(prices.get(i).getText().replaceAll("\\D", ""));
	}

	public WebElement getCatalog() {
		return catalog;
	}

	public List<WebElement> getDescriptions() {
		return descriptions;
	}
	
	
	public String[] getDescription(int i) {
		String[] characteristics=descriptions.get(i).getText().split("; ");
		return characteristics;
	}
	
	public String  getFullDescription(int i) {
		String descriprion=descriptions.get(i).getText();
		return descriprion;
	}

	public String getTitle(int i) {

		return titles.get(i).getText();
	}
	
	public String getHref(int i) {

		return titles.get(i).getAttribute("href");
	}

	public WebElement getPopularity() {
		return popularity;
	}

	public List<WebElement> getItems() {

		return items;
	}

	public List<WebElement> AddToCompare() {
		return addCompare;
	}

	public List<WebElement> getCompareButtons() {
		return compareButtons;
	}

	public void AddToCompare(int i) {

		addCompare.get(i).click();
	}

	public void GoToInfAboutProd(int i) {

		titles.get(i).click();
	}
	
	
	public List<String> SaveTitles(int countOfProducts) {
		List<String> listTitles = new ArrayList();

		for (int i = 0; i < countOfProducts; i++) {

			listTitles.add(getTitle(i));
		}
		return listTitles;

	}

	public List<String> SaveHref(int countOfProducts) {
		List<String> listTitles = new ArrayList();
		for (int i = 0; i < countOfProducts; i++) {

			listTitles.add(getHref(i));

		}
		return listTitles;

	}

}
