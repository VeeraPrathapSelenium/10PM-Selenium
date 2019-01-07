package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ApplicationPages.HomePage;
import com.Genericmethods.GenericMethods;

public class Tc_01_ValidateSignIn extends GenericMethods{
	
	@Test
	public static void validate_Signin()
	{
		String url="http://automationpractice.com/index.php";
		launchBrowser("chrome",url);
		
		HomePage page=PageFactory.initElements(driver, HomePage.class);
		
		page.click_SignIn();
		
		
		
		
	}
	

}
