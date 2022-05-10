package runner3;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/features/HooksExample.feature",
        glue = "stepdefinitions_for_hooks",
        plugin = {"pretty", "junit:target/JUnitReports/report.xml", "json: target/JSONReports/report.json"}
)

public class RunnerTestsForHooks {

}
