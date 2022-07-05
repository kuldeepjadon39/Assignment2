package stepDefination.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSteps {
	
	WebDriver driver;
	
	@Given("Launch Amazon.in")
	public void launch_Amazon_in() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	    
	}

	@When("Verify that sign in btn is displayed")
	public void verify_that_sign_in_btn_is_displayed() {
		System.out.println(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")).isDisplayed());
	    
	}

	@When("click on menu icon")
	public void click_on_menu_icon() {
	   driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
	}

	@When("click on Best sellers")
	public void click_on_Best_sellers() {
		 driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible']//a[@class='hmenu-item'][normalize-space()='Best Sellers']")).click();
	}

	@Then("verify best seller header")
	public void verify_best_seller_header() {
		System.out.println(driver.findElement(By.xpath("//span[@id='zg_banner_text']")).isDisplayed());
	}
}
