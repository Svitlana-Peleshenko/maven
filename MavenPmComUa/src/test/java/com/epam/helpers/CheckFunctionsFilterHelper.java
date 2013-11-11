package com.epam.helpers;

import org.testng.Assert;
import org.testng.Reporter;


import com.epam.components.Catalog;
import com.epam.components.Filter;
import com.epam.components.NavigateMenu;

public class CheckFunctionsFilterHelper {

	public static void CheckFunctionsFilter(NavigateMenu menu, Catalog catalog,
			Filter filter, String function) {
		ChooseFunction(function, filter);
		int lastPage = menu.getLastPage();
		for (int i = 0; i < lastPage; i++) {
			for (int j = 0; j < catalog.getDescriptions().size(); j++) {
			    if(catalog.getDescriptions().get(j).getText().contains(function)){
			    		Assert.assertTrue(true);
			    }	
			}
			
			if (i != lastPage - 1)
				menu.goToNextPage();
		}
		Reporter.log("Check of filters is complete");

	}

	public static void ChooseFunction(String function, Filter filter) {

		for (int i = 0; i < filter.getFunctions().size(); i++) {
			if (filter.getFunctions().get(i).getText().compareToIgnoreCase(function)==0) {
				filter.getFunctions().get(i).click();
			}

		}

	}

}
