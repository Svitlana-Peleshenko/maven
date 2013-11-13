package com.epam.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.NavigateMenuProductInformation;

public class TestCompareProductCharacteristicsHelper {
	
	
	public static void CompareProductInformation(Catalog catalog,
			ComparativeTable table, Double counts,
			InformationAboutProduct information,
			NavigateMenuProductInformation menu, Header compareLine) {

		Map<String, String> informationAboutProduct = new HashMap<>();
		int count = counts.intValue();
		int numElement = 1;
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
				String titleFromComTable = table.getCompareRow(k)
						.findElement(By.xpath(".//td[1]")).getText();

				if (titleFromComTable.equals(title)) {
					String val = informationAboutProduct.get(title);
					String valFromComTable = table
							.getCompareRow(k)
							.findElement(
									By.xpath(".//td[" + (1 + numElement) + "]"))
							.getText();
					Assert.assertTrue(val.compareToIgnoreCase(valFromComTable) == 0);
				}

			}

		}

	}

	public static void CheckEquality(Catalog catalog, ComparativeTable table,
			Double counts) {

		int count = counts.intValue();
		// for (int i = 0; i < count; i++) {
		// catalog.AddToCompare().get(i).click();
		// }
		// Click "compare"
		catalog.getCompareButtons().get(count).click();

		for (int i = 0; i < table.getCompareRows().size(); i++) {
			WebElement row = table.getCompareRow(i);
			String cssClass = row.getAttribute("class");
			if (cssClass.equals("different")) {
				Assert.assertEquals(EqualsValue(row, count), false);
			} else {
				Assert.assertEquals(EqualsValue(row, count), true);
			}

		}

	}

	private static boolean EqualsValue(WebElement row, int count) {

		// (".different>td:nth-child(2)")

		String buf = row.findElement(By.xpath(".//td[2]")).getText();
		for (int i = 1; i < count; i++) {
			String value = row.findElement(By.xpath(".//td[" + (2 + i) + "]"))
					.getText();
			if (!buf.equals(value)) {
				return false;

			} else if (buf.equals(value))
				return true;

		}
		return false;
	}

}

