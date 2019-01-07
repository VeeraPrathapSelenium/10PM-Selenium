package com.Reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ExcelReading.ReadExcel;
import com.Genericmethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends ReadExcel {
	
	


	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	
	// step 1: intialize the reports
	
	
	public static void intializeReport(String testcasename)
	{
	extent=new ExtentReports(check_CreateResultFolder()+"\\"+testcasename+".html")	;
	
	extent.addSystemInfo("Sprint # ","Sprint 1")
	.addSystemInfo("Cycle #"," 01")
	.addSystemInfo("Environment","QA");
	
	}
	// Step 2:Start the report
	
	public static void startReport(String testcase)
	{
		test=extent.startTest(testcase);
	}
	
	// step 3: Log the status of each test case
	
	public static void logStatus(String status,String discription)
	{
		switch(status.toLowerCase())
		{
		case "pass":
			test.log(LogStatus.PASS, discription+test.addBase64ScreenShot(getScreenShot()));
			break;
			
		case "fail":
			test.log(LogStatus.FAIL, discription+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "warning":
			test.log(LogStatus.WARNING, discription+test.addBase64ScreenShot(getScreenShot()));
			break;
		}
	}
	
	// step 4:End and publish report
	
	public static void endReport()
	{
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	public static String check_CreateResultFolder()
	{
		Date d=new Date();

		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy");

		System.out.println(sdf.format(d));



		String Resultspath=System.getProperty("user.dir")+"\\Results\\"+sdf.format(d);


		File f=new File(Resultspath);
		if(!f.exists())
		{
			System.out.println("No Folder is exist......creating a new folder");
			f.mkdirs();
		}
		return Resultspath;
	}
	
	
	public static String getScreenShot()
	{
		TakesScreenshot sht=(TakesScreenshot)GenericMethods.driver;
		
		String screenprint=sht.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+screenprint;
		
	}
	

}
