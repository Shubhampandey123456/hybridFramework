package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.ContactUI;

public class ContactPOM extends ContactUI {

	WebDriver driver;


	public ContactPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement contactClick()
	{
		return driver.findElement(ContactClick);
	}

	public WebElement Nameclick()
	{
		return driver.findElement(naam);
	}

	public WebElement Emailclick()
	{
		return driver.findElement(mail);
	}

	
	public WebElement Msgclick()
	{
		return driver.findElement(msg);
	}

	
	public WebElement sendclick()
	{
		return driver.findElement(sbmit);
	}



}
