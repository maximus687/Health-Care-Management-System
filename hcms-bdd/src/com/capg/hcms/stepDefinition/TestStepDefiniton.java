package com.capg.hcms.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefiniton {
	
	WebDriver driver;
	
	@Given("^Navigate to Hcms Login Page$")
	public void navigate_to_Hcms_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/login");
		driver.manage().window().maximize();
	}

	@When("^User Enters Valid Credentials$")
	public void user_Enters_Valid_Credentials() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-login/div/div/form/div[1]/input")).sendKeys("mdikram123");
		driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-login/div/div/form/div[2]/input")).sendKeys("123456"); 
		driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-login/div/div/form/div[3]/button")).click();
	}

	@Then("^Display User Page$")
	public void display_User_Page() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/body/div/nav/ul[1]/li[1]/a")).click();
		driver.findElement(By.xpath("/html/body/app-root/body/div/nav/ul[1]/li[4]/a")).click();
		WebElement element1=driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/div[1]/select"));
	    Select select1 =new Select(element1);
	    select1.selectByIndex(2);
	    WebElement element2=driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/div[2]/select"));
	    Select select2 =new Select(element2);
	    select2.selectByIndex(1);
	    
	    driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/div[3]/input")).sendKeys("26-11-2020");
	    driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/div[4]/input")).sendKeys("13:20");
	    driver.findElement(By.xpath("//*[text()='Book Appointment']")).click();
	    driver.findElement(By.xpath("/html/body/app-root/body/div/nav/ul[1]/li[5]/a")).click();
	    driver.findElement(By.xpath("/html/body/app-root/body/div/nav/ul[2]/li[2]/a")).click();
	    driver.close();
	    
	    
	    
	    
	    //driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/button")).submit();
//	    Actions a =new Actions(driver);
//	    a.doubleClick(driver.findElement(By.xpath("/html/body/app-root/body/div/div/app-make-appointment/body/div/div/div[2]/div/form/button")));
	    //driver.switchTo().alert().accept();
	    //driver.close();
}
		
}
	
	

