package com.mindtree.UI;

import org.openqa.selenium.By;

public class ContactUI {
	
	public static By ContactClick=By.xpath("//ul[@class='footertoggle']/li[1]/a");
	public static By naam=By.xpath("//input[@name='contact[name]']");
	public static By mail=By.xpath("//input[@name='contact[email]']");
	public static By msg=By.xpath("//textarea[@class='input-full']");
	public static By sbmit=By.xpath("//button[@class='btn']");

}
