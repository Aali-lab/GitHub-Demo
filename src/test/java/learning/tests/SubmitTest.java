package learning.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import learning.pageobjects.CartCheckoutPage;
import learning.pageobjects.CartPage;
import learning.pageobjects.ConfirmationPage;
import learning.pageobjects.LandingPage;
import learning.pageobjects.ProductCatalogue;
import learning.testComponents.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubmitTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException
	
	{
		String productName = "ZARA COAT 3";
	    
		ProductCatalogue productcat = landingPage.loginApplication("test-test@gmail.com", "Tiger@2580");

		List<WebElement> products = productcat.getProductList();

		productcat.addProductToCart(productName);
		CartPage cart = productcat.goToCart(productName);

		Boolean match = cart.verifyProductDisplay(productName);

		Assert.assertTrue(match);
		CartCheckoutPage checkoutPage = cart.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confrmPage = checkoutPage.clickSubmit();
		String confirmMessage = confrmPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		

	}

}
