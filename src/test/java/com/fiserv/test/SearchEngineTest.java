package com.fiserv.test;

import com.fiserv.base.DriverBase;
import com.fiserv.pageobjects.SearchHomePage;
import org.testng.*;
import org.testng.annotations.Test;

public class SearchEngineTest extends DriverBase {

    private String expectedSearchResult="Fiserv: Financial Services Technology, Mobile Banking ...\n" +"https://www.fiserv.com";

   @Test
   public void verify_first_result_on_search_engine() throws Exception {
       String searchText="fiserv";
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
