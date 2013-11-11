package com.epam.tests;

import java.io.FileNotFoundException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.components.Catalog;
import com.epam.components.Filter;
import com.epam.components.MainMenu;
import com.epam.components.NavigateMenu;
import com.epam.helpers.CheckPriceFilterHelper;
import com.epam.helpers.GoToPageHelper;
import com.epam.provider.TestDataProvider;



public class TestCheckPriceFilter extends BaseTest {
	Catalog catalogComponent;
	NavigateMenu navigateMenuComponent;
	Filter filterComponent;
    MainMenu mainMenuComponent;
	@BeforeMethod
	public void setUpMethod() {
   
		catalogComponent = PageFactory.initElements(driver, Catalog.class);
		navigateMenuComponent = PageFactory.initElements(driver,
				NavigateMenu.class);
		mainMenuComponent = PageFactory.initElements(driver, MainMenu.class);
		filterComponent = PageFactory.initElements(driver, Filter.class);
	}

	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void CheckPriceFilter(String productForSort,Double minPr, Double maxPr)
			throws FileNotFoundException, InterruptedException {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckPriceFilterHelper.CheckPriceFilter(navigateMenuComponent, catalogComponent, filterComponent, minPr, maxPr,driver);
}
}	
