package StepDefinitions;

import Framework.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

public class Hooks extends Base {

	@Given("user is in the {string}")
	public void user_is_in_the(String url) {
		LaunchBrowser(url);
	}

	@After
	public void CloseBrowser() {
		driver.quit();
	}

}
