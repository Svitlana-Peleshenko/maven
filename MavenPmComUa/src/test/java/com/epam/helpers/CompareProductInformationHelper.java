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

import com.epam.components.Catalog;
import com.epam.components.ComparativeTable;
import com.epam.components.Header;
import com.epam.components.InformationAboutProduct;
import com.epam.components.NavigateMenu;
import com.epam.components.NavigateMenuProductInformation;
import com.epam.components.PriceList;

public class CompareProductInformationHelper {
//task2
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
			
			CompareInformation(table, informationAboutProduct, numElement,compareLine);
			menu.goToCatalog();
			numElement++;
		}

	}

	public static void CompareInformation(ComparativeTable table,
			Map<String, String> informationAboutProduct, int numElement,Header compareLine) {
		compareLine.goToCompareTable();
	    for(String title: informationAboutProduct.keySet()){
	    	System.out.println(title);
			for (int k = 0; k < table.getCompareRows().size(); k++) {
				String titleFromComTable = table.getCompareRows().get(k)
						.findElement(By.xpath(".//td[1]")).getText();
				
				if (titleFromComTable.equals(title)) {
					String val = informationAboutProduct.get(title);
					String valFromComTable = table.getCompareRows()
							.get(k)
							.findElement(
									By.xpath(".//td[" + (1 + numElement) + "]"))
							.getText();
					Assert.assertTrue(val.compareToIgnoreCase(valFromComTable) == 0);
				}

			}
	    		
	    }
		 
	}
//task 6
	
	public static void CheckDescriptions(Catalog catalog,InformationAboutProduct information, NavigateMenuProductInformation menu ,Double counts ) {
		int countOfProductions = counts.intValue();	
		for(int i=0; i<countOfProductions;i++){
		    String[] description=catalog.getDescription(i);
			catalog.GoToInfAboutProd(i);
			Map<String,String> allCharacteristics = information.getCharacteristicsMap();
			for(int j=1;j<description.length;j++){
				for(Entry<String,String> entry: allCharacteristics.entrySet()) {
				if((description[j].indexOf(entry.getKey()) != -1)  || (description[j].indexOf(entry.getValue()) != -1)) {
				
					Assert.assertTrue((description[j].indexOf(entry.getKey()) != -1)  || (description[j].indexOf(entry.getValue()) != -1));
					
					}  
				}
			}
			
			menu.goToCatalog();
		}
		
	}
	
		public static void CheckHref(Catalog catalog, NavigateMenu navigateMenu, Header header, PriceList priceList, Double counts) {
			int countOfProductions = counts.intValue();
			List<String> listTitles= new ArrayList<>();
			List<String> listHrefs= new ArrayList<>();
			listTitles=catalog.SaveTitles(countOfProductions);
			listHrefs=catalog.SaveHref(countOfProductions);
			navigateMenu.goToPriceList();
			for(int i=0; i<countOfProductions;i++){
				header.TypeRequest(listTitles.get(i));
				header.Search();
				for(int j=0;j<priceList.priceListDescriptions.size();j++){
					
					Assert.assertEquals(priceList.getHrefOfDescription(j), listHrefs.get(i));
					
				}
				header.ClearLabel();		
			}
			
			
			
		
	}
		
	

}



