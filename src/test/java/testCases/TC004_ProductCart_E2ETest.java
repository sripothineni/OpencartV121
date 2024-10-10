package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC004_ProductCart_E2ETest extends BaseClass {
	
	@Test (groups={"Test","Master"})
	public void validateAddingProductToCart() throws InterruptedException {
		
		logger.info("***************** Starting testcase TC004_ProductCart_E2ETest ******************");
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		//Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLoginButton();
		
		hp.clickSearch();
		hp.enterSearchText("iPhone");
		hp.clickSearch();
		
		// Search Results Page
		SearchResultsPage searchResults = new SearchResultsPage(driver);
		searchResults.clickOnProduct("iPhone");
		
		// Product Details Page
		ProductDetailsPage productPage= new ProductDetailsPage(driver);
		productPage.clickOnAddtoCart();
		
		hp.clickCart();
		hp.clickViewcart();
		
		// Cart Page
		CartPage cart = new CartPage(driver);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cart.isProductPresentIncart(2,"iPhone"));
		
		cart.removeCartItems(4);
		
		softAssert.assertAll();
		
		
		
		
		
		
		
		
	}

}
