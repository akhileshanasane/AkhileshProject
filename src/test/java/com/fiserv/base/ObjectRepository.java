package com.fiserv.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class ObjectRepository {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Logger log = Logger.getLogger(DriverBase.class);

}
