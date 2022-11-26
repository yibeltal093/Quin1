import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SanityTests {
  private WebDriver driver;
@AfterMethod
  public void cleanUp() {
	if(this.driver == null) {
		return;
	}
	this.driver.quit();
  }
  @Test
  public void canLaunchChromeDriver() {
	  
	  var chromeDriverPath = "C:\\Users\\yibe\\Downloads\\chromedriver_win32\\chromedriver.exe";
	  var url = "https://www.selenium.dev/";
	  System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	  
	  this.driver = new ChromeDriver();
	  driver.navigate().to(url);
	  var currentUrl = driver.getCurrentUrl();
	  assertEquals(currentUrl, url, "Selenium is seted up correctly.");
  }
  @Test
  public void canLaunchMsEdgeDriver() {
	  
	  var driverPath = "C:\\Users\\yibe\\Downloads\\edgedriver_win64\\msedgedriver.exe";
	  var url = "https://www.selenium.dev/";
	  System.setProperty("webdriver.edge.driver", driverPath);
	  
	  this.driver = new EdgeDriver();
	  driver.navigate().to(url);
	  var currentUrl = driver.getCurrentUrl();
	  assertEquals(currentUrl, url, "Selenium is seted up correctly.");
  }
}
