package revature.d33z.e2eTests.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/features",
	glue = {"revature.d33gz.e2eTests.practice.java"}
)
@RunWith(Cucumber.class)
public class TestRunner {

}
