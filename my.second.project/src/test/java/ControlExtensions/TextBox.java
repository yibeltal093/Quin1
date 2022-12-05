package ControlExtensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBox extends ControlExtension{
	public TextBox(WebElement mappedElement) {
		super(mappedElement);
	}

	public void setValue(String value) {
		getInputElement().sendKeys(value);
	}

	public String getValue() {
		return getInputElement().getAttribute("value");
	}

	public String getLabel() {
		return getLabelElement().getAttribute("textContent");
	}

	private WebElement getInputElement() {
		return this.mappedElement.findElement(By.tagName("input"));
	}

	private WebElement getLabelElement() {
		return this.mappedElement.findElement(By.tagName("label"));
	}
}
