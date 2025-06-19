package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageObject extends Base {
	// Locator
	String claimsTableButton() {
		return "//div[@data-key='decoder__payload__table']/span[text()='Claims Table'][1]";
	}

	String jsonButton() {
		return "//div[@data-key='decoder__payload__json']/span[text()='JSON'][1]";
	}

	String tableValue(String st) {
		return "//div[@data-testid='decoder__payload__table']//div/var[text()='" + st + "']/parent::div/p";
	}

	String jwtClearButton() {
		return "//div[@data-testid='decoder__jwtEditor']//button[text()='Clear']";
	}

	String jwtTextArea() {
		return "//div[@data-testid='decoder__jwtEditor']//textarea";
	}

	String secretClearButton() {
		return "//div[@data-testid='decoder__secretKeyEditor']//button[text()='Clear']";
	}

	String secretTextArea() {
		return "//div[@data-testid='decoder__secretKeyEditor']//textarea";
	}

	String jwtValidationMessage() {
		return "(//div[@data-testid='decoder__jwtEditor']/div)[3]";
	}

	String secretValidationMessage() {
		return "(//div[@data-testid='decoder__secretKeyEditor']/div)[2]";
	}

	String decodedJsonPayload() {
		return "(//div[@class='json-viewer_container__iN5PA'])[2]";
	}

	// Methods
	public void EnterTokenOrSecretKey(String tokenOrSecretValue, String value) throws Exception {

		switch (tokenOrSecretValue.toUpperCase()) {
		case "TOKEN":
			driver.findElement(By.xpath(jwtClearButton())).click();
			driver.findElement(By.xpath(jwtTextArea())).sendKeys(value);
			break;

		case "SECRET":
			driver.findElement(By.xpath(secretClearButton())).click();
			driver.findElement(By.xpath(secretTextArea())).sendKeys(value);
			break;
		default:
			throw new Exception("Invalid Inputs :" + tokenOrSecretValue);
		}

	}

	public boolean VerifyValue(String valueToGet, int expectedValue) {
		ScrollToTop();
		driver.findElement(By.xpath(claimsTableButton())).click();

		if (driver.findElement(By.xpath(tableValue(valueToGet))).getText().equals(String.valueOf(expectedValue))) {
			return true;
		} else {
			return false;
		}
	}

	public String VerifyJwtSignature() {
		return driver.findElement(By.xpath(jwtValidationMessage())).getText();
	}

	public String VerifySecret() {
		return driver.findElement(By.xpath(secretValidationMessage())).getText();
	}

	public String GetToken() {
		return driver.findElement(By.xpath(jwtTextArea())).getText();
	}

	private void ScrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	public String GetPayload() {
		ScrollToTop();
		driver.findElement(By.xpath(jsonButton())).click();
		List<WebElement> jsonSpans = driver.findElements(By.xpath(decodedJsonPayload()));
		StringBuilder builder = new StringBuilder();
		for (WebElement span : jsonSpans) {
			builder.append(span.getText());
		}

		return builder.toString().trim().replace(" ", "");

	}

}
