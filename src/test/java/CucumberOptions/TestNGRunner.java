package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features",glue={"StepDefinition","Hooks"},monochrome=true)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

}
