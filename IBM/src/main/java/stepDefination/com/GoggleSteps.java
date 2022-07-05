package stepDefination.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoggleSteps {
	
	WebDriver driver;
	@Given("To launch google website")
	public void to_launch_google_website() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	   
	}

	@When("The search bar is visible")
	public void the_search_bar_is_visible() {

		System.out.println(driver.findElement(By.name("q")).isDisplayed());
	   
	}

	@Then("Enter the text KJ")
	public void enter_the_text_KJ() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.name("q")).sendKeys("KJ");
	}
	
	@Then("Enter the text {string}")
	public void enter_the_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("q")).sendKeys(string);
	}

}
