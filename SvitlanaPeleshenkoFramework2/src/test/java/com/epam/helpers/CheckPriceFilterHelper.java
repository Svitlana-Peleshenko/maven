package com.epam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		boolean linkMinPrice= filter.ClickMinPriceLink(minPrice);
		boolean linkMaxPrice  = filter.ClickMaxPriceLink(maxPrice);
		

		if ((linkMinPrice == true) & (linkMaxPrice == true)) {

			do {
				for (int j = 0; j < catalog.getItems().size(); j++) {
					Assert.assertTrue(minPrice <= catalog.getPrice(j));
					Assert.assertTrue(catalog.getPrice(j) <= maxPrice);
				}

				menu.goToNextPage();
			} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);

		} else if ((linkMinPrice == false) & (linkMaxPrice == true)) {

			do {
				for (int j = 0; j < catalog.getItems().size(); j++) {

					Assert.assertTrue(maxPrice >= catalog.getPrice(j));
				}
				menu.goToNextPage();
			} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
		}

		else if ((linkMaxPrice == false)&(linkMinPrice == true)  ) {
			do {
				for (int j = 0; j < catalog.getItems().size(); j++) {
					Assert.assertTrue(catalog.getPrice(j) >= minPrice);
				}
				menu.goToNextPage();
			} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
		}

		else
			System.out.println("Enter Min or Max prices in xls file.");
	}
}
