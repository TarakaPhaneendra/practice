package rahulshettyacaemy.AbstractComponents;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver  = driver;
		PageFactory.initElements(driver,this);
	}
	

	//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart'][1]")).click();
	
	@FindBy(xpath  = "//i[@class='fa fa-shopping-cart'][1]")
	WebElement cartHeader;
	
	
	
			
	@FindBy(xpath  = "(//button[@class='btn btn-custom'])[2]")
	WebElement orderHeader;
	
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	private List<WebElement> cartproducts;

	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy)); 
		
	}
	
      public void waitForElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy)); 
		
	}
	
	
	public CartPage goToCartPage() {
		//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart'][1]")).click();
		
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	public OrderPage goToOrdersPage() {
		//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart'][1]")).click();
		
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
	
	
	public void waitForElementToDisappear(WebElement ele) throws Exception {
		
		
		
		
		Thread.sleep(1000);
		
	}

}