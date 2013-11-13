package com.epam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Filter;
import com.epam.components.NavigateMenu;

//Task3
public class CheckPriceFilterHelper {
	public static void CheckPriceFilter(NavigateMenu menu, Catalog catalog,
			Filter filter, Double minPr, Double maxPr, WebDriver driver) {

		int minPrice = minPr.intValue();
		int maxPrice = maxPr.intValue();

		if (filter.ClickMinPriceLink(minPr) == true
				&& filter.ClickMaxPriceLink(maxPr) == true) {
			do {
				for (int j = 0; j < catalog.getItems().size(); j++) {
					Assert.assertTrue(minPrice <= catalog.getPrice(j));
					Assert.assertTrue(catalog.getPrice(j) <= maxPrice);
				}

				menu.goToNextPage();

			} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
		} else if (filter.ClickMinPriceLink(minPr) == false)
			System.out.println("Entered Min price in xls file doesn't exist.");
		else if (filter.ClickMaxPriceLink(maxPr) == false)
			System.out.println("Entered Max price in xls file doesn't exist.");
	}
}
