package com.fiserv.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fiserv.base.ObjectRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventSetup extends ObjectRepository {

    public static ExtentReports setupExtentReport() {

        SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy HH-mm-ss");
        Date date=new Date();
        String act_date=format.format(date);
        String report_path=System.getProperty("user.dir")+"/src/test/reports/html/Execution_Report_"+act_date+".html";

        ExtentSparkReporter report=new ExtentSparkReporter(report_path);
        extent=new ExtentReports();
        extent.attachReporter(report);

        report.config().setDocumentTitle("Title");
        report.config().setTheme(Theme.DARK);
        report.config().setReportName("ReportName");

        return extent;
    }



}
