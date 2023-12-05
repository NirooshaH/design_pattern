package sus.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class stanalone_test {
	@Test()
	public static void tc1() throws InterruptedException{
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sushantanandy@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Santosh@3155");
		driver.findElement(By.id("login")).click();
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		//using of java stream
	WebElement prod=	products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("iphone 13 pro")).findFirst().orElse(null);
		
	prod.findElement(By.cssSelector(".btn.w-10.rounded:last-of-type")).click();
	
	//wait until toast message appaers
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	Thread.sleep(3000);
	driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
	
	//verify products in cart
	List<WebElement> productCart= driver.findElements(By.cssSelector(".cart h3"));
Boolean bn=	productCart.stream().anyMatch(s->
	s.findElement(By.cssSelector(".cart h3")).getText().equalsIgnoreCase("iphone 13 pro"));

	Assert.assertTrue(bn);
	driver.findElement(By.cssSelector(".subtotal>ul>li>button")).click();
	
	Actions act=new Actions(driver);
	act.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();
	driver.findElement(By.xpath("//*[@class=\"ta-results list-group ng-star-inserted\"]/button[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	//verify in conformation page
String confirmMsg=	driver.findElement(By.cssSelector(".hero-primary")).getText();
AssertJUnit.assertEquals(confirmMsg, "THANKYOU FOR THE ORDER.");

}
}
