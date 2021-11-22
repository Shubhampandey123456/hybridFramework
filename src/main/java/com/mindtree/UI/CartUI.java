package com.mindtree.UI;

import org.openqa.selenium.By;

public class CartUI {
	
	public static By product=By.xpath("//div[@class='grid-product__meta']");
	public static By wish=By.xpath("//button[@aria-label='Add to Wishlist']");
	public static By ACart=By.xpath("//button[@name='add']");
	public static By check=By.xpath("//button[@name='checkout']/span");
	public static By text=By.xpath("//p[@class='wa-optin-widget-title']");
	public static By countryCode=By.id("wa-optin-country-code");
	public static By PhonNo=By.id("wa-optin-phone-number");
	public static By submit=By.id("wa-optin-widget-confirm-btn");
	public static By mail=By.xpath("//input[@placeholder='Email']");
	public static By Fname=By.xpath("//input[@placeholder='First name']");
	public static By Lname=By.xpath("//input[@placeholder='Last name']");
	public static By address=By.xpath("//input[@placeholder='Address']");
	public static By landmark=By.xpath("//input[@placeholder='Landmark*']");
	public static By City=By.xpath("//input[@placeholder='City']");
	public static By country=By.xpath("//select[@placeholder='Country/region']");
	public static By state=By.xpath("//select[@placeholder='State']");
	public static By Pin=By.xpath("//input[@placeholder='PIN code']");
	public static By Mobile=By.xpath("//input[@placeholder='Phone']");
	public static By cont=By.id("continue_button");
	public static By Payment=By.xpath("//div[@class=\"step__footer\"]/button/span");
	
	

}
