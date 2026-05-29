package TruptiPawankar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import TruptiPawankar.AbstractComponents.AbstractComponents;

public class CheckPutPage extends AbstractComponents{

	WebDriver driver;
	
	
	
	

	public CheckPutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public  void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(results);
		  JavascriptExecutor js =
		            (JavascriptExecutor) driver;

		    js.executeScript("arguments[0].click();",
		            selectCountry);

		//selectCountry.click();
		
	
		
	}
	
	
	public ConfirmationPage submitOrder() 
	{
		  JavascriptExecutor js =
		            (JavascriptExecutor) driver;

		    js.executeScript("arguments[0].click();",
		            submit);

		
		//submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
	
	
}
