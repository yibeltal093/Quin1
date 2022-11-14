import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
  private DatabaseUtility accessor;

@BeforeMethod
  public void Setup() {
	  //create dbAccesor
	  this.accessor = new DatabaseUtility();
	  accessor.isConnectionSuccessfull();
  }
  
  @Test
  public void canAccessDatabase() {
	  var result = this.accessor.Execute("dummySql");
  }
  public static void main(String[] args) {
	  String Cityquery = "SELECT city from sakila.city ORDER BY city DESC LIMIT 10;";
	  String maxPaymentQuery = "SELECT MAX(amount) FROM sakila.payment;";
	  String film_info = "SELECT film_info FROM actor_info WHERE first_name = "
	  		+ "'Bob' AND last_name = 'Fawcett';";
	  String storeInventory = "SELECT inventory_id FROM sakila.inventory AS i LEFT JOIN sakila.film AS f ON i.film_id = f.film_id\n"
	  		+ " WHERE store_id = 2 AND title = 'Alien Center' LIMIT 4;";
	  DatabaseUtility du = new DatabaseUtility();
	  du.isConnectionSuccessfull();
	  du.ExecuteSingleColumn(Cityquery);
	  du.ExecuteSingleCell(maxPaymentQuery);
	  du.queryExcutor(film_info);
	  du.queryStore(storeInventory);
  }
}
