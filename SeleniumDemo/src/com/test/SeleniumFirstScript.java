package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumFirstScript {

	public static void main(String aregs[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0027WO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.navigate().to("https://demoqa.com/automation-practice-form");

		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Kuldeep");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Jadon");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("kuldeep.jadon11@gmail.com");

		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("9175091201");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");

		Thread.sleep(3000);
		WebElement dateBox = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));

		dateBox.click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByVisibleText("April");

		Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		year.selectByVisibleText("2022");
		dateBox.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//label[normalize-space()='Sports']")).click();
		driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Pune");

		Select state = new Select(driver.findElement(By.xpath("//div[contains(text(),'Select State')]")));

		state.deselectByIndex(0);
		Thread.sleep(3000);
		Select city = new Select(driver.findElement(By.xpath("//div[@id='stateCity-wrapper']//div[3]")));

		city.selectByVisibleText("Noida");

	}

}
