package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents{
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".cartSection h3")
	List<WebElement> productCart;
	
	@FindBy(css=".subtotal>ul>li>button")
	WebElement checkout;
	
		public boolean verifyProductDisplay(String productName) {
			
			return productCart.stream().anyMatch(s->
			s.getText().equalsIgnoreCase(productName));
			
		}
		
		public void goToCheckout() {
			checkout.click();
		}
	
	
}

