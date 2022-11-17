package data.access;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.Statement;
import java.sql.Types;

public class DatabaseUtility implements DatabaseAccessor {

	private String connectionString;
	
	
	public DatabaseUtility(String connectionString) {
		this.connectionString = connectionString;
	}
	

	@Override
	public String[] executeSingleColumn(String sql) {
		
		var resultArray = new ArrayList<String>();
		var dataRows = execute(sql);
		for(var dataRow: dataRows) {
			
			resultArray.add(dataRow.getCellValue(dataRow.getColumns()[0]));
		}
		return resultArray.toArray(String[]::new);
		//return resultArray.toArray(new String[0]);
	}

	
	@Override
	public String executeSingleCell(String sql) {
		var dataRows = execute(sql);
		var dataRow = dataRows[0];
		var firstColumn = dataRow.getColumns()[0];
		var cellValue = dataRow.getCellValue(firstColumn);
		return cellValue;
	}
	
	@Override
	public DataRow[] executeStoreProcedure(String storeProc, HashMap<String, String> inParameter,
			HashMap<String, String> outParameter) {
		Connection connection = null;
		var rows = new ArrayList<DataRow>();
		try {
			var sql = "{call " + storeProc + "(?, ?)}";
			connection = connectToDatabase();
			var statement = connection.prepareCall(sql);
			
			inParameter.forEach((parameterName, parameterValue)->{
				try {
					statement.setString(parameterName, parameterValue);
				}catch(SQLException e) {
					throw new RuntimeException(new Exception(e.getMessage()));
				}
			});
			outParameter.forEach((parameterName, parameterValue)->{
				try {
					statement.registerOutParameter(parameterName, Types.NVARCHAR);
				}catch(SQLException e) {
					throw new RuntimeException(new Exception(e.getMessage()));
				}
				try {
					statement.setString(parameterName, parameterValue);
				}catch(SQLException e) {
					throw new RuntimeException(new Exception(e.getMessage()));
				}
			});
			boolean hasResults = statement.execute();
			
			while(hasResults) {
				var resultSet = statement.getResultSet();
				//-----------------------------;
				hasResults = statement.getMoreResults();
			}
			//---------------------------------------;
			ArrayList<DataRow> result = null;
			return rows.toArray(DataRow[]::new);
		}catch(SQLException e) {
			throw new RuntimeException(new Exception(String.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage())));
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					throw new RuntimeException(new Exception(e.getMessage()));
				}
			}
		}
	}

	private Connection connectToDatabase() throws SQLException{
		return DriverManager.getConnection(this.connectionString);
	}


	@Override
	public DataRow[] execute(String sql) {
		var rows = new ArrayList<DataRow>();
		Connection connection = null;
		
		try {
			connection = connectToDatabase();
			var statement = connection.createStatement();
			var resultSet = statement.executeQuery(sql);
			var columnCount = resultSet.getMetaData().getColumnCount();
			
			while(resultSet.next()) {
				var dataRow = new ResultDataRow();
				for(int column = 1; column <= columnCount; column++) {
					var columnName = resultSet.getMetaData().getColumnName(column);
					var cellValue = resultSet.getString(column);
					
					dataRow.addColumn(columnName);
					dataRow.setValue(columnName, cellValue);
				}
				
				rows.add(dataRow);
			}
		
			return rows.toArray(new DataRow[rows.size()]);
		}catch(SQLException e) {
			throw new RuntimeException(new Exception(String.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage())));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(new Exception(e.getMessage()));
			}
		}
	}
	
}
