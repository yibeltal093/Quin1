package my.second.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bass {
	private String make;
	private String model;
	Map<String, String> bassMap = new HashMap<>();
	
	public Map<String, String> readFile(File file) throws IOException{
		file = new File("src/test/resources/basses.csv");
		FileReader reader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(reader);
		String[] tempArr;
		String line = "";
		while((line = bReader.readLine()) != null) {
			tempArr = line.split(",");
			this.make = tempArr[0];
			this.model = tempArr[1];
			this.bassMap.put(model, make);
		}
		bReader.close();
		return bassMap;
	}
	
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	
	public ArrayList<Bass> getListOfBass(){
		ArrayList<Bass> bassList = new ArrayList<>();
		for(Map.Entry<String, String> set: bassMap.entrySet()) {
			Bass b = new Bass();
			this.make = set.getValue();
			this.model = set.getKey();
			bassList.add(b);
		}
		return bassList;
	}
}
