package com.Genericmethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Reporting.Reporting;

public class GenericMethods extends Reporting {
	
	public static WebDriver driver;
	
	public static String currentClass;
	
	public static boolean launchBrowser(String browser,String url)
	{
		boolean status=true;
		
		try {
		
		
		switch(browser.toLowerCase())
		{
		
		case "ff":
			driver=new FirefoxDriver();
		break;
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			break;
		
		
		}
		
		driver.navigate().to(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		
		logStatus("Pass", "Browser is launched sucessfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
			logStatus("fail", "Browser is not launched sucessfully");
		}
		
		return status;
	}
	
	public static boolean clickAndSendData(WebElement element,String data)
	{
		boolean status=true;
		try
		{
			element.click();
			element.clear();
			element.sendKeys(data);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public static boolean clickElement(WebElement element)
	{
		boolean status=true;
		try
		{
			element.click();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	
	public static boolean selectOption(WebElement element,String optionvalue)
	{
		boolean status=true;
		try
		{
			Select select=new Select(element);
			select.selectByVisibleText(optionvalue);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
		boolean status=true;
		try
		{
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click(element).build().perform();
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	public static boolean forceClick(WebElement element)
	{
		boolean status=true;
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			status=false;
		}
		return status;
	}
	
	
	
	
}
