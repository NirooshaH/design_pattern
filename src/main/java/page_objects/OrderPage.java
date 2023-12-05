package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//list
	@FindBy(css="tbody tr td:nth-child(3)")
	List<WebElement> OrderList;
	


	public boolean productDisplay(String pNmae) {
		// TODO Auto-generated method stub
		return OrderList.stream().anyMatch(s->s.getText().equalsIgnoreCase(pNmae));
		

	}
}
