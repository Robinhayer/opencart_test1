package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount_txt; 
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout; 
	
	public boolean chechmyaccount()
	{
		{
			try {
				return (myaccount_txt.isDisplayed());
			} 
			catch (Exception e) 
			{
				return (false);
			}
		}
	}

		
	public void clicklogout()
	{
		btn_logout.click();
	}
	

}
