package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//button[@id='button-cart']") 
	WebElement btnAddtoCart;
	
	
	
	public void clickOnAddtoCart() {
		btnAddtoCart.click();
	}

}
