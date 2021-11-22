package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.OfficialMerchantUI;

public class OfficialMerchantPOM extends OfficialMerchantUI {
	
	public WebDriver driver;
	

	public OfficialMerchantPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement Merchant()
	{
		return driver.findElement(officialMer);
	}
	
	public WebElement ParentTextClick()
	{
		return driver.findElement(text);
	}
	
	public WebElement Child1ProductClick()
	{
		return driver.findElement(Product);
	}
	
	public WebElement Child2ProductClick()
	{
		return driver.findElement(Product1);
	}
	
	public WebElement Child3ProductClick()
	{
		return driver.findElement(Product2);
	}
	
	public WebElement Child4ProductClick()
	{
		return driver.findElement(Product3);
	}
	

}
