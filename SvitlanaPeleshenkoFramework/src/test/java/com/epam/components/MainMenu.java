package com.epam.components;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu {

	public static final String COMPUTERS = "[href$='/computer/']";
	public static final String DOMESTIC_EQUIPMENT = "[href$='/domestic_equipment/']";
	public static final String REFRIGERATOR = "[href$='/ct/2163/']";
	public static final String MICROWAVE = "[href$='/ct/2137/']";
	public static final String WASHING_MASHINE = "[href$='/ct/2161/']";
	public static final String BREAD_MAKER = "[href$='/ct/2138/']";
	public static final String HOUSHOLD_APPLIANCES= "[href^='http://pn.com.ua/ct/21']";

	
	@FindBy(css = MainMenu.COMPUTERS)
	public WebElement computers;
	@FindBy(css =MainMenu.DOMESTIC_EQUIPMENT)
	public WebElement domesticEquipment;
	@FindBy(css=MainMenu.REFRIGERATOR)
	public WebElement refrigerator;
	@FindBy(css = MainMenu.MICROWAVE)
	public WebElement microwave; 
	@FindBy(css = MainMenu.WASHING_MASHINE)
	public WebElement washingMachine;
	@FindBy(css = MainMenu.BREAD_MAKER)
	public  WebElement breadMaker;
	@FindBy(css = MainMenu.HOUSHOLD_APPLIANCES)
	public List<WebElement> housApl;
	
	
	public WebElement getComputers() {
		return computers;
	}
	public WebElement getDomesticEquipment() {
		return domesticEquipment;
	}
	public WebElement getRefrigerator() {
		return refrigerator;
	}
	public WebElement getMicrowave() {
		return microwave;
	}
	public WebElement getWashingMachine() {
		return washingMachine;
	}
	public WebElement getBreadMaker() {
		return breadMaker;
	}
	public List<WebElement> getHousAllApl() {
		return housApl;
	}
	public String getHousApl(int i) {
		return getHousAllApl().get(i).getText();
	}
	
	
	public boolean GoToPages (String product){
		
	for( int i=0;i<getHousAllApl().size();i++){
		if(getHousApl(i).compareToIgnoreCase(product)==0){
		    getHousAllApl().get(i).click();
		    return true;
		}	
	}
	return false;
	
	}
}
