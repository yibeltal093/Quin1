import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDirectoryPage extends PageObject {

	protected ProductDirectoryPage(WebDriver driver) {
		super(driver);
	}
	public ProductCatagoryPage clickClassicBassHeadsAndEnclosuresLink() {
		var productLink = this.driver.findElement(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
		productLink.click();
		return new ProductCatagoryPage(this.driver);
	}
}
