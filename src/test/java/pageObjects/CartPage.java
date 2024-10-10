package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='table-responsive']//table[@class='table table-bordered']/tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//div[@class='table-responsive']//table[@class='table table-bordered']/tbody/tr/td")
	List<WebElement> tableCols;

	public boolean isProductPresentIncart(int column, String productName) {

		int tableRowsCount = tableRows.size();
		System.out.println(tableRowsCount);
		boolean flag = false;

		outerloop: for (int r = 1; r <= tableRowsCount; r++) {
			String cellText = driver.findElement(
					By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']/tbody/tr[" + r
							+ "]/td[" + column + "]"))
					.getText();
			System.out.println("tr[" + r + "] td[" + column + "]" + cellText);

			if (cellText.contains(productName)) {
				flag = true;
				break outerloop;
			} else
				flag = false;
		}

		return flag;
	}

	public void removeCartItems(int column) {

		int tableRowsCount = tableRows.size();

		for (int r = 1; r <= tableRowsCount; r++) {
			driver.findElement(By.xpath("//tbody/tr[" + r + "]/td[" + column + "]/div[1]/span[1]/button[2]/i[1]"))
					.click();
		}

	}

}
