package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@RegressionTest or @SmokeTest",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions"}
)
public class RegressionTest extends AbstractTestNGCucumberTests {
}
