package zh.qa.platform.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src\test\resources\features"},
//        glue = {"BaseTest","stefDef"},
        plugin = {
                "pretty",
                "html:target/cucumberReport/CucumberReport.html",
                "html:target/cucumberReport/CucumberReport.json",
                "html:target/cucumberReport/CucumberReport.json",
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
