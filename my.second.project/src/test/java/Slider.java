
import org.openqa.selenium.WebElement;

import ControlExtensions.ControlExtension;

public class Slider extends ControlExtension{

	public Slider(WebElement mappedElement) {
		super(mappedElement);
	}
	public void setSliderValue(String value) {
		this.mappedElement.sendKeys(value);
	}

	public String getSliderValue() {
		return this.mappedElement.getAttribute("value");
	}
}
