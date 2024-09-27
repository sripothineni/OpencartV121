package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccount extends BasePage {

	public MyAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(how=How.XPATH, using = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") 
	WebElement lnkLogout;
	
	

	public boolean isMyAccountPageExists() {
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

}
