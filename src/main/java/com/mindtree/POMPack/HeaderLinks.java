package com.mindtree.POMPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.HeaderLinkUI;

public class HeaderLinks extends HeaderLinkUI {
	WebDriver driver;
	
	public HeaderLinks(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement header()
	{
		return driver.findElement(head);
	}
	
	public WebElement Child1ProductClick()
	{
		return driver.findElement(Child1Product);
	}
	
	public WebElement child2productClick()
	{
		return driver.findElement(child2product);
	}
	
	public WebElement child3product()
	{
		return driver.findElement(child3product);
	}
	
	public WebElement child4product()
	{
		return driver.findElement(child4product);
	}
	
	public WebElement child5product()
	{
		return driver.findElement(child5product);
	}
	

}
