import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedState = "Texas";
		var actualState = States.Texas.Name;
		Assert.assertEquals(actualState, expectedState, "State name should be returned");
	}
	
	@Test
	public void canGetStateNameWashington() {
		var expectedState = "Washington";
		var actualState = States.Washington.Name;
		Assert.assertEquals(actualState, expectedState, "State name should be returned");
	}
	
	@Test
	public void canGetStateNameOregon() {
		var expectedState = "Oregon";
		var actualState = States.Oregon.Name;
		Assert.assertEquals(actualState, expectedState, "State name should be returned");
	}
	
	@Test
	public void canGetStateAbbriviation() {
		var expectedAbbriviation = "TX";
		var actualAbbriviation = States.Texas.Abbriviation;
		Assert.assertEquals(actualAbbriviation, expectedAbbriviation, "State initial should be returned");
	}
	
	@Test
	public void canGetState() {
		var expectedState = "Louisiana";
		var actualState = getState(LocationObjectMothers.newOrleans());
		Assert.assertEquals(actualState.Name, expectedState, "State should be returned");
	}
	private State getState(LocationObjectMother mother) {
		return mother.State;
	}
	
	@Test
	public void canGetCity() {
		var expectedCity = "Housten";
		var actualCity = getCity(LocationObjectMothers.Texas());
		Assert.assertEquals(actualCity.Name, expectedCity, "City should be returned");
	}
	private City getCity(LocationObjectMother mother) {
		return mother.City;
	}	
}
