package com.fiserv.test;

import com.fiserv.base.DriverBase;
import com.fiserv.pageobjects.SearchHomePage;
import com.fiserv.utility.TestProperties;
import org.testng.*;
import org.testng.annotations.Test;

public class SearchEngineTest extends DriverBase {
    

   @Test
   public void verify_first_result_on_search_engine() throws Exception {
       String searchText= TestProperties.getProperty("searchParameter");
       String expectedSearchResult=TestProperties.getProperty("expectedResult");
       SearchHomePage searchHomePage=new SearchHomePage(driver);
       searchHomePage.openSearchHomePage();
       log.info("Searching Text : "+searchText);
       searchHomePage.enterSearchText(searchText);
       searchHomePage.clickSearchButton();
       String actualSearchResult=searchHomePage.getFirstSearchResult();
       log.info("Actual Search Result  : "+actualSearchResult);
       log.info("Expected Search Result  : "+expectedSearchResult);
       Assert.assertEquals(actualSearchResult,expectedSearchResult);


   }

}
