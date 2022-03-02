package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"}
        ,glue={""}
        ,plugin = {"pretty", "html:target/report/report.html","json:target/cucumber.json"}
        ,tags ="@test"
)

public class TestRunner {

}