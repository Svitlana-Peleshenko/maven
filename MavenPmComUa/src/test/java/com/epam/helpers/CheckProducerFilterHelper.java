package com.epam.helpers;

import org.testng.Assert;


import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Filter;

import com.epam.components.NavigateMenu;

public class CheckProducerFilterHelper {

	public static void CheckProducerFilter(NavigateMenu menu, Catalog catalog,
			Filter filter) {
		filter.ClickShowcCommonProducer();

		int lastPage = menu.getLastPage();
		for (int k = 0; k < lastPage; k++) {
			for (int i = 0; i < catalog.getTitles().size(); i++) {
				String buf = catalog.getTitles().get(i).getText();
				Assert.assertEquals(CheckAccordanceProducer(buf, filter), true);
			}
			if (k != lastPage - 1)
				menu.goToNextPage();
		}
	}

	public static boolean CheckAccordanceProducer(String buf, Filter filter) {

		int count = filter.getListProducers().size();
		for (int j = 0; j < count; j++) {
			String producer = filter.getListProducers().get(j).getText();
			if (buf.contains(producer)) {
				return true;
			}

		}

		return false;

	}
}
