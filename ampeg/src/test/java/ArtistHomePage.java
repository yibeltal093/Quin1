

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistHomePage extends PageObject{
	public ArtistHomePage(WebDriver driver) {
		super(driver);
	}
	
	public ArtistDirectoryPage clickArtistsLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title='Artists']"));
		menuLink.click();
		return new ArtistDirectoryPage(this.driver);
	}
}
