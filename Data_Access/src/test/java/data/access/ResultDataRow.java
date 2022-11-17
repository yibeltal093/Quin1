package data.access;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultDataRow implements DataRow{

	private ArrayList<String> columns;
	private HashMap<String, String> cellData;
	
	public ResultDataRow() {
		this.columns = new ArrayList<String>();
		this.cellData = new HashMap<String, String>();
	}
	
	public ResultDataRow(String columnName, String cellValue) {
		this();
		addColumn(columnName);
		setValue(columnName, cellValue);
	}
	
	@Override
	public String getCellValue(String columnName) {
		return this.cellData.get(columnName);
		//return null;
	}
	
	@Override
	public String[] getColumns() {
		return this.columns.toArray(new String[this.columns.size()]);
	}
	
	public void addColumn(String columnName) {
		if(hasColumnName(columnName)) {
			throw new RuntimeException("The column name " + columnName +
					"already exist.");
		}
		this.columns.add(columnName);
	}
	public void setValue(String columnName, String cellValue) {
		if(!hasColumnName(columnName)) {
			throw new RuntimeException("The column name " + columnName +
					"does not exist. You must add a column before data.");
		}
		
		this.cellData.put(columnName, cellValue);
	}

	private boolean hasColumnName(String columnName) {
		return columns.contains(columnName);
	}

	
}
