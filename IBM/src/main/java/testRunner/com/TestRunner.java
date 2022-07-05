package testRunner.com;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/main/java/feature/com/sauceLabSite.feature",
		glue={"stepDefination"},
     tags= {"@scenario3"}
// tags= {"@Sanity","@Regression"} //-And Condition
// tags= {"@Sanity, @Regression"} //-OR Condition
 //tags={"@Functional"}
 //tags= {"@Sanity","~@Regression"} //s- ignore tag2
)

public class TestRunner {

}
