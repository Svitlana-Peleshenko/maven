package com.epam.components;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class Filter extends Component {

	public final static String LIST_MAX_PRICE = ".//div[4][@class='group']/div[2]/a";
	public final static String LIST_MIN_PRICE = ".//div[3][@class='group']/div[2]/a";
	public final static String LIST_PRODUCERS = "[href^='http://pn.com.ua/ct/2138/?fo']";
	public final static String WEIGHT_ADJUSTMENT = "[href$='ct/2138/?ff=883']";
	public final static String SHOW_COMMON_PRODUCER = ".show_common_producer";
	public final static String FUNCTIONS = "//div[@class='group'][8]/div[@class='is_empty_items']/a";
	public final static String PANEL_CORNER_CRITERIAL = ".//div[@class='panel corner criteria']";
	public final static String DIV_MIN_PRICE = ".//div[3][@class='group']/div[2]";
	public final static String DIV_MAX_PRICE = ".//div[4][@class='group']/div[2]";

	@FindBy(xpath = Filter.LIST_MIN_PRICE)
	List<WebElement> listMinPrice;

	@FindBy(xpath = Filter.LIST_MAX_PRICE)
	List<WebElement> listMaxPrice;

	@FindBy(css = Filter.LIST_PRODUCERS)
	List<WebElement> listProducers;

	@FindBy(xpath = Filter.WEIGHT_ADJUSTMENT)
	List<WebElement> weightAdjustment;
	@FindBy(css = Filter.SHOW_COMMON_PRODUCER)
	WebElement showcCommonProducer;

	@FindBy(xpath = Filter.FUNCTIONS)
	List<WebElement> functions;

	@FindBy(xpath = Filter.PANEL_CORNER_CRITERIAL)
	WebElement panelCornerCriterial;

	@FindBy(xpath = Filter.DIV_MIN_PRICE)
	WebElement divMinPrice;

	@FindBy(xpath = Filter.DIV_MAX_PRICE)
	WebElement divMaxPrice;

	public WebElement getDivMaxPrice() {
		return divMaxPrice;
	}

	public WebElement getDivMinPrice() {
		return divMinPrice;
	}

	public WebElement getPanelCornerCriterial() {
		return panelCornerCriterial;
	}

	public List<WebElement> getFunctions() {
		return functions;
	}

	public void ClickShowcCommonProducer() {
		Reporter.log("Click on link 'showcCommonProducer'.<br>");
		showcCommonProducer.click();
	}

	public List<WebElement> getListProducers() {
		return listProducers;
	}

	public String getProducer(int i) {
		return getListProducers().get(i).getText();
	}

	public List<WebElement> getWeightAdjustment() {
		return weightAdjustment;
	}

	public void ClickOnFunctionLink(int i) {
		Reporter.log("Click on selected parameters(function) .<br>");
		getFunctions().get(i).click();
	}

	public boolean ClickMinPriceLink(int minPrice) {

		if (minPrice == 0) {
			return false;
		}

		else {
			String minPr = String.valueOf(minPrice);
			WebElement minPricelink = getDivMinPrice().findElement(
					By.linkText(minPr));
			Reporter.log("Click on link 'minPrice'.<br>");
			minPricelink.click();
			return true;
		}
	}

	public boolean ClickMaxPriceLink(int maxPrice) {

		if (maxPrice == 0) {
			return false;
		}

		else {
			String maxPr = String.valueOf(maxPrice);
			WebElement maxPricelink = getDivMaxPrice().findElement(
					By.linkText(maxPr));
			Reporter.log("Click on link 'maxPrice'.<br>");
			maxPricelink.click();
			return true;
		}
	}

	public boolean ChooseFunction(String function) {

		Reporter.log("Find the function which title equals entered function.<br>");
		WebElement elem = getPanelCornerCriterial().findElement(
				By.linkText(function));
		Reporter.log("Product search with the specified function.<br>");
		elem.click();
		return true;

	}

}
