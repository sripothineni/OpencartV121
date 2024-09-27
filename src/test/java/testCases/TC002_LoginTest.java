package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***************** Starting testcase TC002_LoginTest ******************");
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		//MyAccount Page
		MyAccount myaccount = new MyAccount(driver);
		boolean targetPage = myaccount.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		
		logger.info("***************** Starting testcase TC002_LoginTest ******************");
		
	}

}
