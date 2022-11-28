
public class DriverManagerFactory {
	public static DriverManager getManager(String fileText) {
		DriverManager cdm = null;
		if(fileText.equalsIgnoreCase("chrome")) {
			cdm = new ChromeDriverManager();
		}else if(fileText.equalsIgnoreCase("edge")) {
			cdm = new EdgeDriverManager();
		}
		cdm.createDriver();
		cdm.launchDriverManager();
		//cdm.cleanUp();
		return cdm;
	}
}
