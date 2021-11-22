package com.mindtree.TestPack;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.POMPack.ContactPOM;
import com.mindtree.exception.ReusableComponentException;
import com.mindtree.exception.UtilityException;
import com.mindtree.reusablecomponents.Base;
import com.mindtree.utilities.ExcelSheetRead;
import com.mindtree.utilities.ExtentLogUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class ContactTest extends Base {
	
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
	
	@Test(dataProvider="getvalue1")
	public void ContactTestMethod(String name,String mail,String message) throws IOException, InterruptedException
	{
		test= report.startTest("Contact Us");
		
		ContactPOM cp=new ContactPOM(driver);
		log.info("Class Instantiated");
		
		
		cp.contactClick().click();
		log.info("Clicked on Contact us:");
		test.log(LogStatus.PASS,"Contact Us page opened");
		test.log(LogStatus.PASS,"Contact Us Page");
		
		cp.Nameclick().sendKeys(name);
		log.info("Name entered:");
		test.log(LogStatus.PASS,"Name :"+name);
		
		
		cp.Emailclick().sendKeys(mail);
		log.info("mail Entered");
		test.log(LogStatus.PASS,"Mail :"+mail);
		
		cp.Msgclick().sendKeys(message);
		log.info("Message Entered");
		test.log(LogStatus.PASS,"Message :"+message);
		
		test.log(LogStatus.PASS,"Entered Essential Details");
		
		cp.sendclick().click();
		log.info("submission done");
		
		ExtentLogUtilities.pass(driver, test, "Task Done", log);

	}
	
	@DataProvider
	public  Object[][] getvalue1() throws UtilityException
	{
		String path=System.getProperty("user.dir");
		ExcelSheetRead exc = null;
		try {
			exc = new ExcelSheetRead(path+"\\testdata\\Data.xlsx","Contact");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Excel Sheet not found");
		}
		Object[][] ob=new Object[1][3];
		ob[0][0]=exc.getStringData(0, 0);
		ob[0][1]=exc.getStringData(0, 1);
		ob[0][2]=exc.getStringData(0, 2);
		System.out.println(exc.getStringData(0, 0));
		System.out.println(exc.getStringData(0, 1));
		System.out.println(exc.getStringData(0, 2));
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
