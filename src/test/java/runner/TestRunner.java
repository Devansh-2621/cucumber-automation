package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // Path to feature files
    glue = "steps",                             // Path to step definitions
    plugin = {
        "pretty",                               // Pretty console output
        "html:target/cucumber-reports.html",    // HTML report
        "json:target/cucumber.json",            // JSON report
        "junit:target/cucumber.xml"             // JUnit-compatible XML report
    },
    monochrome = false                           // Better readability in the console
)
public class TestRunner {
}
