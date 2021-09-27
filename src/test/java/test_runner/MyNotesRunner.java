package test_runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "json:target/cucumber-report/cucumber-default-json-report.json"
                , "html:target/cucumber-report/cucumber-default-html-report.html"
                , "summary"
        },
        features = {"classpath:feature_files"},
        glue = {"classpath:step_definitions"},
        monochrome = false,
        dryRun = false,
        tags = ("@myNotes")
)

public class MyNotesRunner {
}

