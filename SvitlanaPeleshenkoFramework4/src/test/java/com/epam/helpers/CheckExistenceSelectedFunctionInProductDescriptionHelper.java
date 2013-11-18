package com.epam.helpers;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.epam.components.Catalog;
import com.epam.components.Filter;
import com.epam.components.NavigateMenu;

public class CheckExistenceSelectedFunctionInProductDescriptionHelper {

	public static void CheckFunctionsFilter(NavigateMenu menu, Catalog catalog,
			Filter filter, String function, WebDriver driver) {
		Reporter.log("Check entered   title of function in exel file.");
		if (filter.ChooseFunction(function) == false) {
			Reporter.log("  Title of function isn't correct.");
			System.out.println("Function entered into xls file doesn't exist.");
		}

		else {
			Reporter.log("Title of function is correct.<br>");
			do {
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

}
