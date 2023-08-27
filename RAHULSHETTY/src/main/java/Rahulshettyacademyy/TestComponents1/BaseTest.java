package Rahulshettyacademyy.TestComponents1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
public WebDriver driver;
public LandingPage landingPage;
public WebDriver initializeDriver() throws IOException {
//properties class
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
+ "//src//main//java//rahulshettyyacademy//resources1//GlobalData.properties");
prop.load(fis);
String browserName = prop.getProperty("browser");
if(browserName.equalsIgnoreCase("edge")) {
WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();
}
else if(browserName.equalsIgnoreCase("Chrome")) {
////System.setProperty("webdriver.chrome.driver", "chrome.exe");
// WebDriverManager.chromedriver().setup();
////driver = new ChromeDriver();
}
else if(browserName.equalsIgnoreCase("firefox")){
WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();
}
//Firefox
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
return driver;

}
//LandingPage landingPage1 = null;
//@BeforeMethod(alwaysRun =true)


public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
{
	//read json to string
String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
		StandardCharsets.UTF_8);

//String to HashMap- Jackson Datbind

ObjectMapper mapper = new ObjectMapper();
  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
  });
  return data;

//{map, map}
}
public String getScreenshot(String testCaseName, WebDriver driver2) throws Exception  {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+ "//repors//" + testCaseName  +".png");
	FileUtils.copyFile(source , file);
	return System.getProperty("user.dir")+ "//repors//" + testCaseName  +".png";
	
}




public LandingPage launchApplication() throws IOException {
//LandingPage landingPage = launchApplication();
     driver = initializeDriver();
     LandingPage landingPage = new LandingPage(driver);
     landingPage.goTo();
     return landingPage;
}
@AfterMethod(alwaysRun =true)
public void tearDown() {
driver.close();
}

}