package revature.d33z.e2eTests;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import revature.d33gz.main.App;

public class LoginSteps {
	public static WebDriver driver;
	
	@BeforeAll
	public static void launchApp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hendo\\Documents\\Revature//geckodriver.exe");
		driver = new FirefoxDriver();
		App.main(null);
		driver.get("http://localhost:1969/");
	}
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    driver.get("http://localhost:1969/");
	    System.out.println("okay now what?");
	}

	@And("User Navigate to Login Page")
	public void user_navigate_to_log_in_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
