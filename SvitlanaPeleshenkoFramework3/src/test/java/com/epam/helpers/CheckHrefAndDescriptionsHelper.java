package com.epam.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.NavigateMenu;
import com.epam.components.NavigateMenuProductInformation;
import com.epam.components.PriceList;

public class CheckHrefAndDescriptionsHelper {

	// task 6

	public static void CheckDescriptions(Catalog catalog,
			InformationAboutProduct information,
			NavigateMenuProductInformation menu, Double counts) {
		int countOfProductions = counts.intValue();
		for (int i = 0; i < countOfProductions; i++) {
			String[] description = catalog.getDescription(i);
			catalog.GoToInfAboutProd(i);
			Map<String, String> allCharacteristics = information
					.getCharacteristicsMap();
			Reporter.log("Compare  product descriptions from sections 'InformationAboutProduct' and 'Catalog '.<br>");
			for (int j = 1; j < description.length; j++) {
				for (Entry<String, String> entry : allCharacteristics
						.entrySet()) {
					if ((description[j].indexOf(entry.getKey()) != -1)
							|| (description[j].indexOf(entry.getValue()) != -1)) {

						Assert.assertTrue((description[j].indexOf(entry
								.getKey()) != -1)
								|| (description[j].indexOf(entry.getValue()) != -1));

					}
				}
			}

			menu.goToCatalog();
		}

	}

	public static void CheckHref(Catalog catalog, NavigateMenu navigateMenu,
			Header header, PriceList priceList, Double counts) {
		int countOfProductions = counts.intValue();
		List<String> listTitles = new ArrayList<>();
		List<String> listHrefs = new ArrayList<>();
		listTitles = catalog.SaveTitles(countOfProductions);
		listHrefs = catalog.SaveHref(countOfProductions);
		navigateMenu.goToPriceList();
		for (int i = 0; i < countOfProductions; i++) {
			header.TypeRequest(listTitles.get(i));
			header.Search();
		Reporter.log("Compare  product href from sections 'PriceList' and 'Catalog '.<br>");
			for (int j = 0; j < priceList.priceListDescriptions.size(); j++) {

				Assert.assertEquals(priceList.getHrefOfDescription(j),
						listHrefs.get(i));

			}
			header.ClearLabel();
		}

	}

}
