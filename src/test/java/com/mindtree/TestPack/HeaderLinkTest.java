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

import com.mindtree.POMPack.HeaderLinks;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class HeaderLinkTest extends Base {

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
	@Test(priority=6)
	public void HeaderLinkTestMethod() throws IOException, InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		test= report.startTest("Checking Header Links");

		HeaderLinks hl=new HeaderLinks(driver);
		log.info("Class Instatiated");

		WebElement con=hl.header();
		int n=con.findElements(By.tagName("a")).size();
		System.out.println("Number of links present in the page are:"+n);
		log.info("Number of links present in the page are"+n);
		test.log(LogStatus.PASS,"Number of links present in the page are"+n);

		//clicking on the link separately
		for(int i=1;i<=5;i++)
		{
			String keytab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			con.findElements(By.tagName("a")).get(i).sendKeys(keytab);
			
		}
		log.info("All Links without dropdown are opened");

		Set<String> ab=driver.getWindowHandles();
		Iterator<String> bc=ab.iterator();

		log.info("Handling Multiple Windows");
		String parentid=bc.next();
		String childid=bc.next();
		String childid1=bc.next();
		String childid2=bc.next();
		String childid3=bc.next();
		String childid4=bc.next();

		log.info("Parent Window");
		driver.switchTo().window(parentid); 
		log.info("Switched to Parent Window");
		Assert.assertTrue(hl.header().isDisplayed());
		log.info("Header Section Displayed");
		test.log(LogStatus.PASS,"Header Section Displayed");

		log.info("Child Window1");
		driver.switchTo().window(childid);
		log.info("Switched to Child1 Window");
		WebElement ele1=hl.Child1ProductClick();
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		Assert.assertTrue(ele1.isDisplayed());
		log.info("Product displayed in "+driver.getTitle()+" Child Window");
		test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());

		log.info("Child Window2");
		driver.switchTo().window(childid1);
		log.info("Switched to Child2 Window");
		WebElement ele2=hl.child2productClick();
		wait.until(ExpectedConditions.elementToBeClickable(ele2));
		Assert.assertTrue(ele2.isDisplayed());
		log.info("Product displayed in "+driver.getTitle()+" Child Window");
		test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		
		log.info("Child Window3");
		driver.switchTo().window(childid2);
		log.info("Switched to Child3 Window");
		WebElement ele3=hl.child3product();
		wait.until(ExpectedConditions.elementToBeClickable(ele3));
		Assert.assertTrue(ele3.isDisplayed());
		log.info("Product displayed in "+driver.getTitle()+" Child Window");
		test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		
		log.info("Child Window4");
		driver.switchTo().window(childid3);
		log.info("Switched to Child4 Window");
		WebElement ele4=hl.child4product();
		wait.until(ExpectedConditions.elementToBeClickable(ele4));
		Assert.assertTrue(ele4.isDisplayed());
		log.info("Product displayed in "+driver.getTitle()+" Child Window");
		test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		

		log.info("Child Window5");
		driver.switchTo().window(childid4);
		log.info("Switched to Child5 Window");
		WebElement ele5=hl.child5product();
		wait.until(ExpectedConditions.elementToBeClickable(ele5));
		Assert.assertTrue(ele5.isDisplayed());
		log.info("Product displayed in "+driver.getTitle()+" Child Window");
		test.log(LogStatus.PASS,"Product displayed in "+driver.getTitle());
		


		test.log(LogStatus.PASS,"All window seen");

		ExtentLogUtilities.pass(driver, test, "All Header Links Opened", log);

	}

		@AfterMethod
		public void close()
		{
			report.endTest(test);
			report.flush();
			log.info("driver closed");
			driver.close();
			driver.quit();
			log.info("driver quit");
		}
}
