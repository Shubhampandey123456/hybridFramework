package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.UI.MerchandizeUI;

public class MerchandizePOM extends MerchandizeUI{
	
	WebDriver driver;

	public MerchandizePOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement MerchandizeClick()
	{
		return driver.findElement(Merhandise);
	}
	
	public WebElement DisneyMerchClick()
	{
		return driver.findElement(DisneyMerch);
	}
	
	public Select DropdownClick()
	{
		Select sel=new Select(driver.findElement(dropdon));
		return sel;
	}
	
	public WebElement ValidateProduct()
	{
		return driver.findElement(iconpro);
	}


}
