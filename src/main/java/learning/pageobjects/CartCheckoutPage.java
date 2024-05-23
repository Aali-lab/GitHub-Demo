package learning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learning.abstractComponents.AbstractComponent;

public class CartCheckoutPage extends AbstractComponent {

	WebDriver driver;
	public CartCheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	
	
	@FindBy(css="[placeholder ='Select Country']")
	WebElement inputCountry;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
        a.sendKeys(inputCountry,countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
	}
	
	public ConfirmationPage clickSubmit()  {
		
		submit.click();
		ConfirmationPage confrmPage= new ConfirmationPage(driver);
		return confrmPage;
		
	}
		
		
	}
	
	
	
	
	
	
	
	
	
	


