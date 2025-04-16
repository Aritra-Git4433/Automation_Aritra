package CucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features",glue={"StepDefinition","Hooks"},plugin = {"pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    },monochrome=true)
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

}
