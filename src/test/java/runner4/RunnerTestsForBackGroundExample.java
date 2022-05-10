package runner4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features/Background.feature",
        glue = "stepdefinitions_for_background",
        plugin = {"pretty", "junit:target/JUnitReports/report.xml", "json: target/JSONReports/report.json"}
)
public class RunnerTestsForBackGroundExample {

}
