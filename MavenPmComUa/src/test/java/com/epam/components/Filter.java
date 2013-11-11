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
	
	public List<WebElement> getFunctions() {
		return functions;
	}

	public void ClickShowcCommonProducer() {
		showcCommonProducer.click();
	}

	public List<WebElement> getListMinPrice() {
		return listMinPrice;
	}

	public List<WebElement> getListMaxPrice() {
		return ListMaxPrice;
	}

	public List<WebElement> getListProducers() {
		return listProducers;
	}

	public List<WebElement> getWeightAdjustment() {
		return weightAdjustment;
	}
	

}
