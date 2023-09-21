package testCases;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentReporter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass 
{
	
	@Test
	void test_account_registartion()
	{   
		logger.debug("Applictaion Started");
		logger.info("**** Starting TC_001_AccountRegistration **** ");
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickRegister();
		logger.info("clicked on Register");
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		logger.info("Entering customer details");
		ap.enterfirstname(randomString().toUpperCase());
		ap.enterlastname(randomString().toUpperCase());
		ap.enteremail(randomString()+"@gmail.com");
		ap.enterpassword(randomAplhaNumber()); 
		Thread.sleep(3000);
		ap.agreeprivacy();
		ap.continuebutton();
		logger.info("");
		String msg=ap.confirmationmsg();
		logger.info("Validating expected msg");
		Assert.assertEquals(msg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("test failed");
		Assert.fail();	
		}
		logger.info("Finsihed this logging test");
		
	}

	
}
