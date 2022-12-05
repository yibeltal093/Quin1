

import org.openqa.selenium.WebElement;

import ControlExtensions.ControlExtension;


public class RadioButton extends ControlExtension{

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
	}
	public void clickOnRadioButton() {
		this.mappedElement.click();
	}
	public String getClickedRadioTextValue() {
		return this.mappedElement.getAttribute("textContent");
		
	}
}
