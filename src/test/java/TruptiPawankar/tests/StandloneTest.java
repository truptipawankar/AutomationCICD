package TruptiPawankar.tests;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TruptiPawankar.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandloneTest {
     
	
	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LandingPage landingPage = new LandingPage(driver);
        driver.findElement(By.id("userEmail")).sendKeys("sili@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Sili@12345");
        driver.findElement(By.id("login")).click();
        
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By.cssSelector(".mb-3")));
//        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        
      List<WebElement> products=  driver.findElements(By.cssSelector(".mb-3"));
      //or //driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"))
      
     
      
      WebElement prod =	products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
      System.out.println(prod);
      
      WebElement addToCart = prod.findElement(By.cssSelector(".card-body button:last-of-type"));
 

    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	js.executeScript("arguments[0].click();", addToCart);
   
      //toast-container
      

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    
    
    driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
    
    List<WebElement> productsList = driver.findElements(By.cssSelector(".cartSection h3"));
    
     Boolean match= productsList.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
     Assert.assertTrue(match);
     
     
     WebElement checkoutBtn =
    	        driver.findElement(By.cssSelector(".totalRow button"));

    	wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));

    	

    	js.executeScript("arguments[0].click();", checkoutBtn);
    	
    	
    	
    	Actions a= new Actions(driver);
    	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
    	
    	WebElement india= driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]"));
    	js.executeScript("arguments[0].click();", india);
    	
    	WebElement Placeorder= driver.findElement(By.cssSelector(".action__submit"));
    	
    	js.executeScript("arguments[0].click();", Placeorder);
    	
    	String successmessage =driver.findElement(By.cssSelector(".hero-primary")).getText();
    	Assert.assertTrue(successmessage.equalsIgnoreCase("Thankyou for the order."));
    	
    	
    	
     
    
	}
	}



