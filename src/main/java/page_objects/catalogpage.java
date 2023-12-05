package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class catalogpage extends AbstractComponents{
	WebDriver driver;
	
	public catalogpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	//action element to find the products
	//Product list css
	
	By productListCSS=By.cssSelector(".mb-3");
	
	By addtocart=By.cssSelector(".btn.w-10.rounded:last-of-type");
	By toastMessage=(By.cssSelector("#toast-container"));
	
		public List<WebElement> getProductList() {
			waitforelementtoappear(productListCSS);
			return Products;
		}
		
		//get the desirable product
		//WebElement prod=	products.stream().filter(product-> 
		//product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
		
		public WebElement getdesirableProduct() {
			return Products.stream().filter(product-> 
			product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
			
		}
		
		//prod.findElement(By.cssSelector(".btn.w-10.rounded:last-of-type")).click();
		public void addElementtoCart() {
			getdesirableProduct().findElement(addtocart).click();
			
			waitforelementtoappear(toastMessage);
		}
	
	
	
}

