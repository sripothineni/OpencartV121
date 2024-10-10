package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonWebActions;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='content']//div[@class='caption']/h4/a")
	List<WebElement> searchResults;

	public boolean pageHasSearchResults() {
		if (searchResults.size() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnProduct(String productName) throws InterruptedException {
		System.out.println(productName);
		for (WebElement product : searchResults) {
			System.out.println(product.getText());
			String product_name = product.getText();
			if (product_name.equalsIgnoreCase(productName)) {
				CommonWebActions.JavaScriptClick(driver, product);
			}
		}

	}

}
