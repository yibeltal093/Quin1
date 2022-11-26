package data.access;
//import java.sql.SQLException;
import java.util.HashMap;

public interface DatabaseAccessor {
	String[] executeSingleColumn(String sql);
	
	String executeSingleCell(String sql);
	
	DataRow[] execute(String sql);
	
	DataRow[] executeStoreProcedure(String storeProc, 
			HashMap<String, String>inParameter, 
			HashMap<String, String>outParameter);
}