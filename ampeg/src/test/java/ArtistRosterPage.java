import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistRosterPage extends PageObject {

	protected ArtistRosterPage(WebDriver driver) {
		super(driver);
	}
	public String getBandName() {
		var element = this.driver.findElement(By.cssSelector(".detail h5"));
		return element.getText();
	}
	public String getGear() {
		var element = this.driver.findElement(By.cssSelector(".detail li"));
		return element.getText();
	}
}
