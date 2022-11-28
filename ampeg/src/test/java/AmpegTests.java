
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmpegTests {
	protected WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		this.launchDriver();
	}

	@Test
	private void launchDriver() throws IOException {
		File file = new File("src\\test\\resources\\driverType.txt");
		Scanner input = new Scanner(file);
		String word = "";
		while(input.hasNext()) {
			word = input.next();
		}
		this.driver = DriverManagerFactory.getManager(word).getDriver();
	}
	
}
