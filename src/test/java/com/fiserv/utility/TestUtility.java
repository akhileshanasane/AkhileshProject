package com.fiserv.utility;

import com.fiserv.base.DriverBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtility extends DriverBase {

    public static void takeScreenShot(String testCaseName,String path)
    {
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
        Date date=new Date();
        String act_date=format.format(date);
        String screenshot_path=path+testCaseName+"_Execution_Report_"+act_date+".jpeg";
        File dest=new File(screenshot_path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            log.error("Error in Capturing Screenshot");
            e.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(screenshot_path,"Test case failure screenshot");
        } catch (IOException e) {
            log.error("Error in Adding Screenshot");
            e.printStackTrace();
        }
    }

}
