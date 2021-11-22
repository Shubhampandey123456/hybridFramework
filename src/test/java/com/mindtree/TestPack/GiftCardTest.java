package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.GiftCardPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class GiftCardTest extends Base {

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

	@Test(priority=4)
	public void GiftCardTestMethod() throws IOException, InterruptedException
	{

		test= report.startTest("Gift Cards");

		GiftCardPOM tv=new GiftCardPOM(driver);
		log.info("Class Instantiated");

		tv.GiftClick().click();
		log.info("Clicked on GiftIcon");

		tv.PriceClick().click();
		log.info("Clicked on Price");

		for(int i=0;i<4;i++)
		{
			tv.AddClick().click();
		}
		log.info("Clicked on pluss Button");

		tv.AddCartClick().click();
		log.info("Clicked on addcart");

		tv.continuclick().click();
		log.info("Clicked on continue shoping");

		String str=tv.validateClick().getText();
		System.out.println(str);
		log.info("available phrase: "+str);

		test.log(LogStatus.FAIL,"Gift not Available");

		ExtentLogUtilities.fail(driver, test, "Task Done", log);


		Assert.assertEquals(str, "Shubham");
		log.info("Value mismatched");




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
