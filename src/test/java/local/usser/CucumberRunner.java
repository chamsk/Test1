package local.usser;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"src/test/resources/features"},
        glue = "local.usser.stepdefinition"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
