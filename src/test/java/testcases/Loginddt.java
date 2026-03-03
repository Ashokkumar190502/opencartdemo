package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.Myaccpage;
import testbase.Baseclass;
import utilities.Dataproviders;
public class Loginddt extends Baseclass{




      @Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
     public void verify_loginDDT(String email, String password, String exp)
    {
    	  
    logger.info("**** Starting TC_003_LoginDDT *****");

     try {

//Home page
	Homepage hp=new Homepage(driver);
	hp.clickMyAccount();
	hp.clicklogin();
	
	Loginpage lp=new Loginpage(driver);
	lp.Email(email);
	lp.pass(password);
	lp.Login();
//My Account Page
	Myaccpage macc=new Myaccpage(driver);
      boolean targetPage=macc.isMyAccountPageExists();

      if(exp.equalsIgnoreCase("Valid"))
  {
      if(targetPage==true)
  {
    	  
    macc.clickLogout();
    
   Assert.assertTrue(true);
  }
      
  else
	  
   {
     Assert.assertTrue(false);
   }
   }

     if(exp.equalsIgnoreCase("Invalid"))
   {
     if(targetPage==true)
   {
     macc.clickLogout();
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
Assert.fail("An exception occurred: " + e.getMessage());
}

logger.info("**** Finished TC_003_LoginDDT *****");
}

	
	
}
