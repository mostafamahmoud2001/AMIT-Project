package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
        features = "src/main/resources/features",
        glue = {"org.example.stepDefs"},
        plugin = {"pretty","html:target/TestReport.html"},
        tags = "@smoke"
)
public class Main  extends AbstractTestNGCucumberTests {
}
