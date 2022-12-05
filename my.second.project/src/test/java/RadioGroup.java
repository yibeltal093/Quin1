

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class RadioGroup extends PageObject{


	public RadioGroup(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//label[@for='yesRadio']")
	private WebElement yesButtonInput;
	
	@FindBy(how=How.XPATH, using="//label[@for='impressiveRadio']")
	private WebElement impressiveButtonInput;
	
	@FindBy(how=How.XPATH, using="//label[@for='noRadio']")
	private WebElement noButtonInput;
	
	@FindBy(how=How.XPATH, using="//p[@class='mt-3']")
	private WebElement redioButtonValue;
	

	public RadioGroup navigate() {
		this.driver.get("https://demoqa.com/radio-button");
		return this;
	}

	public RadioGroup clickOnYesButton() {
		new RadioButton(yesButtonInput).clickOnRadioButton();
		return this;
	}
	
	public RadioGroup waitToLoad() throws InterruptedException {
		Thread.sleep(2000);
		return this;
	}
	
	public RadioGroup clickOnImpressiveButton() {
		new RadioButton(impressiveButtonInput).clickOnRadioButton();
		return this;
	}
	
	public RadioGroup clickOnNoButton() {
		new RadioButton(noButtonInput).clickOnRadioButton();
		return this;
	}

	public String getSelected() {
		return new RadioButton(redioButtonValue).getClickedRadioTextValue();
	}


}
