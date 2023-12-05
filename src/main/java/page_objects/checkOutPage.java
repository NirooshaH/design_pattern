package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents{
	WebDriver driver;
	
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement county;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[@class=\"ta-results list-group ng-star-inserted\"]/button[2]")
	
	WebElement desiredCountry;
	
	public void selectCountry(String CountryNmae) {
		Actions act=new Actions(driver);
		act.sendKeys(county,CountryNmae).build().perform();
		desiredCountry.click();
	}
	
	public void SubmitOrder() {
		submitButton.click();
		
	}
	
	
}

