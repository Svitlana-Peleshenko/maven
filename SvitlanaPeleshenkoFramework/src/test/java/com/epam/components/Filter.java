package com.epam.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Filter extends Component{
	
	public  final static String  LIST_MAX_PRICE= ".//div[4][@class='group']/div[2]/a";
	public  final static String  LIST_MIN_PRICE= ".//div[3][@class='group']/div[2]/a";
	public  final static String  LIST_PRODUCERS= "[href^='http://pn.com.ua/ct/2138/?fo']";
	public  final static String  WEIGHT_ADJUSTMENT="[href$='ct/2138/?ff=883']";
	public  final static String  SHOW_COMMON_PRODUCER=".show_common_producer";
	public  final static String  FUNCTIONS="//div[@class='group'][8]/div[@class='is_empty_items']/a";
	public  final static String  PANEL_CORNER_CRITERIAL=".//div[@class='panel corner criteria']";
	
	@FindBy(xpath = Filter.LIST_MIN_PRICE)
	List<WebElement> listMinPrice;

	@FindBy(xpath = Filter.LIST_MAX_PRICE)
	List<WebElement> ListMaxPrice;
	
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
	
	public WebElement getPanelCornerCriterial() {
		return panelCornerCriterial;
	}

	public List<WebElement> getFunctions() {
		return functions;
	}
	
	public String getFunction(int i) {
		return getFunctions().get(i).getText();
		
	}

	public void ClickShowcCommonProducer() {
		showcCommonProducer.click();
	}

	public List<WebElement> getListMinPrice() {
		return listMinPrice;
	}
	
	public String getMinPrice(int i) {
		return getListMinPrice().get(i).getText();
	}
	public void ClickOnMinPriceLink(int i) {
		getListMinPrice().get(i).click();
	}

	public List<WebElement> getListMaxPrice() {
		return ListMaxPrice;
	}
	
	public String getMaxPrice(int i) {
		return getListMaxPrice().get(i).getText();
	}
	public void ClickOnMaxPriceLink(int i) {
		getListMaxPrice().get(i).click();
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
		getFunctions().get(i).click();
	}

	public boolean ClickMinPriceLink(Double minPr) {
		String minPrice = String.valueOf(minPr);
		for (int i = 0; i < getListMinPrice().size(); i++) {
			if (getMinPrice(i).compareToIgnoreCase(minPrice) == 0) {
				ClickOnMinPriceLink(i);
				return true;
			}
		}
		return false;

	}

	public boolean ClickMaxPriceLink(Double maxPr) {
		String maxPrice = String.valueOf(maxPr);
		for (int i = 0; i < getListMaxPrice().size(); i++) {
			if (getMaxPrice(i).compareToIgnoreCase(maxPrice) == 0) {
				ClickOnMaxPriceLink(i);
				return true;
			}
		}
		return false;

	}
}
