package com.epam.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.SkipPageException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.components.Catalog;
import com.epam.components.MainMenu;
import com.epam.components.NavigateMenu;
import com.epam.helpers.CheckSortingProductsByPriceAndTitleHelper;
import com.epam.helpers.GoToPageHelper;
import com.epam.provider.TestDataProvider;



public class TestCheckSortingProductsByPriceAndTitle extends BaseTest {

	Catalog catalogComponent;
	NavigateMenu navigateMenuComponent;
	MainMenu mainMenuComponent;

	@BeforeMethod
	public void setUpMethod() {

		catalogComponent = PageFactory.initElements(driver, Catalog.class);
		navigateMenuComponent = PageFactory.initElements(driver,
				NavigateMenu.class);
		mainMenuComponent = PageFactory.initElements(driver, MainMenu.class);
	}

	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void ComparePrices(String productForSort)
			throws InterruptedException, IOException, SkipPageException {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckSortingProductsByPriceAndTitleHelper.ComparePrice(navigateMenuComponent, catalogComponent,driver);
	}

	@Test(dataProvider = "baseDataProvider", dataProviderClass = TestDataProvider.class)
	public void CompareTitles(String productForSort)
			throws InterruptedException, IOException, SkipPageException {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CheckSortingProductsByPriceAndTitleHelper.CompareTitle(navigateMenuComponent, catalogComponent,driver);
	}

}
