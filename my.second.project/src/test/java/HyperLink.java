import org.openqa.selenium.WebElement;

import ControlExtensions.ControlExtension;

public class HyperLink extends ControlExtension{

	public HyperLink(WebElement mappedElement) {
		super(mappedElement);
	}
	public void click() {
		this.mappedElement.click();
	}
	public String getClickedLinkTextValue() {
		return this.mappedElement.getAttribute("textContent");
		
	}

}
