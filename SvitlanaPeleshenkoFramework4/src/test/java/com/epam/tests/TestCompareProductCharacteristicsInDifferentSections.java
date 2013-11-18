package com.epam.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.jsp.SkipPageException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.MainMenu;
import com.epam.components.NavigateMenu;
import com.epam.components.NavigateMenuProductInformation;
import com.epam.helpers.CompareProductCharacteristicsInDifferentSectionsHelper;
import com.epam.helpers.CheckSortingProductsByPriceAndTitleHelper;
import com.epam.helpers.CheckProductHrefAndDescriptionsInDifferentSectionsHelper;
import com.epam.helpers.GoToPageHelper;
import com.epam.provider.TestDataProvider;

public class TestCompareProductCharacteristicsInDifferentSections extends BaseTest {
	
	Catalog catalogComponent;
	NavigateMenu navigateMenuComponent;
    MainMenu mainMenuComponent;
    ComparativeTable table;
    InformationAboutProduct information;
	NavigateMenuProductInformation menu;
	Header compareLine;

	@BeforeMethod
	public void setUpMethod() {

		catalogComponent = PageFactory.initElements(driver, Catalog.class);
		navigateMenuComponent = PageFactory.initElements(driver, NavigateMenu.class);
		mainMenuComponent = PageFactory.initElements(driver, MainMenu.class);
		table=PageFactory.initElements(driver, ComparativeTable.class);
		information=PageFactory.initElements(driver, InformationAboutProduct.class);
		menu=PageFactory.initElements(driver, NavigateMenuProductInformation.class);
		compareLine=PageFactory.initElements(driver, Header.class);
	}
	@Test (dataProvider="baseDataProvider" , dataProviderClass = TestDataProvider.class)
	public void CompareProductInformation (String productForSort,Double counts) throws InterruptedException, IOException, SkipPageException  {
		openUrl();
		GoToPageHelper.GoToPages(productForSort, mainMenuComponent);
		CompareProductCharacteristicsInDifferentSectionsHelper.CompareProductInformation(catalogComponent, table, counts, information, menu,compareLine);
	}

}
