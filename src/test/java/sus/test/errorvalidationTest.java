package sus.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_objects.ConfirmationPage;
import page_objects.cartPage;
import page_objects.catalogpage;
import page_objects.checkOutPage;
import page_objects.landingPage;
import sus.TestComponents.BaseTest;

public class errorvalidationTest extends BaseTest{
	WebDriver	driver;
	landingPage Landpage;
	String productName="iphone 15 pro";
	@Test()
	public void loginerrorvalidation() throws InterruptedException, IOException{
		
		//landingpage object
		driver=	initilizeDriver();
			Landpage=new landingPage(driver);
		Landpage.goToLandingpage();
		
		catalogpage prod1=	Landpage.logintoApplication("sushant23444anandy@gmail.com", "Santosh@3155");
		//error validation
		AssertJUnit.assertEquals(Landpage.getErrorMessage(), "Incorrect email or password.");
	}
	
	@Test()
public void producterrorvalidation() throws InterruptedException, IOException{
		driver=	initilizeDriver();
			Landpage=new landingPage(driver);
		Landpage.goToLandingpage();
	catalogpage prod1=	Landpage.logintoApplication("sushantanandy@gmail.com", "Santosh@3155");
	List<WebElement> products=	prod1.getProductList();
	prod1.getdesirableProduct();
	prod1.addElementtoCart();
	

Thread.sleep(3000);
cartPage Cart=	prod1.goCart();


//verify products in cart

Boolean bn=	Cart.verifyProductDisplay(productName);

Assert.assertFalse(bn);
	}
}
