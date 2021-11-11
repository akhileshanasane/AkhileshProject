package com.fiserv.pageobjects;

import com.fiserv.base.DriverBase;
import com.fiserv.utility.EnvironmentProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHomePage extends DriverBase {
    private  WebDriver driver;
    public SearchHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(xpath="//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath="//input[@value='Google Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@id='search']//following::a[1]")
    public WebElement firstSearchResult;

    public void openSearchHomePage(String pageUrl) throws Exception {
        log.info("Opening Page URL :"+pageUrl);
        driver.get(pageUrl);

    }

    public  void enterSearchText(String searchText)
    {
        searchBox.sendKeys(searchText);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public String getFirstSearchResult()
    {
       return firstSearchResult.getText();
    }


}
