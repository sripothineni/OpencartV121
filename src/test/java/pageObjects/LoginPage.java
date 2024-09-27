package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='input-email']") 
	WebElement txtEmailAddress;
	
	@FindBy(how=How.XPATH, using="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(how=How.XPATH, using="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	

}
