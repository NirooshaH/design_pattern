package sus.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import page_objects.landingPage;

public class BaseTest {
	 //Global variable
	public static WebDriver driver;
	
	@BeforeMethod()
	public static WebDriver initilizeDriver() throws IOException {
		
		
		
		//properties class
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/apple/Downloads/selenium_whole_project-master/sus/src/main/java/resources/GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver=new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//firefox invocation
		}
		else if(browserName.equalsIgnoreCase("edge")){
			//edge invocation
			WebDriverManager.edgedriver().setup();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;	
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}
