package com.ApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Genericmethods.GenericMethods;

public class HomePage extends GenericMethods{
	
	//************************ WebElements *******************
	
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Sign in']")
	
	public static WebElement Lnk_Signin;
	
	
	
	//********************* Methods **********************************
	
	public static boolean click_SignIn()
	{
		boolean status=true;
		
		
		try
		{
			status=hoverAndClick(Lnk_Signin );
			
			if(status)
			{
				logStatus("pass", "Sign in link is clicked sucessfully");
			}else
			{
				logStatus("fail", "Sign in link is not clicked sucessfully");
			}
			
			
			
		}catch(Exception e)
		{
			status=false;
			System.out.println(e.getMessage());
			
		}
		return status;
	}
	
	
	
	

}
