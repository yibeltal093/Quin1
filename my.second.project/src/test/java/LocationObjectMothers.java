public class LocationObjectMothers {
	public static LocationObjectMother newOrleans() {
		return new LocationBuilder()
				.withState(States.Louisiana)
				.withCity(Cities.NewOrleans)
				.build();
	}
	
public static LocationObjectMother Texas() {
		return new LocationBuilder()
				.withState(States.Texas)
				.withCity(Cities.Housten)
				.build();
	}
}
