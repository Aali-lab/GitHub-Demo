package learning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutElement;
	
	
	public Boolean verifyProductDisplay(String productName) {
		
	Boolean	match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public CartCheckoutPage goToCheckout() {
		checkOutElement.click();
		System.out.println("Adding comments to test git");
		CartCheckoutPage cartCheckout=new CartCheckoutPage(driver);
		return cartCheckout;
		
		
	}
	
	
	
	}
	
	
	
	
	
	


