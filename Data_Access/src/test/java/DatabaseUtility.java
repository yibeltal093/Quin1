import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class DatabaseUtility implements DatabaseAccessor {

	private String userName = "root";
	private String password = "root";
	private String serverName = "localhost";
	private String portNumber = "3306";
	private String dbName = "sakila";
	@Override
	public String[] ExecuteSingleColumn(String sql) {
		String[] city = new String[10];
		System.out.println("\n Cities:");
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while(rs.next()) {
				city[i] = (rs.getString("city"));
				System.out.println(city[i]);
				i++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return city;
	}

	@Override
	public String ExecuteSingleCell(String sql){
		System.out.println("\nMaximumu payment amount:");
		double amount = 0.0;
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				amount = rs.getDouble("MAX(amount)");
				System.out.println(amount);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return null;
	}

	@Override
	public DataRow[] Execute(String sql) {
		DataRow[] d = new DataRow[5];
		// TODO Auto-generated method stub
		return d;
	}
	
	public void queryExcutor(String sql) {
		
		//ArrayList<String> outPut = new ArrayList<>();
		System.out.println("\nFilm information for Bob:");
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String film_info = rs.getString("film_info");
				System.out.println(film_info);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void queryStore(String sql) {
		
		//ArrayList<String> outPut = new ArrayList<>();
	System.out.println("\nFour top inventories:");
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int inventory_id = rs.getInt("inventory_id");
				System.out.println(inventory_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName );
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName  + ":" + this.portNumber  + "/" + this.dbName ,
				connectionProps);

		return conn;
	}
	public void isConnectionSuccessfull() {
		Connection con = null;
		try {
			con = this.getConnection();
			System.out.println("Connection Successful");
			
		}catch(SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
		}
	}

}
