package RaahulShettyAcademyy.tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.CheckoutPage;
import Rahulshettyacademy.PageObjects.ConfirmationPage;
import Rahulshettyacademy.PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

import Rahulshettyacademy.PageObjects.LandingPage;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
public class StandAloneTest {

public static void main(String[] args) throws Exception {
String ProductName = "ZARA COAT 3";
WebDriverManager.edgedriver().setup();
WebDriver driver = new EdgeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
driver.manage().window().maximize();
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
LandingPage landingpage = new LandingPage(driver);

landingpage.goTo();
ProductCatalogue productCatalogue = landingpage.loginApplication("1234taraka@gmail.com" ,"1234Tarak@");
//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
List<WebElement>products = productCatalogue.getProductList();
productCatalogue.addProductToCart(ProductName);
//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart'][1]")).click();
CartPage cartPage = productCatalogue.goToCartPage();
//List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
//Boolean match = cartproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
//Assert.assertTrue(match);
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
//CartPage cartPage = new CartPage(driver);
Boolean match = cartPage.VerifyProductDisplaly(ProductName);
Assert.assertTrue(match);
CheckoutPage checkoutPage = cartPage.goToCheckout();
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
checkoutPage.selectCountry("india");
ConfirmationPage confirmationPage = checkoutPage.submitorder();
//Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")), "india").build().perform();

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]"))); 
////driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
//String confirmMessage = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
String confirmMessage = confirmationPage.getConfirmationMessage();
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
driver.close();
}

}