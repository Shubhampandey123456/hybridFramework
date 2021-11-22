package com.mindtree.TestPack;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mindtree.POMPack.OfficialMerchantPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class OfficialMerchantTest extends Base {
	
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
	@Test(priority=3)
	public void CheckOfficialMerchant() throws IOException, InterruptedException
	{
		
		test= report.startTest("Official Merchant");
		

		OfficialMerchantPOM omp=new OfficialMerchantPOM(driver);
		log.info("Class Instantiated");

		WebElement ele=omp.Merchant();

		int n=ele.findElements(By.tagName("a")).size();
		log.info("TOtal number of links are:"+n);

		for(int i=1;i<n;i++)
		{
			String keytab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			ele.findElements(By.tagName("a")).get(i).sendKeys(keytab);
			
		}
		
		log.info(driver.getTitle());
		 //getting all tabs title
        Set<String> ab=driver.getWindowHandles();
        Iterator<String> bc=ab.iterator();
      
        log.info("Handling Multiple Windows");
        String parentid=bc.next();
        String childid=bc.next();
        String childid1=bc.next();
        String childid2=bc.next();
        String childid3=bc.next();
        
        log.info("Parent Window");
        driver.switchTo().window(parentid);
        String str1=omp.ParentTextClick().getText();
        log.info("Parent Window Opened");
        Assert.assertEquals(str1, "What's New");
        log.info("Parent window Text Asserted");
        test.log(LogStatus.PASS,"Parent window Text Asserted");
        
        log.info("Child Window1");
        driver.switchTo().window(childid);
        log.info("Child1 Window Opened");
        WebElement ele1=omp.Child1ProductClick();
        WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		if(ele1.isDisplayed())
		{
			log.info("Product displayed in "+driver.getTitle()+" Child Window");
			test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		}
				
		log.info("Child Window2");
        driver.switchTo().window(childid1);
        log.info("2Child Window Opened");
        WebElement ele2=omp.Child2ProductClick();
        WebDriverWait wait2 = new WebDriverWait(driver, 15);
		wait2.until(ExpectedConditions.elementToBeClickable(ele2));
		if(ele2.isDisplayed())
		{
			log.info("Product displayed in "+driver.getTitle()+" Child Window");
			test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		}
		
		log.info("Child Window3");
        driver.switchTo().window(childid2);
        log.info("3Child Window Opened");
        WebElement ele3=omp.Child3ProductClick();
        WebDriverWait wait3 = new WebDriverWait(driver, 15);
		wait3.until(ExpectedConditions.elementToBeClickable(ele3));
		if(ele3.isDisplayed())
		{
			log.info("Product displayed in "+driver.getTitle()+" Child Window");
			test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		}
		
		log.info("Child Window3");
        driver.switchTo().window(childid3);
        log.info("4Child Window Opened");
        WebElement ele4=omp.Child4ProductClick();
        WebDriverWait wait4 = new WebDriverWait(driver, 15);
		wait4.until(ExpectedConditions.elementToBeClickable(ele4));
		if(ele4.isDisplayed())
		{
			log.info("Product displayed in "+driver.getTitle()+" Child Window");
			test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		}
		
		test.log(LogStatus.PASS,"All links Validated in Official Merchant Section");
		ExtentLogUtilities.pass(driver, test, "All links Validated", log);


	}


	@AfterMethod
	public void close()
	{
		report.endTest(test);
		report.flush();
		driver.close();
		driver.quit();
		log.info("driver closed");
	}
}
