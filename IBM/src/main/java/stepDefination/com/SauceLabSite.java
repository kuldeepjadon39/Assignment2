package stepDefination.com;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SauceLabSite {

	static WebDriver driver;

	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(data.get("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get("password"));
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Given("user adds required item to cart")
	public void user_adds_required_item_to_cart() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
	}

	@Given("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(2000);
	}

	@Given("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkouts(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(data.get("FirstName"));
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(data.get("LastName"));
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(data.get("PostalCode"));
		Thread.sleep(2000);
	}

	@When("user confirm checkout")
	public void user_confirm_checkout() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		scrollDown();
		Thread.sleep(2000);
	}

	@Then("user verify final confirmation messagge")
	public void user_verify_final_confirmation_messagge() {
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']"));
		String actualTitle = ele.getText();
		System.out.println("final confirmation messagge =" + actualTitle);
		assertEquals("THANK YOU FOR YOUR ORDER", actualTitle);
	}

	@Given("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).click();
		Thread.sleep(2000);

	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_message() {

		driver.findElement(By.xpath("//button[@id='finish']")).click();
		WebElement ele = driver.findElement(By.xpath("//h2[normalize-space()='THANK YOU FOR YOUR ORDER']"));
		String actualTitle = ele.getText();
		System.out.println("final confirmation messagge =" + actualTitle);
		assertEquals("THANK YOU FOR YOUR ORDER", actualTitle);
		driver.close();

	}

	@Given("user sorts item low to high")
	public void user_sorts_item_low_to_high() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		Select valueLowToHigh = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		valueLowToHigh.selectByVisibleText("Price (low to high)");
		Thread.sleep(2000);

	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}

}
