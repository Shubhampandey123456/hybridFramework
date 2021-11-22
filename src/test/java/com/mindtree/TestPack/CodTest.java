package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.CodPOM;

import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class CodTest extends Base{
	
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
	
	@Test(priority=9)
	public void CodCheckMethod() throws IOException, InterruptedException
	{
		
		test= report.startTest("Check if COD is available");
		CodPOM acp=new CodPOM(driver);
		log.info("Class Instantiated");
		
		acp.productcl().click();
		log.info("Clicked on product:");
		test.log(LogStatus.PASS,"Click on the product");
		
		acp.pin().sendKeys("110058");
		log.info("pincode entered:");
		
		String str3=acp.Coaclick().getText();
		System.out.println(str3);
		test.log(LogStatus.PASS, str3);
		
		acp.submitIt().click();
		log.info("Operation done");	
		
		String str2=acp.finals().getText();
		Assert.assertEquals(str2, "Cash on Delivery is available.");
		log.info("Correclty asserted");
		log.info("COD Status is:"+str2);
		test.log(LogStatus.PASS, str2);
		System.out.println("COD Status is:"+str2);
		
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
