package com.epam.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationAboutProduct {

	public static final String CHARACTERISTICS_TITLES = ".row>span[class='pr']";
	public static final String CHARACTERISTICS = ".row>span[class='val']";
	public static final String PRODUCTION_CHARACTERISTICS = ".//*[@class='panel corner item-stats']/div[count(span) > 1]";

	@FindBy(xpath = InformationAboutProduct.PRODUCTION_CHARACTERISTICS)
	static List<WebElement> productionCharacteristics;

	@FindBy(css = InformationAboutProduct.CHARACTERISTICS_TITLES)
	List<WebElement> titlesCharacteristics;

	@FindBy(css = InformationAboutProduct.CHARACTERISTICS)
	static List<WebElement> characteristics;

	public List<WebElement> getTitlesCharacteristics() {
		return titlesCharacteristics;
	}

	public static List<WebElement> getCharacteristics() {

		return characteristics;
	}

	public static List<WebElement> getProductionCharacteristics() {
		return productionCharacteristics;
	}

	public Map<String, String> getCharacteristicsMap() {

		Map<String, String> characteristic = new HashMap<String, String>();

		for (int i = 0; i < characteristics.size(); i++) {
			characteristic.put(titlesCharacteristics.get(i).getText(), characteristics.get(i).getText());

		}
		
		return characteristic;
	}
	
	

}
