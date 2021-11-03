package com.fiserv.listners;

import com.aventstack.extentreports.Status;
import com.fiserv.base.ObjectRepository;
import com.fiserv.utility.EventSetup;
import com.fiserv.utility.TestUtility;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListeners extends ObjectRepository implements ITestListener, ISuiteListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        //Before Every Test
        log.info("Test Started : "+iTestResult.getMethod().getMethodName());
        test=extent.createTest(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test Passed : "+iTestResult.getMethod().getMethodName());
        test.log(Status.PASS,"Test Case : "+iTestResult.getMethod().getMethodName());
        TestUtility.takeScreenShot(iTestResult.getMethod().getMethodName(),System.getProperty("user.dir")+"/src/test/reports/screenshotpass/");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test Failed : "+iTestResult.getMethod().getMethodName());
        test.log(Status.FAIL,"Test Case : "+iTestResult.getMethod().getMethodName());
        test.log(Status.FAIL, iTestResult.getThrowable());
        TestUtility.takeScreenShot(iTestResult.getMethod().getMethodName(),System.getProperty("user.dir")+"/src/test/reports/screenshotfail/");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test Skipped : "+iTestResult.getMethod().getMethodName());
        test.log(Status.SKIP,"Test Case : "+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Test Partially Failed : "+iTestResult.getMethod().getMethodName());
        test.log(Status.FAIL,"Test Case:"+iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
       //Setup Report Method Call
        log.info("Test Context Started : "+iTestContext.getName());
        extent= EventSetup.setupExtentReport();

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //Close Extent
        log.info("Test Context Finished : "+iTestContext.getName());
        extent.flush();

    }

    @Override
    public void onStart(ISuite iSuite) {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");
        log.info("============================ Suite Started : "+iSuite.getName()+" ============================");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info("============================ Suite Finished : "+iSuite.getName()+" ============================");
    }
}
