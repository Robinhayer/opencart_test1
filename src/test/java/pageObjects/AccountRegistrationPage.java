package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
 @FindBy(xpath="//input[@id='input-firstname']")
 WebElement txt_firstname;
 @FindBy(xpath="//input[@id='input-lastname']")
 WebElement txt_lastname;
 @FindBy(xpath="//input[@id='input-email']")
 WebElement txt_email;
 @FindBy(xpath="//input[@id='input-password']")
 WebElement txt_password;
 @FindBy(xpath="//input[@name='agree']")
 WebElement btn_privacyagree;
 @FindBy(xpath="//button[normalize-space()='Continue']")
 WebElement btn_continue;
 @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
 WebElement confirmation_msg;
 
 public void enterfirstname(String firstname)
 {
	 txt_firstname.sendKeys(firstname);
 }
 public void enterlastname(String lastname)
 {
	 txt_lastname.sendKeys(lastname);
 }
 public void enteremail(String email)
 {
	 txt_email.sendKeys(email);
 }
 public void enterpassword(String password)
 {
	 txt_password.sendKeys(password);
 }
 public void agreeprivacy()
 {
	 btn_privacyagree.click();
 }
 public void continuebutton()
 {
	 btn_continue.click(); 
 }
 public String confirmationmsg()
 {try {
	 return confirmation_msg.getText();
 }
 catch(Exception e)
 {
	return(e.getMessage());
 }
 
 }
 
}
