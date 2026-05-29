package TruptiPawankar.stepDefination;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TruptiPawankar.TestComponents.BaseTest;
import TruptiPawankar.pageobjects.CartPage;
import TruptiPawankar.pageobjects.CheckPutPage;
import TruptiPawankar.pageobjects.ConfirmationPage;
import TruptiPawankar.pageobjects.LandingPage;
import TruptiPawankar.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class stepDefinationImpl extends BaseTest {

	public ProductCatalogue productCatalogue;
    public LandingPage landingPage;
    public ConfirmationPage cirfirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given("^Login with the username (.+) and password (.+)$")
	public void login_with_the_username_and_password(String username,String password)
	{
		 productCatalogue = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+)  to cart$")
	public void  i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_the_order(String productName)
	{
		 CartPage cartPage = productCatalogue.goToCartPage();
	     
		  
		   Boolean match=cartPage.verifyProductDisplay(productName);
		   Assert.assertTrue(match);
		   CheckPutPage checkPutPage = cartPage.goToCheckOut();
		   checkPutPage.selectCountry("India");
		   cirfirmationPage=checkPutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on the confirmatioPage")
	public void message_is_displayed_on_the_confirmatioPage(String string)
	{
		String successmessage =cirfirmationPage.getConfirmationMessage();
		Assert.assertTrue(successmessage.equalsIgnoreCase(string));
	}
	
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string1)
	{
		
		 Assert.assertEquals(string1,"Incorrect email or password.");
		 driver.close();
	}
}
