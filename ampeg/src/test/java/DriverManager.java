import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public abstract class DriverManager {
	private WebDriver driver;
	
	public abstract void createDriver();
	
	public WebDriver getDriver() {
		return this.driver;
	}
	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	@AfterMethod
	public void cleanUp() {
		this.quitDriver();
	}
	
	public void quitDriver() {
		if(this.driver == null) {
			System.out.println("This driver is still null");
			return;
		}
		this.driver.quit();
	}
	public void launchDriverManager() {
		var url = "https://www.ampeg.com/";
		this.driver = this.getDriver();
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
}
