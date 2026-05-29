package TruptiPawankar.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TruptiPawankar.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
	this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements( driver,this);
	}
	@FindBy(css=".cartSection h3")
    List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	
	public Boolean verifyProductDisplay(String productName) 
	{
		Boolean match= productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	     return match;
	}
	  
 public CheckPutPage goToCheckOut() 
 {
	  JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].click();",
	            checkOutEle);

	 //checkOutEle.click();
	 
	 return new CheckPutPage(driver);
 }
    
     
     
     

	

}
