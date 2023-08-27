package Rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacaemy.AbstractComponents.AbstractComponent;

    public class ProductCatalogue extends  AbstractComponent{
    	
    	WebDriver driver;
    	public ProductCatalogue(WebDriver driver) {
		//initialization
    	super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    }
    	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); 
		
	
	@FindBy(css = ".mb-3")
	List <WebElement>   products;
	
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productBy  =  By.cssSelector(".mb-3");
	By  addToCart = By.xpath("//button[@class='btn w-10 rounded']");
	By toastMessaage = By.cssSelector("#toast-container");
	
	
	
	public  List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}
	
	
	public WebElement getProductByName(String productName) {
//		WebElement prod = products.stream().filter(product->
			//product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);////h5[@style='text-transform: uppercase;']/b"))
		
		WebElement prod =  getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws Exception {
		//prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waitForElementToAppear(toastMessaage);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		waitForElementToDisappear(spinner);
	}
	
	

	
	
}