package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{
	public Loginpage(WebDriver driver)	
	
    {
   	 super(driver);
    }
	
	
	
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	WebElement login;

	public void Email(String Eml){
		email.sendKeys(Eml);
	}
	public void pass(String Pwd)
	{
		password.sendKeys(Pwd);
	}
	public void Login()
	{
		login.click();
	}
}
