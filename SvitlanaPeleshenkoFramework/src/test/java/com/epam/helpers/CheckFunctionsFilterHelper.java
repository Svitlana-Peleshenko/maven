package com.epam.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.epam.components.Catalog;
import com.epam.components.Filter;
import com.epam.components.NavigateMenu;

public class CheckFunctionsFilterHelper {

	public static void CheckFunctionsFilter(NavigateMenu menu, Catalog catalog,
			Filter filter, String function, WebDriver driver) {
		Reporter.log("Check entered   title of function in exel file.");
		if (ChooseFunction(function, filter) == false) {
			Reporter.log("  Title of function isn't correct.");
			System.out.println("Function entered into xls file doesn't exist.");
		}

		else {
			do {
				Reporter.log("Title of function is correct.<br>");
				int i = 0;
				Reporter.log("Loop through on all pages.<br>");
				for (int j = 0; j < catalog.getDescriptions().size(); j++) {
					Reporter.log("Loop through one page.<br>");
					if (catalog.getFullDescription(i).contains(function)) {
						Assert.assertTrue(catalog.getFullDescription(i)
								.contains(function));
						Reporter.log("Check  that title of function contains in product description.<br>");
					}
					i++;
				}
				menu.goToNextPage();
			} while (driver.findElements(By.cssSelector(menu.NEXT)).size() != 0);

		}
		// Reporter.log("Check of filters is complete");

	}

  /* public static boolean ChooseFunction(String function, Filter filter) {
		int i;
		int size = filter.getFunctions().size();

		for (i = 0; i < size; i++) {
			Reporter.log("Find the function which title equals entered function.<br>");
			if (filter.getFunction(i).compareToIgnoreCase(function) == 0) {
				filter.ClickOnFunctionLink(i);
				Reporter.log("Product search with the specified function.<br>");
				return true;
			}
		}
		return false;

	}*/
	
	
	
	public static boolean ChooseFunction(String function, Filter filter) {

		Reporter.log("Find the function which title equals entered function.<br>");
		WebElement elem = filter.getPanelCornerCriterial().findElement(
				By.linkText(function));
		elem.click();
		Reporter.log("Product search with the specified function.<br>");
		return true;

	}

}
