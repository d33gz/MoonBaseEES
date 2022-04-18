package revature.d33z.e2eTests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.cucumber.java.en.Given;
import revature.d33gz.main.App;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class practice {
	static WebDriver driver;
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\hendo\\Documents\\Revature//geckodriver.exe");
		driver = new FirefoxDriver();
		App.main(null);
	}
	//@Given("User is on Home Page")
	@Test
	@Order(1)
	public void user_is_on_home_page() throws InterruptedException {
	    driver.get("http://localhost:1969/");
	    Assertions.assertEquals("Moon Base Employee Expense System - Index", driver.getTitle());
	    Thread.sleep(2000);
	}
//	@And("User Navigate to Login Page")
	@Test
	@Order(2)
	public void user_navigate_to_log_in_page() throws InterruptedException {
	    WebElement goToLoginButton = driver.findElement(By.id("enter-button"));
	    goToLoginButton.click();
	    Thread.sleep(2000);
	}
//	@When("User enters {string} and {string}")
	@Test
	@Order(3)
	public void user_enters_and() throws InterruptedException {
	    WebElement usernameInput = driver.findElement(By.id("userName"));
   		WebElement passwordInput = driver.findElement(By.id("password"));
   		usernameInput.sendKeys("The Boss");
   		passwordInput.sendKeys("wowz3r5");
   		WebElement loginButton = driver.findElement(By.id("login-button"));
   		loginButton.click();
   		Thread.sleep(2000);
	}
//	@Then("Message displayed Login Successfully")
	@Test
	@Order(4)
	public void message_displayed_login_successfully() throws InterruptedException {
		WebElement nameBox = driver.findElement(By.id("userName"));
		Assertions.assertEquals("The Boss", nameBox.getText());
		Thread.sleep(2000);
	}
	
	@AfterAll
	public static void tearDown() {
		driver.close();
	}
}
