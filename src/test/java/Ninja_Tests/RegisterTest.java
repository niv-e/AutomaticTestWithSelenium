package Ninja_Tests;

//Generated by Selenium IDE
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/*import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;*/




public class RegisterTest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;	
	@Before
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	 
	}
	@After
	public void tearDown() {
	 driver.quit();
	}
	
	// function to success register:
	//@Test
	public void register() {
	 // Test name: Register test
	 // Step # | name | target | value
	 // 1 | open site 
	 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	 // 2 | setWindowSize | 1052x666 | 
	 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	 //driver.manage().window().setSize(new Dimension(1052, 666));
	 // 3 | type | name=q | hello
	 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	 
	 // Enter user name details:
	 driver.findElement(By.id("input-firstname")).sendKeys("standard_user"); // input first name
	 driver.findElement(By.id("input-lastname")).sendKeys("standard_user"); // input last name
	 driver.findElement(By.id("input-email")).sendKeys("standard_user@gmail.com"); // input email
	 driver.findElement(By.id("input-telephone")).sendKeys("standard_user"); // input telephone
	 driver.findElement(By.id("input-password")).sendKeys("standard_user"); // input password
	 driver.findElement(By.id("input-confirm")).sendKeys("standard_user"); // confirm password
	 driver.findElement(By.name("agree")).click(); // click on agree checkbox
	 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click(); // click on continue button
	 // should be navigated to success url:
	 Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success"));
}
	//@Test
	public void login() {
	 // Test name: Register test
	 // Step # | name | target | value
	 // 1 | open site | / | 
	 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	 // 2 | Click on my account
	 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	 //driver.manage().window().setSize(new Dimension(1052, 666));
	 // 3 | Click on login
	 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
	 // Enter user name details:
	 driver.findElement(By.id("input-email")).sendKeys("standard_user@gmail.com"); // input email
	 driver.findElement(By.id("input-password")).sendKeys("standard_user"); // input password
	 // click on continue button
	 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click(); // click on continue button
//	 // should be navigated to success url	
	 Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/account"));
}
	
	//@Test
	public void addToCart() {
	 // Test name: Register test
	 // Step # | name | target | value
	 // 1 | open site | / | 
	 driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	 // 2 | Click add to cart on iphone button
	 driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")).click();

	 // 3 | Click on my cart
	 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click();
	 
	 // can add verification of items in cart
	}
	
	@Test
	public void purchase()
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		// add iphone to cart
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]")).click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // click on cart button
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // click on checkout button
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // choose checkout as guest
	 driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label")).click();
	 // click on continue
	 driver.findElement(By.id("button-account")).click();
	 
	 // fill checkout form
	 try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 // enter billing address
	 driver.findElement(By.id("input-payment-firstname")).sendKeys("standard_user"); // input first name
	 driver.findElement(By.id("input-payment-lastname")).sendKeys("standard_user"); // input first name
	 driver.findElement(By.id("input-payment-address-1")).sendKeys("standard_user"); // input first name
	 driver.findElement(By.id("input-payment-city")).sendKeys("standard_user"); // input email
	 driver.findElement(By.id("input-payment-email")).sendKeys("standard_user@gmail.com"); // input email
	 driver.findElement(By.id("input-payment-telephone")).sendKeys("standard_user"); // input telephone
	 driver.findElement(By.id("input-payment-postcode")).sendKeys("205205"); // input first name
	 // fill checkout form
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 driver.findElement(By.id("input-payment-zone")).sendKeys("Angus"); // input first name
	 
	 // fill checkout form
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 //driver.findElement(By.xpath("//*[@id=\"collapse-payment-address\"]/div/div[4]/div/input[1]")).click();
	 driver.findElement(By.id("button-guest")).click();
	 // fill checkout form
	 try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 // click on continue on shipping:
	 driver.findElement(By.id("button-shipping-method")).click();
	 // click on confirm agree:
	 try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 // click on continue on payment details
	 driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
	 driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();
	 try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //click on confirm button
	 driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
	 try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
 
	 // validate url success order
	 Assert.assertTrue(driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=checkout/success"));
}
	


public static void main(String args[]) {
	  JUnitCore junit = new JUnitCore();
	  junit.addListener(new TextListener(System.out));
	  org.junit.runner.Result result = junit.run(RegisterTest.class); // Replace "SampleTest" with the name of your class
	  if (result.getFailureCount() > 0) {
	    System.out.println("Test failed.");
	    System.exit(1);
	  } else {
	    System.out.println("Test finished successfully.");
	    System.exit(0);
	  }
	}
}
