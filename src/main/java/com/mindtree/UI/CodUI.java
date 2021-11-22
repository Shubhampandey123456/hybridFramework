package com.mindtree.UI;

import org.openqa.selenium.By;

public class CodUI {
	
	public static By product=By.xpath("//div[@class='grid-product__meta'] //div[contains(text(), 'Bulb')]");
	public static By pincode=By.xpath("//div[@id='cod-cheker']/input");
	public static By CodA=By.xpath("//div[@id='cod-cheker']/h6");
	public static By submit=By.xpath("//div[@id='cod-cheker']/button");
	public static By finaltext=By.xpath("//p[contains(text(), 'Cash')]");
}
