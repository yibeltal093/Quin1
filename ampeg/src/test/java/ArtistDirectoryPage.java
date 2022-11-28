import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistDirectoryPage extends PageObject{

	protected ArtistDirectoryPage(WebDriver driver) {
		super(driver);
	}
	public ArtistRosterPage clickOnAdenBubeck() {
		var productLink = this.driver.findElement(By.linkText("Aden Bubeck"));
		productLink.click();
		return new ArtistRosterPage(this.driver);
	}
}
