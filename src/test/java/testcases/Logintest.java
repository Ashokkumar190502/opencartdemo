package testcases;

import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.Baseclass;

public class Logintest extends Baseclass{
	
		@Test(groups= {"sanity","master"})
		public void clicklogin()
		
			{
			
				Homepage hp=new Homepage(driver);
				hp.clickMyAccount();
				hp.clicklogin();
				
				Loginpage lp=new Loginpage(driver);
				lp.Email("ashokkumaedpe7@gmail.com");
				lp.pass("ashok123");
				lp.Login();
			}
}
