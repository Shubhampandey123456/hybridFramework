package com.mindtree.POMPack;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mindtree.UI.CartUI;

public class CartPOM extends CartUI{

	public WebDriver driver;
	
	public CartPOM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement clickProduct()
	{
		return driver.findElement(product);
	}
	
	public WebElement WishList()
	{
		return driver.findElement(wish);
	}
	
	public WebElement AddCart()
	{
		return driver.findElement(ACart);
	}
	
	public WebElement CheckOut()
	{
		return driver.findElement(check);
	}
	
	public WebElement Texture()
	{
		return driver.findElement(text);
	}
	
	public WebElement CountryCodeClick()
	{
		return driver.findElement(countryCode);
	}
	
	public WebElement phonenoClick()
	{
		return driver.findElement(PhonNo);
	}
	
	public WebElement SubmitClick()
	{
		return driver.findElement(submit);
	}
	
	public WebElement mailclick()
	{
		return driver.findElement(mail);
	}
	
	public WebElement FnameClick()
	{
		return driver.findElement(Fname);
	}
	
	public WebElement LnameClick()
	{
		return driver.findElement(Lname);
	}
	
	public WebElement addressclick()
	{
		return driver.findElement(address);
	}
	
	public WebElement landmarkclick()
	{
		return driver.findElement(landmark);
	}
	
	public WebElement cityclick()
	{
		return driver.findElement(City);
	}
	
	public Select countryclick()
	{
		Select sel=new Select(driver.findElement(country));
		return sel;
	}
	
	public Select stateclick()
	{
		
		Select sel=new Select(driver.findElement(state));
		return sel;
	}
	
	public WebElement pinclick()
	{
		return driver.findElement(Pin);
	}
	
	public WebElement mobileclick()
	{
		return driver.findElement(Mobile);
	}
	
	public WebElement continueclick()
	{
		return driver.findElement(cont);
	}
	
	public WebElement PaymentClick()
	{
		return driver.findElement(Payment);
	}
	
	
}
