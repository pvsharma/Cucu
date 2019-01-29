package step_definition;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin = {"pretty", "html:target/reports"},
        features = "classpath:features",
        tags = "@City"

        )

public class TestRunner extends AbstractTestNGCucumberTests{}
