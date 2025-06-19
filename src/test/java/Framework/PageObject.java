package Framework;

import org.openqa.selenium.By;

public class PageObject extends Base {
	// Locator
	String claimsTableButton() {
		return "//div[@data-key='decoder__payload__table']/span[1]";
	}

	static String tableValue(String st) {
		return "//div[@data-testid='decoder__payload__table']//div/var[text()='" + st + "']/parent::div/p";
	}

	// Methods
	public void PasteToken(String token) {
		driver.findElement(By.xpath("//div[@data-testid='decoder__jwtEditor']//button[text()='Clear']")).click();
		driver.findElement(By.xpath("//div[@data-testid='decoder__jwtEditor']//textarea")).sendKeys(token);
	}

	public boolean VerifyValue(String valueToGet, int expectedValue) {
		driver.findElement(By.xpath(claimsTableButton())).click();

		if (driver.findElement(By.xpath(tableValue(valueToGet))).getText().equals(String.valueOf(expectedValue))) {
			return true;
		} else {
			return false;
		}
	}

	public String VerifySignature() {
		return driver.findElement(By.xpath("(//div[@data-testid='decoder__jwtEditor']/div)[3]")).getText();
	}

}
