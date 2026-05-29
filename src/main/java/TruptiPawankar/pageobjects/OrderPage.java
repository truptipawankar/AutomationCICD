package TruptiPawankar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TruptiPawankar.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
     WebDriver driver;
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
			// TODO Auto-generated constructor stub
			PageFactory.initElements( driver,this);
			
	}
	@FindBy(css="tr td:nth-child(3)")
    List<WebElement> productNames;
	
	
   public Boolean verifyOrderHistory(String productName) 
   {
	  
   		Boolean match= productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
   	     return match;
   	}



   	  

	
	
	
}
