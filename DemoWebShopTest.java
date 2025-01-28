package demoWebShop.Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWebShopTest {
	WebDriver driver;
     
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com");
	        driver.manage().window().maximize();
    }
               @Test
		public void testSearchandAddToCart() {
                driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
                driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		String productName = driver.findElement(By.xpath("//a[@class='product-name']")).getText();
		Assert.assertTrue(productName.contains("14.1-inch Laptop"), "Product not added to the cart");
    }
     @AfterClass
     public void teardown() {
     driver.quit();
        }

}
