import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SliderGroup extends PageObject {

	public SliderGroup(WebDriver driver) {
		super(driver);
	}
	@FindBy(how=How.XPATH, using="//input[@id='sliderValue']")
	private WebElement sliderInputValue;
	
	

	public SliderGroup navigate() {
		this.driver.get("https://demoqa.com/slider");
		return this;
	}
	
	public SliderGroup setValue(String value) {
		 new Slider(sliderInputValue).setSliderValue(value);
		 return this;
	}
	public String getValue() {
		 return new Slider(sliderInputValue).getSliderValue();
	}
	public SliderGroup waitForSync() throws InterruptedException {
		Thread.sleep(2000);
		return this;
	}
}
