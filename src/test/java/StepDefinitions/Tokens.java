package StepDefinitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Framework.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tokens {
	PageObject pageObject = new PageObject();

	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhIjoxLCJiIjoyLCJjIjozLCJpYXQiOjE2OTYzOTc5Mjd9.6S9s1qxsu454fCUtOOME3Y_LLw7jq1owBleccDmPwvo";
	String secretKey = "helloworld";

	public static String expectedPayload() {
		return """
				    {
				      "a": 1,
				      "b": 2,
				      "c": 3,
				      "iat": 1696397927
				    }
				""";
	}

	@When("user enter the {string}")
	public void user_enter_the(String tokenOrSecret) throws Exception {
		if (tokenOrSecret.toLowerCase().equals("token")) {
			pageObject.EnterTokenOrSecretKey(tokenOrSecret, token);
		} else {
			pageObject.EnterTokenOrSecretKey(tokenOrSecret, secretKey);
		}
	}

	@Then("value of {string} is {int} in payload")
	public void value_of_is_in_payload(String valueToGet, Integer expectedValue) {
		Assert.assertTrue(pageObject.VerifyValue(valueToGet, expectedValue),
				"Expected Value " + expectedValue + " did not Match");
	}

	@Then("{string} is displayed under Embedded text area")
	public void is_displayed_under_embedded_text_area(String expectedValue) {
		Assert.assertEquals(pageObject.VerifyJwtSignature(), expectedValue, "Expected Value doesnt match");
	}

	@Then("The Secret Key signature is {string}")
	public void the_secret_key_signature_is(String expectedValue) {
		Assert.assertEquals(pageObject.VerifySecret(), expectedValue, "Entered Secret Key is Invalid");
	}

	@Then("Token remains same")
	public void token_remains_same() {
		Assert.assertEquals(pageObject.GetToken(), token, "Token not same");
	}

	@When("user modify the secret")
	public void user_modify_the_secret() throws Exception {
		pageObject.EnterTokenOrSecretKey("secret", "wrongsecret");

	}

	@Then("token changed in Embedded text area")
	public void token_changed_in_embedded_text_area() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotEquals(pageObject.GetToken(), token, "Token did not change");
	}

	@Then("payload remains same")
	public void payload_remains_same() {
		Assert.assertEquals(expectedPayload().trim().replace(" ", ""), pageObject.GetPayload(), "Payload ");
	}

}
