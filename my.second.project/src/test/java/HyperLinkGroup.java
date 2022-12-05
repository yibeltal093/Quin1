import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HyperLinkGroup extends PageObject{
	
	@FindBy(how=How.XPATH, using="//a[@id='created']")
	private WebElement createdLink;

	@FindBy(how=How.XPATH, using="//p[@id='linkResponse']")
	private WebElement linkResponse;
	
	public HyperLinkGroup(WebDriver driver) {
		super(driver);
	}
	
	public HyperLinkGroup navigate() {
		this.driver.get("https://demoqa.com/links");
		return this;
	}
	
	public HyperLinkGroup clickOnCreatedLink() {
		new HyperLink(createdLink).click();
		return this;
	}
	public HyperLinkGroup waitToLoad() throws InterruptedException {
		Thread.sleep(2000);
		return this;
	}
	public String getHyperLinkText() {
		return new HyperLink(linkResponse).getClickedLinkTextValue();
	}

}
