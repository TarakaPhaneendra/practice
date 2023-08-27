package RaahulShettyAcademyy.tests;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.asserts.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.*;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.CheckoutPage;
import Rahulshettyacademy.PageObjects.ConfirmationPage;
import Rahulshettyacademy.PageObjects.LandingPage;
import Rahulshettyacademy.PageObjects.OrderPage;
import Rahulshettyacademy.PageObjects.ProductCatalogue;
import   Rahulshettyacademyy.TestComponents1.BaseTest;
public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
@Test(dataProvider ="getData", groups = {"Purchase"})
public void submitOrder(HashMap<String,String> input) throws Exception{



LandingPage landingPage = launchApplication();
ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
List<WebElement>products = productCatalogue.getProductList();
productCatalogue.addProductToCart(input.get("product"));
//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart'][1]")).click();
CartPage cartPage = productCatalogue.goToCartPage();
//List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
//Boolean match = cartproducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
//Assert.assertTrue(match);
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
//CartPage cartPage = new CartPage(driver);
Boolean match = cartPage.VerifyProductDisplaly(input.get("product"));
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
//driver.close();
}



@Test(dependsOnMethods = {"submitOrder"})
public void OrderHistoryTest() throws Exception  {
	LandingPage landingPage = launchApplication();
	ProductCatalogue productCatalogue = landingPage.loginApplication("1234taraka@gmail.com" ,"1234Tarak@");
	OrderPage ordersPage =  productCatalogue.goToOrdersPage();
	Assert.assertTrue(ordersPage.VerifyOrderDisplaly(productName));
}

public String getScreenshot(String testCaseName, WebDriver driver) throws Exception  {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+ "//repors//" + testCaseName  +".png");
			FileUtils.copyFile(source , file);
	return System.getProperty("user.dir")+ "//repors//" + testCaseName  +".png";
	
}

@DataProvider
public Object[][] getData() throws IOException
{
	/*
	 * HashMap<String,String> map = new HashMap<String,String>(); map.put("email",
	 * "1234taraka@gmail.com"); map.put("password", "1234Tarak@");
	 * map.put("product", "ZARA COAT 3");
	 * 
	 * HashMap<String,String> map1 = new HashMap<String,String>(); map1.put("email",
	 * "1234taraka@gmail.com"); map1.put("password", "1234Tarak@");
	 * map1.put("product", "ZARA COAT 3");
	 */
	
	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyyacademy\\data\\PurchaseOrder.json"); 
			
	
	return new Object[][]  {{data.get(0)} ,{data.get(1)} };
	
}
//@DataProvider
//public Object[][] getData()
//{
//  return new Object[][]  {{"1234taraka@gmail.com","1234Tarak@","ZARA COAT 3"}, {"1234taraka@gmail.com","1234Tarak@","ZARA COAT 3"} };
//  
//}


}