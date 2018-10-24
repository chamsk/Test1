package local.usser;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
features = {"src\\test\\Resourses\\Features"},
        glue = "local.usser.stepfinision"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
