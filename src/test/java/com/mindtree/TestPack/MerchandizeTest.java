package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.MerchandizePOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class MerchandizeTest extends Base {
	
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
	@Test(priority=2)
	public void MerchandizeTestMethod() throws IOException, InterruptedException
	{
		
		test= report.startTest("Merchandize Page");
		MerchandizePOM mp=new MerchandizePOM(driver);
		log.info("Class Instantiated");
		
		Actions act=new Actions(driver);
		log.info("Hovering over a Dynamaic Dropdown");
		WebElement ele=mp.MerchandizeClick();
		act.moveToElement(ele).perform();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ele1=mp.DisneyMerchClick();
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		ele1.click();
		log.info("Value Selected in dynamic DropDown");
		test.log(LogStatus.PASS,"Value Selected in dynamic DropDown");
		log.info(driver.getTitle());
		
		mp.DropdownClick().selectByIndex(3);
		log.info("Value selected in Sort dropdown");
		
		WebElement ele2=mp.ValidateProduct();
		if(ele2.isDisplayed())
		{
			System.out.println("Expected Result Found");
			log.info("Expected Value Matched");
		}
		
		test.log(LogStatus.PASS,"Merchandize Products");

		ExtentLogUtilities.pass(driver, test, "Task Done", log);
		
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
