package stepDefination.com;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class DemoQAForm {
	
	WebDriver driver;
	
	@Given("To launch demoQA website")
	public void to_launch_demoQA_website() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
	}

	@When("Verify that firtname textbox is diplayed")
	public void verify_that_firtname_textbox_is_diplayed() {
		System.out.println(driver.findElement(By.xpath("//input[@id='firstName']")).isDisplayed());
	}

	@When("enter first name in textbox {string}")
	public void enter_first_name_in_textbox(String string) {
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(string);
	}

	@When("enter last name in textbox {string}")
	public void enter_last_name_in_textbox(String string) {
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(string);
	}

	@When("enter email ID in textbox {string}")
	public void enter_email_ID_in_textbox(String string) {
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(string);
	}

	@When("enter mobile number in textbox{string}")
	public void enter_mobile_number_in_textbox(String string) {
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(string);
	}

	@When("enter Subject in textbox {string}")
	public void enter_Subject_in_textbox(String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys(string);
	}

	@When("enter current address in textbox{string}")
	public void enter_current_address_in_textbox(String string) {
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(string);
	}
	@Then("Fill Up the form")
	public void fill_Up_the_form(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
//		List<String> data =dataTable.asList();
//		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(data.get(0));
//		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(data.get(1));
		
		//List<Map<String,String>> data = dataTable.asMaps(String.class,String.class);
	//	Map<String, String> data =dataTable.asMaps(String.class,String.class);
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(data.get("firstname"));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(data.get("lastname"));
		
		/*
		 * driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(data.get(1).
		 * get("lastname"));
		 * driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(data.get(2)
		 * .get("email"));
		 * driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(data.get(3
		 * ).get("mobilenumber"));
		 * driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(data.get(4
		 * ).get("subject"));
		 * driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(
		 * data.get(5).get("currentAddress"));
		 */
		
		
	}


}
