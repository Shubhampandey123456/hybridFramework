package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.CorporateGiftsUI;

public class CorporateGiftsPOM extends CorporateGiftsUI{

	public WebDriver driver;
	
	public CorporateGiftsPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement corporateclick()
	{
		return driver.findElement(corporate);
	}
	
	public WebElement Firstnameclick()
	{
		return driver.findElement(FName);
	}
	
	public WebElement MailClick()
	{
		return driver.findElement(Mailid);
	}
	
	public WebElement PhoneClick()
	{
		return driver.findElement(PhoneNo);
	}
	
	public WebElement MessaeClick()
	{
		return driver.findElement(Messag);
	}
	
	public WebElement Submitclick()
	{
		return driver.findElement(Done);
	}
	
	
	

}
