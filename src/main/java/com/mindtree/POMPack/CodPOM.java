package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.CodUI;

public class CodPOM extends CodUI {
	
	WebDriver driver;
	
	
	public CodPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement productcl()
	{
		return driver.findElement(product);
	}
	
	public WebElement Coaclick()
	{
		return driver.findElement(CodA);
	}
	
	public WebElement pin()
	{
		return driver.findElement(pincode);
	}
	
	public WebElement submitIt()
	{
		return driver.findElement(submit);
	}
	
	public WebElement finals()
	{
		return driver.findElement(finaltext);
	} 
	

}
