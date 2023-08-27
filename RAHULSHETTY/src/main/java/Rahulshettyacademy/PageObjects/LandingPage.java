package Rahulshettyacademy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacaemy.AbstractComponents.AbstractComponent;

    public class LandingPage  extends  AbstractComponent{
    	WebDriver driver;
    	public LandingPage(WebDriver driver) 
    	
    	
     {
    	
        super(driver);
		//initialization
		this.driver = driver;
		//this.landingP
		PageFactory.initElements(driver, this);
		
	    }

	////WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	
	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	
	//LandingPage landingPage = null;
	public ProductCatalogue loginApplication(String email, String password) {
		//LandingPage landingPage = null;
		
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue  =  new  ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	//https://rahulshettyacademy.com/client
	
	public void goTo() {
		
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
	
}