package com.TestNgListners;

import java.io.IOException;

import org.omg.CORBA.portable.InvokeHandler;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ExcelReading.ReadExcel;
import com.Genericmethods.GenericMethods;
import com.Reporting.Reporting;

public class Listners implements ITestListener,IInvokedMethodListener{

	

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("After Suite");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		try {
			
			String path=System.getProperty("user.dir")+"\\TestData\\Testdata.xlsx";
					
			ReadExcel.loadExcel(path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult test) {
		
		GenericMethods.currentClass=test.getInstanceName().substring(test.getInstanceName().lastIndexOf(".")+1);
		
		Reporting.intializeReport(GenericMethods.currentClass);
			
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		
		
	}
	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		Reporting.endReport();
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		Reporting.startReport(arg0.getTestMethod().getMethodName());
		
	}

}
