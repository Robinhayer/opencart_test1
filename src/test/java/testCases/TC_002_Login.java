package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class TC_002_Login extends BaseClass
{

	@Test
	public void login_test()
	{
	 
		logger.debug("Applictaion Started");
		logger.info("**** Starting TC_002Login **** ");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("clicked on my account");
		hp.clickLogin();
		logger.info("clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering UserInfo now");
		lp.enterEmail(rb.getString("username"));
		lp.enterPassword(rb.getString("password"));
		lp.clickLogin();
		Thread.sleep(5000);
		MyAccountPage mcp=new MyAccountPage(driver);
		boolean accnt=mcp.chechmyaccount();
		Assert.assertEquals(accnt, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Test Completed");
		}
}
