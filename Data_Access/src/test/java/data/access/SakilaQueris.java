package data.access;

public class SakilaQueris {

	private DatabaseAccessor accessor;

	public SakilaQueris(DatabaseAccessor databaseUtility) {
		this.accessor = databaseUtility;
	}
	public String[] get10CitiesInDescAlhaOrder(){
		var sql = "SELECT city from sakila.city ORDER BY city DESC LIMIT 10;";
		return this.accessor.executeSingleColumn(sql);
	}	
	public String getHighestPaymentAmount(){
		var sql = "SELECT MAX(amount) FROM payment;";
		return this.accessor.executeSingleCell(sql);
	}
	public String getFilmInfo() {
		var sql = "SELECT film_info FROM actor_info WHERE first_name = "
		  		+ "'Bob' AND last_name = 'Fawcett';";
		return this.accessor.executeSingleCell(sql);
	}
	public DataRow[] getFilmIds() {
		var sql = "SELECT inventory_id FROM sakila.inventory AS i LEFT JOIN sakila.film AS f ON i.film_id = f.film_id\n"
		  		+ " WHERE store_id = 2 AND title = 'Alien Center' LIMIT 4;";
		return this.accessor.execute(sql);
	}
}
