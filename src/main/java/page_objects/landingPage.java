package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class landingPage extends AbstractComponents{
	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}

	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//using page factory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//driver.findElement(By.id("userPassword")).sendKeys("Santosh@3155");
	@FindBy(id="userPassword")
	WebElement userPass;
	
	//driver.findElement(By.id("login"))
	@FindBy(id="login")
	WebElement submit;
	
	//error toast message
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement error;
	
	
	public catalogpage logintoApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPass.sendKeys(password);
		submit.click();
		//return the product catolog page
		catalogpage prod1=new catalogpage(driver);
		return prod1;
	}
	
	public String getErrorMessage() {
	visiblityofelement(error);
	return	error.getText();
	}
	
	
	public void goToLandingpage() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	
}

