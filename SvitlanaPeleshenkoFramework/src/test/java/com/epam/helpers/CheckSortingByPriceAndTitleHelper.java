package com.epam.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.epam.components.*;

public class CheckSortingByPriceAndTitleHelper {

	public static void ComparePrice(NavigateMenu menu, Catalog catalog,
			WebDriver driver) throws InterruptedException {
		menu.priceSortClick();
		// int lastPage = menu.getLastPage();
		int buf = 0;

		do {
			for (int j = 0; j < catalog.getItems().size(); j++) {
				Assert.assertTrue(buf <= catalog.getPrice(j));
				buf = catalog.getPrice(j);
			}

			menu.goToNextPage();
		} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
	}

	public static void CompareTitle(NavigateMenu menu, Catalog catalog,
			WebDriver driver) throws InterruptedException {
		menu.titleSortClick();
		int lastPage = menu.getLastPage();
		String bufSt = "0";
		String currentTitle;

		do {
			for (int j = 0; j < catalog.getItems().size(); j++) {
				currentTitle = catalog.getTitle(j);
				Assert.assertTrue(bufSt.compareToIgnoreCase(currentTitle) <= 0);
				bufSt = currentTitle;
			}
		} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);

	}

}
