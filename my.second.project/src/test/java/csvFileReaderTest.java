import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.testng.annotations.Test;

import my.second.project.Bass;

public class csvFileReaderTest {
  @Test
  public void canReadCsvFile() throws IOException {
	  	Map <String, String>testMap = new HashMap<>();
	  	File file = new File("src/test/resources/basses.csv");
	  	Scanner input = new Scanner(file);
		String[] tempArr;
		String line = "";
		var valueBase = new Bass().readFile(file);
		valueBase.entrySet();
		while(input.hasNext()) {
			line = input.next();
			tempArr = line.split(",");
			testMap.put(tempArr[1], tempArr[0]);
		}
		input.close();
		
		var expectedValue = testMap.entrySet();
		
		var value = valueBase.entrySet();
		
		assertEquals(value, expectedValue, "file reader should be get the values of make and model");
  }
}
