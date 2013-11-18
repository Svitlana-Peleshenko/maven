package com.epam.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;


import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Filter;

import com.epam.components.NavigateMenu;

public class CheckExistenceAllProducersInFilterHelper {

	public static void CheckProducerFilter(NavigateMenu menu, Catalog catalog,
			Filter filter,WebDriver driver) {
		filter.ClickShowcCommonProducer();
		
		do{
			for (int i = 0; i < catalog.getTitles().size(); i++) {
				String buf = catalog.getTitle(i);  
				Reporter.log("Check  existence of the producer name in  title of the product"+buf+".<br>");
				Assert.assertEquals(CheckAccordanceProducer(buf, filter), true);
			}
			menu.goToNextPage();
		}
		while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);
	}

	public static boolean CheckAccordanceProducer(String buf, Filter filter) {

		int count = filter.getListProducers().size();
		Reporter.log("Check accordance producer in product description and filter.<br>");
		for (int j = 0; j < count; j++) {
			String producer = filter.getProducer(j);
			if (buf.contains(producer)) {
				return true;
			}

		}
		
		return false;

	}
}
