package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.LatestProductPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class LatestProductTest extends Base {

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

	@Test(priority=5)
	public void LatestProductTestMethod() throws IOException, InterruptedException
	{
		test= report.startTest("Latest product");
		
		LatestProductPOM lpm=new LatestProductPOM(driver);
		log.info("Class Instantiated");

		lpm.NewClick().click();
		
		WebElement ele1=lpm.Latest();
		int n=ele1.findElements(By.className("grid-product__meta")).size();
		System.out.println("Product availables:"+n);
		test.log(LogStatus.PASS,"Number of Product availables:"+n);
		log.info("Number of Product availables:"+n);
		String str = null;
		for(int i=0;i<n;i++)
		{
			str=ele1.findElements(By.className("grid-product__meta")).get(i).getText();
			System.out.println(str);
			log.info("Available products:"+str);
			
		}
		
		test.log(LogStatus.PASS,"All products seen");

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
