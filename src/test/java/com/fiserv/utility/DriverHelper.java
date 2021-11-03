package com.fiserv.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverHelper{

    public static WebDriver getDriverByBrowser(String browser) throws Exception
    {

        WebDriver driver;
        switch (browser.toUpperCase())
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver=new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Invalid Browser Name");
        }

        return driver;

    }
}
