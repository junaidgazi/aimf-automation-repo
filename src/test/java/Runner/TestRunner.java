package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"com.hrmsAvisoft.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html"},
        monochrome = true,
        tags = "@API"
)
public class TestRunner {
}
