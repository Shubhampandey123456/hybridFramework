package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.POMPack.CartPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.exception.UtilityException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExcelSheetRead;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;


public class CartTest extends Base {
	

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
	@Test(dataProvider="getvalue2")
	public void CartTestMethod(String Mail, String Fname,String Lname,String Address,String land,String city) throws IOException, InterruptedException
	{
		
		test= report.startTest("Add to Cart");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		CartPOM cp=new CartPOM(driver);
		log.info("Class Instantiated");
		
		cp.clickProduct().click();
		log.info("Clicked on the product diplayed");
		test.log(LogStatus.PASS,"Clicked on the product diplayed");
		
		
		WebElement ele=cp.WishList();
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		log.info("Product added to the wishList");
		test.log(LogStatus.PASS,"Product added to the wishList");
		
		WebElement ele1=cp.AddCart();
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		ele1.click();
		log.info("Product added to the cart");
		test.log(LogStatus.PASS,"Product added to the cart");
		
		WebElement ele2=cp.CheckOut();
		wait.until(ExpectedConditions.elementToBeClickable(ele2));
		ele2.click();
		log.info("confirmation");
		test.log(LogStatus.PASS,"CheckoutDone");
		
		Assert.assertTrue(cp.Texture().isDisplayed());
		String str=cp.Texture().getText();
		log.info("Displayed txt is:"+str);
		System.out.println(str);
		
		
		cp.CountryCodeClick().sendKeys("+91");
		log.info("Country Code Entered");
		test.log(LogStatus.PASS,"Country Code Entered");
		
		cp.phonenoClick().sendKeys("6393575904");
		log.info("Phone Number Entered");
		test.log(LogStatus.PASS,"Phone Number Entered:");
		
		cp.SubmitClick().click();
		log.info("Clicked on submit");
		test.log(LogStatus.PASS,"Clicked on submit");
		
		WebElement ele3=cp.mailclick();
		wait.until(ExpectedConditions.elementToBeClickable(ele3));
		ele3.sendKeys(Mail);
		log.info("Mail Entered:"+Mail);
		test.log(LogStatus.PASS,"Mail Entered:"+Mail);
		
		cp.FnameClick().sendKeys(Fname);
		log.info("First Name Entered:"+Fname);
		test.log(LogStatus.PASS,"First Name Entered:"+Fname);
		
		cp.LnameClick().sendKeys(Lname);
		log.info("Last Name Entered:"+Lname);
		test.log(LogStatus.PASS,"Last Name Entered:"+Lname);
		
		cp.addressclick().sendKeys(Address);
		log.info("Address Entered:"+Address);
		test.log(LogStatus.PASS,"Address Entered:"+Address);
		
		cp.landmarkclick().sendKeys(land);
		log.info("Landmark Entered:"+land);
		test.log(LogStatus.PASS,"Landmark Entered:"+land);
		
		cp.cityclick().sendKeys(city);
		log.info("City Entered:"+city);
		test.log(LogStatus.PASS,"City Entered:"+city);
		
		cp.countryclick().selectByIndex(0);
		log.info("India selected");
		test.log(LogStatus.PASS,"India selected");
		
		cp.stateclick().selectByIndex(9);
		log.info("State selected");
		test.log(LogStatus.PASS,"State selected");
		
		cp.pinclick().sendKeys("110058");
		log.info("PIN Code entered:");
		test.log(LogStatus.PASS,"PIN Code entered:");
		
		cp.mobileclick().sendKeys("6544");
		log.info("Here is a Bug Website is takeing invalid phone Number:");
		test.log(LogStatus.PASS,"Here is a Bug Website is takeing invalid phone Number:");
		
		cp.continueclick().click();
		log.info("Clicked on continue");
		test.log(LogStatus.PASS,"Clicked on continue");
		ExtentLogUtilities.pass(driver, test, "Bug Found", log);
		
		
		Assert.assertTrue(cp.PaymentClick().isDisplayed());
		log.info("Payment option Displayd");
		test.log(LogStatus.PASS,"Payment option Displayd");
						
	}

	@DataProvider
	public  Object[][] getvalue2() throws UtilityException
	{
		String path=System.getProperty("user.dir");
		ExcelSheetRead exc = null;
		try {
			exc = new ExcelSheetRead(path+"\\testdata\\Data.xlsx","Cart");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excel Sheet not found");
		}
		Object[][] ob=new Object[1][6];
		ob[0][0]=exc.getStringData(0, 0);
		ob[0][1]=exc.getStringData(0, 1);
		ob[0][2]=exc.getStringData(0, 2);
		ob[0][3]=exc.getStringData(1, 0);
		ob[0][4]=exc.getStringData(1, 1);
		ob[0][5]=exc.getStringData(1, 2);
		System.out.println(exc.getStringData(0, 0));
		System.out.println(exc.getStringData(0, 1));
		System.out.println(exc.getStringData(0, 2));
		System.out.println(exc.getStringData(1, 0));
		System.out.println(exc.getStringData(1, 1));
		System.out.println(exc.getStringData(1, 2));

		return ob;	
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
