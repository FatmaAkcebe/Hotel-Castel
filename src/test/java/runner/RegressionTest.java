package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@RegressionTest",
        features = {"src/test/java/featureFiles"},
        glue = {"stepDefinitions","hooks"}
)
public class RegressionTest extends AbstractTestNGCucumberTests {
}
