package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page_objects.OrderPage;
import page_objects.cartPage;

public class AbstractComponents {
	protected WebDriver driver;
//wait, switching to frame and windows
	protected AbstractComponents(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//cart button
	@FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	//order button
	@FindBy(xpath =  "//*[@routerlink=\"/dashboard/myorders\"]")
	WebElement orderHeader;
	
	public void waitforelementtoappear(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	//taking parametre as Webelement
	public void visiblityofelement(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public cartPage goCart() {
		cartHeader.click();
		cartPage Cart=new cartPage(driver);
		return Cart;
	}
	
	
	public OrderPage verifyOrderPage() {
		orderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		
		return orderpage;
	}
}
