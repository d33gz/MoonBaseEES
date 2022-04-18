package revature.d33z.e2eTests;

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
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
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
	/***LoginSteps***/
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
   		usernameInput.sendKeys("Doctor");
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
		Assertions.assertEquals("Doctor", nameBox.getText());
		Thread.sleep(2000);
	}
	/***EmployeeSteps***/
	/** Minus the first 1 **/
	//@Given("User clicks on {string}")
	@Test
	@Order(5)
	public void user_clicks_on() throws InterruptedException {
		WebElement newRequestButton = driver.findElement(By.id("request-button"));
		newRequestButton.click();
		Thread.sleep(2000);
	}
	//@Then("User can enter Information into Input Fields")
	@Test
	@Order(6)
	public void user_can_enter_information_into_input_fields() throws InterruptedException {
		WebElement titleInput = driver.findElement(By.id("requestTitle"));
		WebElement costInput = driver.findElement(By.id("requestCost"));
		WebElement descInput = driver.findElement(By.id("requestDescription"));
		titleInput.sendKeys("Medicine");
		costInput.sendKeys("120");
		descInput.sendKeys("We are running low on our Medicine Supply. I have to get some more from Earth.");		
		Thread.sleep(2000);
	}
	//@When("User clicks {string}")
	@Test
	@Order(7)
	public void user_clicks() throws InterruptedException {
		WebElement submitButton = driver.findElement(By.id("submitRequest-button"));
	    submitButton.click();
	    Thread.sleep(2000);
	}
	//@Then("A new Expense Request will be made")
	@Test
	@Order(8)
	public void a_new_expense_request_will_be_made() throws InterruptedException {
		WebElement newExpense = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/ul[1]/li[1]/span[1]"));
		Assertions.assertEquals("Medicine", newExpense.getText());
		System.out.println(newExpense.getText());
	    Thread.sleep(2000);
	}
	
	
	@AfterAll
	public static void tearDown() {
		//driver.close();
	}
}
