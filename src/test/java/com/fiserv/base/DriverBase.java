package com.fiserv.base;

import com.fiserv.utility.DriverHelper;
import com.fiserv.utility.EnvironmentProperties;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class DriverBase extends ObjectRepository{


    @BeforeSuite
    public void initialize_browser() throws Exception {

        driver= DriverHelper.getDriverByBrowser(EnvironmentProperties.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Integer.valueOf(EnvironmentProperties.getProperty("implicitTimeOut")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Driver Initialized : "+EnvironmentProperties.getProperty("browser"));

    }

    @AfterSuite
    public void tearDown() {
       log.info("Closing Browser");
       driver.quit();


    }
}
