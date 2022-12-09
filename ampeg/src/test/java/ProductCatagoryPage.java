import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCatagoryPage extends PageObject{

	public ProductCatagoryPage(WebDriver driver) {
		super(driver);
	}
	public ProductDetailPage clickProductDetailLink() {
		var productDetailLink = this.driver.findElement(By.linkText("SVT-410HLF"));
		productDetailLink.click();
		return new ProductDetailPage(this.driver);
	}
}
