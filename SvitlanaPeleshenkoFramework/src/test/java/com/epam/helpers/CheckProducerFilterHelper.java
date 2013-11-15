package com.epam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Filter;

import com.epam.components.NavigateMenu;

public class CheckProducerFilterHelper {

	public static void CheckProducerFilter(NavigateMenu menu, Catalog catalog,
			Filter filter,WebDriver driver) {
		filter.ClickShowcCommonProducer();

		do{
			for (int i = 0; i < catalog.getTitles().size(); i++) {
				String buf = catalog.getTitle(i);   // getTitles().get(i).getText();
				Assert.assertEquals(CheckAccordanceProducer(buf, filter), true);
			}
			menu.goToNextPage();
		}
		while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
	}

	public static boolean CheckAccordanceProducer(String buf, Filter filter) {

		int count = filter.getListProducers().size();
		for (int j = 0; j < count; j++) {
			String producer = filter.getProducer(j);
			if (buf.contains(producer)) {
				return true;
			}

		}

		return false;

	}
}
