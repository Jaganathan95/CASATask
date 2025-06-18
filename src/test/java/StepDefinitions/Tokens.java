package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Tokens {
	@Given("user is in the https:\\/\\/jwt.io")
	public void user_is_in_the_https_jwt_io() {
	   System.out.println("Test");
	}
	@When("user paste the token in embedded text area")
	public void user_paste_the_token_in_embedded_text_area() {
	   
	}
	@Then("value of {int} is {int} in payload")
	public void value_of_is_in_payload(Integer int1, Integer int2) {
	    
	}
	@Then("{string} is displayed under Embedded text area")
	public void is_displayed_under_embedded_text_area(String string) {
	    	}

}
