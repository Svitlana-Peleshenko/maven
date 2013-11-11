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


public class CompareHelper {

	

	public static void ComparePrice(NavigateMenu menu, Catalog catalog)
			throws InterruptedException {
		menu.priceSortClick();
		int lastPage = menu.getLastPage();
		int buf = 0;
		for (int i = 0; i < lastPage; i++) {
			for (int j = 0; j < catalog.getItems().size(); j++) {
				Assert.assertTrue(buf <= catalog.getPrice(j));
				buf = catalog.getPrice(j);
			}
			if (i != lastPage - 1)
				menu.goToNextPage();
		}
	}

	public static void CompareTitle(NavigateMenu menu, Catalog catalog)
			throws InterruptedException {
		menu.titleSortClick();
		int lastPage = menu.getLastPage();
		String bufSt = "0";
		String currentTitle;
		for (int i = 0; i < lastPage; i++) {

			for (int j = 0; j < catalog.getItems().size(); j++) {
				currentTitle = catalog.getTitle(j);
				Assert.assertTrue(bufSt.compareToIgnoreCase(currentTitle) <= 0);
				bufSt = currentTitle;
			}

			if (i != lastPage - 1)
				menu.goToNextPage();
		}

	}

}
