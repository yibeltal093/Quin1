import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class ControlExtensionTests extends TestBase{
  @Test
  public void canSetTextboxValue() {
		var value = "Test";

		var actualValue = new ComplicatedPage(driver)
				.navigate()
				.setUserName(value)
				.getUserName();

		assertEquals(actualValue, value, "the value should be set using a Control Extension.");
	}
  @Test
  public void canSelectYesRadioButton() throws InterruptedException {
	  var value = "You have selected Yes";
	  var actualValue = new RadioGroup(driver)
			  .navigate()
			  .clickOnYesButton()
			  .waitToLoad()
			  .getSelected();
	  
	  assertEquals(actualValue, value, "the value should get selected value.");
  }
  
  @Test
  public void canSelectImpressiveRadioButton() throws InterruptedException {
	  var value = "You have selected Impressive";
	  var actualValue = new RadioGroup(driver)
			  .navigate()
			  .clickOnImpressiveButton()
			  .waitToLoad()
			  .getSelected();
	  
	  assertEquals(actualValue, value, "the value should get selected value.");
  }
  
  @Test
  public void canSelectNoRadioButton() throws InterruptedException {
	  var value = "";
	  var actualValue = new RadioGroup(driver)
			  .navigate()
			  .clickOnNoButton()
			  .waitToLoad()
			  .getSelected();
	  
	  assertEquals(actualValue, value, "the value should get selected value.");
  }
  
  @Test
  public void canClickOnCreated() throws InterruptedException{
	  var value = "Link has responded with staus 201 and status text Created";
	  var actualValue = new HyperLinkGroup(driver)
			  .navigate()
			  .clickOnCreatedLink()
			  .waitToLoad()
			  .getHyperLinkText();
	  
	  assertEquals(actualValue, value, "the value should get selected value.");
  }
  
  @Test
  public void canSliderChangeToEightyValue(){
	  var value = "80";
	  var actualValue = new SliderGroup(driver)
			  .navigate()
			  .setValue(value)
			  .getValue();
	  
	  assertEquals(actualValue, value, "The slider value should match from set");
  }
  
  @Test
  public void canSliderChangeToZeroValue(){
	  var value = "0";
	  var actualValue = new SliderGroup(driver)
			  .navigate()
			  .setValue(value)
			  .getValue();
	  
	  assertEquals(actualValue, value, "The slider value should match from set");
  }
  
  @Test
  public void canSliderChangeToHundredValue() throws InterruptedException{
	  var value = "100";
	  var actualValue = new SliderGroup(driver)
			  .navigate()
			  .setValue(value)
			  .waitForSync()
			  .getValue();
	  
	  assertEquals(actualValue, value, "The slider value should match from set");
  }
}
