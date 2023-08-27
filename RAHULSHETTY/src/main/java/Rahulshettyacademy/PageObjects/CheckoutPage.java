package Rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacaemy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
WebDriver driver;
public CheckoutPage(WebDriver driver) {
super(driver);
this.driver = driver;
PageFactory.initElements( driver , this);
}
//Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")), "india").build().perform();
@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
WebElement submit;
@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
WebElement country;
//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
@FindBy(xpath = "(//button[@type='button'])[2]")
WebElement selectcountry;
By results = By.xpath("(//button[@type='button'])[2]"); 
public void selectCountry(String countryName) {
Actions a = new Actions(driver);
//a.sendKeys(driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")), "india").build().perform();
a.sendKeys(country, countryName).build().perform();
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]"))); 
waitForElementToAppear(results);
//driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
selectcountry.click();
}
public ConfirmationPage submitorder() {
submit.click();
return new ConfirmationPage(driver);
}

}