package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "stepDefinitions" }, plugin = { "pretty",
		"html:target/cucumber-reports/cucumber-html-report.html",
		"json:target/cucumber-reports/cucumber.json" }, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
	static {
		// Set the Cucumber Publish Token as a system property
		System.setProperty("cucumber.publish.token", "a96b0462-b187-4d3e-a541-4c826c052650");
	}
}
