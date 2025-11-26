package myTestCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationExercise {

	WebDriver driver = new EdgeDriver();

	String TheWebsite = "https://automationexercise.com/";

	String theSignupPage = "https://automationexercise.com/signup";

	Random rand = new Random();
	
	String publicEmail ; 
	

	@BeforeTest

	public void mySetup() {

		driver.get(TheWebsite);

		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(invocationCount = 4)
	public void loadTest() throws InterruptedException {
		
		signup();
		login();
		
	}
	
	public void signup() throws InterruptedException {

		String[] USERNAMES = {"Dina", "Laith", "Fahad", "Ahmad"}; // static
																  // array
		int randomUserIndex = rand.nextInt(USERNAMES.length);

		int myRandomNumberForTheEmail = rand.nextInt(5477110);
		
		String email = USERNAMES[randomUserIndex] + myRandomNumberForTheEmail + "@gmail.com";
			
		publicEmail=email; 

		driver.navigate().to(theSignupPage);

		WebElement NameSignUp = driver.findElement(By.xpath("//input[@placeholder='Name']"));

		WebElement EmailSignUp = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

		NameSignUp.sendKeys("ahmad");

		EmailSignUp.sendKeys(email);

		WebElement SignupButton = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));

		SignupButton.click();

		//Thread.sleep(3000);

	}
	
	//@Test (priority = 2,invocationCount = 3)
	
	public void login() throws InterruptedException{
		
		driver.navigate().to("https://automationexercise.com/login");
		
		WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		loginEmail.sendKeys(publicEmail); 
		Thread.sleep(3000);
	
	}

	@AfterTest

	public void AfterMyTest() {
	}

	
}
