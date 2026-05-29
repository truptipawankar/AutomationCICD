package TruptiPawankar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TruptiPawankar.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	
		// TODO Auto-generated method stub
		
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPasswordEle;
	
	@FindBy(id="login")
	WebElement submit;
	//div[@class='ng-tns-c4-36 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error ng-animating']
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	
public String errorMessage() 
{
	waitForWebElementToAppear(errorMessage);
	return errorMessage.getText();
	
}
	

	public ProductCatalogue loginApplication(String email, String password) {
		// TODO Auto-generated method stub
		userEmail.sendKeys(email);
		userPasswordEle.sendKeys(password);
		submit.click();
		  ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		  return productCatalogue;
	}
		

	


	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/client");
	}


}
