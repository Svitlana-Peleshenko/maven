package com.epam.tests;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.MainMenu;
import com.epam.components.NavigateMenu;
import com.epam.components.NavigateMenuProductInformation;
import com.epam.components.PriceList;
import com.epam.helpers.CompareProductCharacteristicsHelper;
import com.epam.helpers.CheckHrefAndDescriptionsHelper;
import com.epam.helpers.GoToPageHelper;
import com.epam.provider.TestDataProvider;

public class TestCheckHrefAndDescriptions extends BaseTest {
	Catalog catalogComponent;
	NavigateMenu navigateMenuComponent;
	MainMenu mainMenuComponent;
	InformationAboutProduct information;
	NavigateMenuProductInformation menu;
	Header header;
	PriceList priceList;
	
	@BeforeMethod
	public void setUpMethod() {

		catalogComponent = PageFactory.initElements(driver, Catalog.class);
		navigateMenuComponent = PageFactory.initElements(driver,
				NavigateMenu.class);
		mainMenuComponent = PageFactory.initElements(driver, MainMenu.class);
		information = PageFactory.initElements(driver,
				InformationAboutProduct.class);
		menu = PageFactory.initElements(driver,
				NavigateMenuProductInformation.class);
		header = PageFactory.initElements(driver, Header.class);
		priceList=PageFactory.initElements(driver, PriceList.class);
		
	}

	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void CheckHref(String productForSort, Double counts)
			throws FileNotFoundException, InterruptedException {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckHrefAndDescriptionsHelper.CheckHref(catalogComponent,navigateMenuComponent, header, priceList, counts);

	}
	
	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void CheckDescriptions(String productForSort, Double counts)
			throws FileNotFoundException, InterruptedException {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckHrefAndDescriptionsHelper.CheckDescriptions(catalogComponent, information, menu, counts);

	}

}
