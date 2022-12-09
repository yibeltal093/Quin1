import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ComplicatedPage extends PageObject{
	@FindBy(how=How.XPATH, using="//input[@id='user_login_638c7d9d4a721']/..")
	private WebElement userIdElement;

	@FindBy(how=How.XPATH, using="//input[@id='et_pb_contact_email_0']/..")
	private WebElement emailAddressElement;

	@FindBy(how=How.XPATH, using="//input[@id='et_pb_contact_name_0']/..")
	private WebElement nameElement;

	@FindBy(how=How.XPATH, using="//textarea[@id='et_pb_contact_message_0']/..")
	private WebElement messageElement;

	public ComplicatedPage(WebDriver driver) {
		super(driver);
	}

	public ComplicatedPage navigate() {
		this.driver.get("https://ultimateqa.com/complicated-page");

		return this;
	}

	public ComplicatedPage setEmailAddress(String value) {
		new ControlExtensions.TextBox(emailAddressElement).setValue(value);

		return this;
	}

	public String getEmailAddress() {
		return new ControlExtensions.TextBox(emailAddressElement).getValue();
	}

	public String getEmailAddressLabel() {
		return new ControlExtensions.TextBox(emailAddressElement).getLabel();
	}

	public ComplicatedPage setUserName(String value) {
		 new ControlExtensions.TextBox(userIdElement).setValue(value);
		 return this;
	}

	public String getUserName() {
		return new ControlExtensions.TextBox(userIdElement).getValue();
	}
}
