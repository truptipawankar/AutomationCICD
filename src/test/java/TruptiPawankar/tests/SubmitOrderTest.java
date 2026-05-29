package TruptiPawankar.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TruptiPawankar.TestComponents.BaseTest;
import TruptiPawankar.pageobjects.CartPage;
import TruptiPawankar.pageobjects.CheckPutPage;
import TruptiPawankar.pageobjects.ConfirmationPage;
import TruptiPawankar.pageobjects.LandingPage;
import TruptiPawankar.pageobjects.OrderPage;
import TruptiPawankar.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName ="ZARA COAT 3";
    @Test(dataProvider = "getData",groups = "purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException
	{
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
       List<WebElement> products=productCatalogue.getProductList();
      productCatalogue.addProductToCart(input.get("product"));
       
      CartPage cartPage = productCatalogue.goToCartPage();
     
  
   Boolean match=cartPage.verifyProductDisplay(input.get("product"));
   Assert.assertTrue(match);
   CheckPutPage checkPutPage = cartPage.goToCheckOut();
   checkPutPage.selectCountry("India");
   
   ConfirmationPage cirfirmationPage=checkPutPage.submitOrder();
   String successmessage =cirfirmationPage.getConfirmationMessage();
	Assert.assertTrue(successmessage.equalsIgnoreCase("Thankyou for the order."));

	}
    
    @Test(dependsOnMethods ={"submitOrder"})
	public void orderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("sili@gmail.com", "Sili@12345");
		OrderPage orderPage=productCatalogue.goToOrderPage();
		
	
		Assert.assertTrue(orderPage.verifyOrderHistory(productName));
		
	}
    
  
    
    
    @DataProvider
    public Object[][] getData() throws IOException
    {

    
    	
    	List<HashMap<String, String>> data =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\TruptiPawankar\\data\\purchaseOrder.json");
    	return new Object[][] {{data.get(0)},{data.get(1)}};
    }
//    @DataProvider
//    public Object[][] getData()
//    {
//      return new Object[][] {{"sili@gmail.com", "Sili@12345","ZARA COAT 3"},{"Trupti@gmail.com", "Tripi@1234","ADIDAS ORIGINAL"}};
//    }
//    
    //HashMap<String, String> map = new HashMap<String, String>();
//  map.put("email", "sili@gmail.com");
//  map.put("password", "Sili@12345");
//  map.put("product", "ZARA COAT 3");
// 	
//  HashMap<String, String> map1 = new HashMap<String, String>();
//  map1.put("email", "Trupti@gmail.com");
//  map1.put("password", "Tripi@1234");
//  map1.put("product", "ADIDAS ORIGINAL");
 	
	
    
}
