package com.mindtree.UI;

import org.openqa.selenium.By;

public class CorporateGiftsUI {
	
	public static By corporate=By.xpath("//div[@id='myheader']/div[1]/div/div/ul/li[1]");
	public static By FName=By.id("contactFormName");
	public static By Mailid=By.id("contactFormEmail");
	public static By PhoneNo=By.id("contactFormPhone");
	public static By Messag=By.id("contactFormMessage");
	public static By Done=By.xpath("//input[@value='submit']");
}
