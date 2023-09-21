package testCases;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
public class TC_003LoginDDT extends BaseClass
{
	@Test(dataProvider="Logindata", dataProviderClass=DataProvider.class)
	public void login_test(String email, String Password, String status)
	{
		logger.debug("Applictaion Started");
		logger.info("**** Starting TC_03LoginDDT **** ");
		
		try 
		{	
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account");
		hp.clickLogin();
		logger.info("clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering UserInfo now");
		lp.enterEmail(rb.getString(email));
		lp.enterPassword(rb.getString(Password));
		lp.clickLogin();
		MyAccountPage mcp=new MyAccountPage(driver);
		boolean accnt=mcp.chechmyaccount();
		if(status.equals("valid"))
		{
			if(accnt==true)
			{
				mcp.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
			Assert.assertTrue(false);	
			}
		}
		if(status.equals("invalid"))
		{
			if(accnt==true)
			{
				mcp.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
			Assert.assertTrue(true);	
			}
		}
		 }
		catch(Exception e)
		{
			Assert.fail();
		}		
		logger.info("Test Completed");
		}
	
}

