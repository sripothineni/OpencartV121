package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{
		
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(how=How.XPATH, using="//a[@title='My Account']") 
	WebElement lnkMyaccount;
	
	@FindBy(how=How.XPATH, using="//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	@FindBy(how=How.XPATH, using="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement lnkLogin;
	
	//Action methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	

}
