package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.LatestProductUI;

public class LatestProductPOM extends LatestProductUI{
	
	public WebDriver driver;
	
	public LatestProductPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement NewClick()
	{
		return driver.findElement(NewProduct);
	}
	
	public WebElement Latest()
	{
		return driver.findElement(AllProduct);
	}
	
//	public WebElement Titleval()
//	{
//		return driver.findElement(Late);
//	}
//	
//	public WebElement Para()
//	{
//		return driver.findElement(paragraph);
//	}

}
