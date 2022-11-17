package data.access;

import org.testng.annotations.BeforeMethod;

public abstract class DatabaseTests {
	protected SakilaQueris sakilaQueries;
	
	@BeforeMethod
	  public void Setup() {
		  //create dbAccesor
		var connectionString = "jdbc:mysql://localhost/sakila?user=root&password=root"; 
		this.sakilaQueries = new SakilaQueris(new DatabaseUtility(connectionString));
	  }

}
