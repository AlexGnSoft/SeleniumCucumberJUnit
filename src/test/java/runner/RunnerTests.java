package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "junit:target/JUnitReports/report.xml", "json: target/JSONReports/report.json"},
        tags = "@ValidCredentials"
)
public class RunnerTests {

}
