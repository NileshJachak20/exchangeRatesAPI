package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/features",
                plugin = { "pretty", "html:target/cucumber-html-report",
                            "json:target/jsonReports/cucumber-report.json",
                            "junit:target/cucumber-reports/Cucumber.xml",
                            "html:target/cucumber-reports" },
                glue = {"stepDefinitions"},
                tags = {"@HistoricalExchange, @LatestExchange"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
