package com.epam.helpers;


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.NavigateMenuProductInformation;

public class CompareProductCharacteristicsHelper {

	public static void CompareProductInformation(Catalog catalog,
			ComparativeTable table, Double counts,
			InformationAboutProduct information,
			NavigateMenuProductInformation menu, Header compareLine) {

		Map<String, String> informationAboutProduct = new HashMap<>();
		int count = counts.intValue();
		int numElement = 1;
		Reporter.log("Check match the  product description in 'Catalog' and 'InformationAboutProduct' sections.<br>");
		for (int i = 0; i < count; i++) {
			catalog.AddToCompare(i);
			catalog.GoToInfAboutProd(i);
			informationAboutProduct = information.getCharacteristicsMap();

			CompareInformation(table, informationAboutProduct, numElement,
					compareLine);
			menu.goToCatalog();
			numElement++;
		}

	}

	public static void CompareInformation(ComparativeTable table,
			Map<String, String> informationAboutProduct, int numElement,
			Header compareLine) {
		compareLine.goToCompareTable();
		for (String title : informationAboutProduct.keySet()) {
			for (int k = 0; k < table.getCompareRows().size(); k++) {
				String titleFromComTable = table.getTitleFromComTable(k);
				if (titleFromComTable.equals(title)) {
					String val = informationAboutProduct.get(title);
					String valFromComColumn = table.getValueFromColumn(k,
							numElement);
					Assert.assertTrue(val.compareToIgnoreCase(valFromComColumn) == 0);
				}

			}

		}

	}

	public static void CheckMarkingRows(Catalog catalog,
			ComparativeTable table, Double counts) {

		int count = counts.intValue();
		catalog.getCompareButtons().get(count).click();
		Reporter.log("Check correct marking of rows in comparative table.<br>");
		for (int i = 0; i < table.getCompareRows().size(); i++) {
			WebElement row = table.getCompareRow(i);
			String cssClass = row.getAttribute("class");
			if (cssClass.equals("different")) {
				Assert.assertEquals(CompareColumnsValue(row, count, table, i),
						false);
			} else {
				Assert.assertEquals(CompareColumnsValue(row, count, table, i),
						true);
			}

		}

	}

	private static boolean CompareColumnsValue(WebElement row, int count,
			ComparativeTable table, int i) {

		String firstValue = table.getValueFromComTable(i);
		for (int j = 2; j < count + 1; j++) {
			String value = table.getValueFromColumn(i, j);
			if (!firstValue.equals(value)) {
				return false;

			} else if (firstValue.equals(value))
				return true;

		}
		return false;
	}

}
