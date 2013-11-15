package com.epam.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.components.Catalog;
import com.epam.components.Filter;
import com.epam.components.MainMenu;
import com.epam.components.NavigateMenu;
import com.epam.helpers.CheckProducerFilterHelper;
import com.epam.helpers.GoToPageHelper;
import com.epam.provider.TestDataProvider;



public class TestCheckProducerFilter extends BaseTest {
	Catalog catalogComponent;
	NavigateMenu navigateMenuComponent;
    MainMenu mainMenuComponent;
    Filter filterComponent;

	@BeforeMethod
	public void setUpMethod() {

		catalogComponent = PageFactory.initElements(driver, Catalog.class);
		navigateMenuComponent = PageFactory.initElements(driver, NavigateMenu.class);
		mainMenuComponent = PageFactory.initElements(driver, MainMenu.class);
		filterComponent = PageFactory.initElements(driver, Filter.class);
			
	}

	
	@Test (dataProvider="baseDataProvider" , dataProviderClass = TestDataProvider.class)
	public void CheckProducerFilter (String productForSort) throws InterruptedException, IOException  {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckProducerFilterHelper.CheckProducerFilter( navigateMenuComponent,catalogComponent,filterComponent, driver);
	
	}

}
