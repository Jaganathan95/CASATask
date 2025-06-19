package Framework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinitions", dryRun = false, tags = "@tag_example1")

public class TestRunner extends AbstractTestNGCucumberTests {

}
