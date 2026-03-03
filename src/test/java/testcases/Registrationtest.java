package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Registrationpage;
import testbase.Baseclass;
public class Registrationtest extends Baseclass{

	@Test(groups= {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try {
			
		
	Homepage hp=new Homepage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on MyAccount Link.. ");

	hp.clickRegister();
	
	logger.info("Clicked on Register Link.. ");
	
	
	Registrationpage rp=new Registrationpage(driver);
	
	logger.info("Providing customer details...");
	rp.setFirstName(randomeString().toUpperCase());
	
	rp.setLastName(randomeString().toUpperCase());
	rp.setEmail(randomeString()+"@gmail.com");// randomly generated the email
	rp.setTelephone(randomeNumber());

	String password=randomAlphaNumeric();

	rp.setPassword(password);
	rp.setConfirmPassword(password);

	rp.setPrivacyPolicy();
	rp.clickContinue();
	logger.info("Validating expected message..");
	String confmsg=rp.getConfirmationMsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	
	logger.info("Test passed");
	
	
	}
	catch (Exception e)
	{
	logger.error("Test failed: " + e.getMessage());
	Assert.fail("Test failed: " + e.getMessage());
	}
	finally
	{
	logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}

}
}