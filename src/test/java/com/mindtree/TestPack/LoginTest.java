package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.POMPack.AccountPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.exception.UtilityException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExcelSheetRead;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends Base{
	
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
	
	@Test(dataProvider="getvalue")
	public void LoginTestMethod(String id,String password1) throws IOException
	{
		
	
		test= report.startTest("Login Page");
		//Instantiating AccountUi
		AccountPOM Au=new AccountPOM(driver);
		log.info("Class Instantiated");
		
		Au.SignIn().click();
		log.info("Clicked on Login");
		test.log(LogStatus.PASS,"Click on login");
		
		Au.nam().sendKeys(id);
		log.info("UserName Entered");
		test.log(LogStatus.PASS,"UserName Entered:"+id);
		
		Au.pssw().sendKeys(password1);
		log.info("Password Entered");
		test.log(LogStatus.PASS,"Password Entered:"+"******");
		
		Au.done().click();
		log.info("Clicked on Submit");
		

		test.log(LogStatus.PASS,"Logged In");
		ExtentLogUtilities.pass(driver, test, "Log In Successfully", log);
		
	}
	
	@DataProvider
	public  Object[][] getvalue() throws UtilityException
	{
		String path=System.getProperty("user.dir");
		ExcelSheetRead exc = null;
		try {
			exc = new ExcelSheetRead(path+"\\testdata\\Data.xlsx","login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excel Sheet not found");
		}
		Object[][] ob=new Object[1][2];
		ob[0][0]=exc.getStringData(0, 0);
		ob[0][1]=exc.getStringData(0, 1);
		System.out.println(exc.getStringData(0, 0));
		System.out.println(exc.getStringData(0, 1));
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
