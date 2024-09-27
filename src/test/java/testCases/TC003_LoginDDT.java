package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= {"Datadriven"}) // getting data provider from different
																				// class
	public void verify_login(String email, String pwd, String expectedResult) {
		logger.info("***************** Starting testcase TC003_LoginDDT ******************");
		//System.out.println(email + "::" + pwd + "::" + expectedResult);
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Login Page
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLoginButton();

			// MyAccount Page
			MyAccount myaccount = new MyAccount(driver);
			boolean targetPage = myaccount.isMyAccountPageExists();

			if (expectedResult.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					Assert.assertTrue(true);
					hp.clickMyAccount();
					myaccount.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}

			if (expectedResult.equalsIgnoreCase("Invalid")) {
				if (targetPage == false) {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***************** Starting testcase TC003_LoginDDT ******************");

	}

}
