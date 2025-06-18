package StepDefinitions;

import Framework.PageObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tokens {
	PageObject object = new PageObject();
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhIjoxLCJiIjoyLCJjIjozLCJpYXQiOjE2OTYzOTc5Mjd9.6S9s1qxsu454fCUtOOME3Y_LLw7jq1owBleccDmPwvo";
	
	@When("user paste the token in embedded text area")
	public void user_paste_the_token_in_embedded_text_area() {
	   object.PasteToken(token);
	}
	
	
	@Then("value of {string} is {int} in payload")
	public void value_of_is_in_payload(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	
	@Then("{string} is displayed under Embedded text area")
	public void is_displayed_under_embedded_text_area(String string) {
	    	}

}
