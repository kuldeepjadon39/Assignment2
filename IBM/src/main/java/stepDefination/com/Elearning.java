package stepDefination.com;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Elearning {
	WebDriver driver;
	

	@Given("To launch elearning  website")
	public void to_launch_elearning_website() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
	}

	@When("Click signUp")
	public void click_signUp() {
		driver.findElement(By.xpath("//a[normalize-space()='Sign up!']")).click();
	}

	@Then("Verify Text box")
	public void verify_Text_box() {
		System.out.println(driver.findElement(By.xpath("//input[@name='firstname']")).isDisplayed());
	}



	@Then("Fill up the registration form")
	public void fill_Up_the_form(DataTable dataTable) {
	   
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(data.get("firstname")+Math.random());
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data.get("lastname")+Math.random());
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("email"));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data.get("username")+Math.random());
		driver.findElement(By.xpath("(//input[@id='pass1'])[1]")).sendKeys(data.get("Password"));
		driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys(data.get("ConfirmPassword"));
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();

	}
	@Then("Verify {string}")
	public void verify(String string) {
	  WebElement ele=  driver.findElement(By.xpath("//*[text()='Your personal settings have been registered.']"));
	  String error=ele.getText();
	    if(error.contains("Your personal settings have been registered.")) {
	    	System.out.println("Matched");
	    }else
	    {
	    	System.out.println("Not Matched");
	    }
	}
	
	@Then("click on next button")
	public void click_on_next_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
	}

	@Then("Once on HomePage , click your username")
	public void once_on_HomePage_click_your_username() throws InterruptedException {
		Thread.sleep(3000);
		 driver.findElement(By.xpath("(//span[@class='caret'])[1]")).click();
	}

	@Then("Choose profile from Dropdown")
	public void choose_profile_from_Dropdown() throws InterruptedException {
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
	}

	@Then("Click on Messages")
	public void click_on_Messages() {
		 driver.findElement(By.xpath("//a[normalize-space()='Messages']")).click();
	}
	
	@Then("click on Compose Message")
	public void click_on_Compose_Message() {
		driver.findElement(By.xpath("//img[@title='Compose message']")).click();
	    
	}

	@Then("Enter the details shown on the page")
	public void enter_the_details_shown_on_the_page() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Please select an option']")).sendKeys("test@gmail.com");
	    driver.findElement(By.xpath("//input[@name='title']")).sendKeys("ABC");
	    WebElement iframe = driver.findElement(By.xpath("//*[@title='Rich Text Editor, content']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys("Kuldeep");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='file-descrtiption']")).sendKeys("Thanks Kuldeep Jadon");

	}

	@Then("Click on Send message")
	public void click_on_Send_message() {
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		System.out.println("Finish !!!");
		driver.quit();
	}






}
