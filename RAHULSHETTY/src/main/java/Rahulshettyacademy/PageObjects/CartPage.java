package Rahulshettyacademy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacaemy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
WebDriver driver;
@FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
WebElement checkoutEle;
@FindBy(xpath = "//div[@class='cartSection']/h3")
private List<WebElement> cartproducts;
public CartPage(WebDriver driver) {
super(driver);
this.driver = driver;
PageFactory.initElements( driver , this);
// TODO Auto-generated constructor stub
}

//List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
//Boolean match = cartproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
//Assert.assertTrue(match);
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
public Boolean VerifyProductDisplaly(String productName) {
Boolean match = cartproducts.stream().anyMatch(Product-> Product.getText().equalsIgnoreCase(productName));
return match; 
}
public CheckoutPage goToCheckout() {
checkoutEle.click();
return new CheckoutPage(driver);
}
}