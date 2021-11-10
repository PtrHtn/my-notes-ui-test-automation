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
                , "me.jvt.cucumber.report.PrettyReports:target/cucumber-report"
        },
        features = {"classpath:feature_files"},
        glue = {"classpath:step_definitions"},
        monochrome = false,
        dryRun = false,
        tags = "@creating_note"
//        tags = "@myNotes and @creating_note"
//        tags = "@myNotes or @creating_note"
//        tags = "not @smoke"

/*
@fast 	            Scenarios tagged with @fast
@wip and not @slow 	Scenarios tagged with @wip that aren’t also tagged with @slow
@smoke and @fast 	Scenarios tagged with both @smoke and @fast
@gui or @database 	Scenarios tagged with either @gui or @database
(@smoke or @ui) and (not @slow) For even more advanced tag expressions
*/

)

public class MyNotesRunner {
}

