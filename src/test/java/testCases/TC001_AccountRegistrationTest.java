package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})	
	public void verify_account_registration() {
		
		logger.info("********************Starting testcase TC001_AccountRegistrationTest********************");
		try {
		HomePage hp = new HomePage(driver);
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		hp.clickMyAccount();
		logger.info(">>Clicked on MyAccount link");
		
		hp.clickRegister();
		logger.info(">>Clicked on Reigister");
		
		regpage.setFirstName(randonString().toUpperCase());
		regpage.setLastName(randonString().toUpperCase());
		regpage.setEmail(randonString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = alphaNumaric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info(">>Validating expected message..");
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			
			logger.info(">>Test Passed..");
			Assert.assertTrue(true);
			
		}else {
			logger.error("Test failed...");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		}catch(Exception e) {
			logger.error("Test failed...");
			Assert.fail();
		}
		logger.info("********************Finished testcase TC001_AccountRegistrationTest********************");
	}
	
}
