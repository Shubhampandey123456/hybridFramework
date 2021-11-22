package com.mindtree.POMPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.GiftCardUi;

public class GiftCardPOM extends GiftCardUi{
	
	public WebDriver driver;
	
	
	public GiftCardPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement GiftClick()
	{
		return driver.findElement(GiftIcon);
	}
	
	public WebElement PriceClick()
	{
		return driver.findElement(price);
	}
	
	public WebElement AddClick()
	{
		return driver.findElement(add);
	}
	
	public WebElement AddCartClick()
	{
		return driver.findElement(Addin);
	}
	
	public WebElement continuclick()
	{
		return driver.findElement(continu);
	}
	
	public WebElement validateClick()
	{
		return driver.findElement(Validate);
	}
	
	

}
