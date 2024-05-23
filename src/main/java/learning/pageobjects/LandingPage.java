package learning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public ProductCatalogue loginApplication(String email,String pswd) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pswd);
		submit.click();
		ProductCatalogue productcat = new ProductCatalogue(driver);
		return productcat;
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public void randomMethod() {
		
		System.out.println("Adding comments to test git");
	}
}

