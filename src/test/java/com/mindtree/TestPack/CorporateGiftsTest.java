package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.CorporateGiftsPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class CorporateGiftsTest extends Base {
	
	public static Logger log=Logger.getLogger(Base.class.getName());
	
	
	@BeforeMethod
	public void beforeExecution() throws ReusableComponentException
	{
		
		try {
			driver=setthings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ReusableComponentException("driver not found");
		}
		log.info(driver.getTitle());
		driver.get(prop.getProperty("url"));
		log.info(driver.getTitle());
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority=7)
	public void CorporateGiftsTestMethod() throws IOException, InterruptedException
	{
		test= report.startTest("Blog's Quote");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		CorporateGiftsPOM bp=new CorporateGiftsPOM(driver);
		log.info("Class Instantiated");
		
		bp.corporateclick().click();
		log.info("Clicked on Corporate Gifts");
		test.log(LogStatus.PASS,"Clicked on Corporate Gifts");
		
		WebElement ele=bp.Firstnameclick();
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys("Shubham Pandey");
		log.info("Name Entered");
		test.log(LogStatus.PASS,"Name Entered");
		
		bp.MailClick().sendKeys("Jaybholey@gmail.com");
		log.info("Mail Entered");
		test.log(LogStatus.PASS,"Mail Entered");
		
		bp.PhoneClick().sendKeys("23");
		log.info("Here is Bug Because Site is taking invalid Phone Number");
		test.log(LogStatus.PASS,"Here is Bug Because Site is taking invalid Phone Number");
		
		bp.MessaeClick().sendKeys("I want some Corporate Gifts");
		log.info("Message Enterd");
		test.log(LogStatus.PASS,"Message Enterd");
		
		bp.Submitclick().click();
		log.info("Submitted");
		test.log(LogStatus.PASS,"Submitted");
				
	
		ExtentLogUtilities.pass(driver, test, "Task Done", log);
		log.info("Operation done");	
		
		

	}
	
	@AfterMethod
	public void close()
	{
		report.endTest(test);
		report.flush();
		driver.close();
		log.info("driver closed");
	}

}
