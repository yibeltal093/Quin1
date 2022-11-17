package data.access;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import org.testng.annotations.Test;

public class JdbcTests extends DatabaseTests {
  @Test
  public void canGet10CitiesInDescAlphOrder() {
	  var expectedResult = new String[] {
			  "Ziguinchor"
			  , "Zhoushan"
			  ,"Zhezqazghan"
			  , "Zeleznogorsk"
			  , "Zaria"
			  , "Zapopan"
			  , "Zaoyang"
			  , "Zanzibar"
			  , "Zalantun"
			  , "Yuzhou"
	  };
	  var result = this.sakilaQueries.get10CitiesInDescAlhaOrder();
	  assertEquals(result, expectedResult, "The query shoul result the cities in order");
  }
  
  @Test
  public void canGetHieghstPaymentAmount() {
	  var expectedResult = "11.99";
	  var sql = "SELECT MAX(amount) FROM payment;";
	  var result = this.sakilaQueries.getHighestPaymentAmount();
	  assertEquals(result, expectedResult, "The query should return single cell heighst payment");
  }
  
  @Test
  public void canUserViewToGetFilmInfo() {
	  var expectedResult = "Action: DARN FORRESTER; Animation: "
	  		+ "DARES PLUTO, LAWLESS VISION, OSCAR GOLD; Children: "
	  		+ "CIRCUS YOUTH; Classics: DYNAMITE TARZAN; Comedy: "
	  		+ "CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; "
	  		+ "Documentary: ADAPTATION HOLES, PELICAN COMFORTS; "
	  		+ "Drama: JACKET FRISCO, SCORPION APOLLO; Family: "
	  		+ "HOMICIDE PEACH; Games: DAZED PUNK; Horror: ACE GOLDFINGER; "
	  		+ "Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; New: "
	  		+ "CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; Sci-Fi: "
	  		+ "RAGING AIRPLANE; Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE";
	  
	  var result = this.sakilaQueries.getFilmInfo();
	  
	  assertEquals(result, expectedResult, "The query should return single cell with film info");
  }
  @Test
  public void canUseStoredProcToGetFilmIds() {
	  var row1 = new ResultDataRow("inventory_id", "73");
	  
	  var row2 = new ResultDataRow("inventory_id", "74");
	  
	  var row3 = new ResultDataRow("inventory_id", "75");
	  
	  var row4 = new ResultDataRow("inventory_id", "76");
	  
	  var expectedResult = new ArrayList<DataRow>();
	  expectedResult.add(row1);
	  expectedResult.add(row2);
	  expectedResult.add(row3);
	  expectedResult.add(row4);
	  
	  var result = this.sakilaQueries.getFilmIds();
	  
	  assertEquals(result, expectedResult, "The query should return film Ids.");
 
  }
	
}
