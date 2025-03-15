package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
	    glue = "stepDefinition",
	    plugin = {"pretty", "json:target/cucumber-report.json"}
	    //plugin = {"pretty", "html:target/cucumber-report"}
		)
public class RunnerTest extends AbstractTestNGCucumberTests{
 
}
