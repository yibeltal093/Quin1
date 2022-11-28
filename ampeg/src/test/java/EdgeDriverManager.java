import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
	//WebDriver edgeDriver;

	@Override
	public void createDriver() {
		 var driverPath = "C:\\Users\\yibe\\Downloads\\edgedriver_win64\\msedgedriver.exe";
		 System.setProperty("webdriver.edge.driver", driverPath);
		 super.setDriver(new EdgeDriver());
	}
}
