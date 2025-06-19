package StepDefinitions;

import org.testng.Assert;

import Framework.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tokens {
	PageObject pageObject = new PageObject();
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhIjoxLCJiIjoyLCJjIjozLCJpYXQiOjE2OTYzOTc5Mjd9.6S9s1qxsu454fCUtOOME3Y_LLw7jq1owBleccDmPwvo";

	@When("user paste the token in embedded text area")
	public void user_paste_the_token_in_embedded_text_area() {
		pageObject.PasteToken(token);
	}

	@Then("value of {string} is {int} in payload")
	public void value_of_is_in_payload(String valueToGet, Integer expectedValue) {
		Assert.assertTrue(pageObject.VerifyValue(valueToGet, expectedValue),
				"Expected Value " + expectedValue + " did not Match");
	}

	@Then("{string} is displayed under Embedded text area")
	public void is_displayed_under_embedded_text_area(String expectedValue) {
		Assert.assertEquals(pageObject.VerifySignature(), expectedValue, "Expected Value doesnt match");
	}

}
