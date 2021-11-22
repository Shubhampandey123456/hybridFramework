package com.mindtree.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UI.AccountUI;

public class AccountPOM extends AccountUI {

	WebDriver driver;
	
	
	public AccountPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement SignIn()
	{
		return driver.findElement(sign);
	}
	
	public WebElement nam()
	{
		return driver.findElement(name);
	}
	
	public WebElement pssw()
	{
		return driver.findElement(pass);
	}
	
	public WebElement done()
	{
		return driver.findElement(sbmit);
	}
	

}
