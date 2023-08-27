package RaahulShettyAcademyy.tests;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademyy.TestComponents1.Retry;

import Rahulshettyacademy.PageObjects.CartPage;
import Rahulshettyacademy.PageObjects.LandingPage;
import Rahulshettyacademy.PageObjects.ProductCatalogue;
import   Rahulshettyacademyy.TestComponents1.BaseTest;

public class ErrorValidations extends BaseTest {
	String ProductName = "ZARA COAT 3";
	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)

public  void LoginErrorValidation() throws Exception {


LandingPage landingPage = launchApplication();
landingPage.loginApplication("1234taraka@gmail.com" ,"234Tarak@");

//Assert.assertEquals("Incorrect email or password." , landingPage.getErrorMessage());

Assert.assertEquals("Incorrect email  password." , landingPage.getErrorMessage());

}




@Test	
public  void ProductErrorValidation() throws  Throwable{
String ProductName = "ZARA COAT 3";

LandingPage landingPage = launchApplication();
ProductCatalogue productCatalogue = landingPage.loginApplication("1234taraka@gmail.com" ,"1234Tarak@");
List<WebElement>products = productCatalogue.getProductList();
productCatalogue.addProductToCart(ProductName);
CartPage cartPage = productCatalogue.goToCartPage();
Boolean match = cartPage.VerifyProductDisplaly(ProductName);
Assert.assertTrue(match);
}

}