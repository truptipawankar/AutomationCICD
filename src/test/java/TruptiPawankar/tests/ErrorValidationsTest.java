package TruptiPawankar.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TruptiPawankar.TestComponents.BaseTest;
import TruptiPawankar.pageobjects.CartPage;
import TruptiPawankar.pageobjects.CheckPutPage;
import TruptiPawankar.pageobjects.ConfirmationPage;
import TruptiPawankar.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = TruptiPawankar.TestComponents.Retry.class)
	public void loginErrorValidations() throws InterruptedException, IOException
	{
		
		
	    landingPage.loginApplication("sili@gmail.com", "qewrt65");
	    Assert.assertEquals(landingPage.errorMessage(),"Incorrect email or password.");
        
	}
	
	 @Test
		public void productErrorValidation() throws InterruptedException, IOException
		{
			
			String productName = "ZARA COAT 3";
	        ProductCatalogue productCatalogue = landingPage.loginApplication("Trupti@gmail.com", "Tripi@1234");
	        List<WebElement> products=productCatalogue.getProductList();
	        productCatalogue.addProductToCart(productName);
	        CartPage cartPage = productCatalogue.goToCartPage();
	        Boolean match=cartPage.verifyProductDisplay("ZARA COAT 33");
	        Assert.assertFalse(match);
	   
		}

}
