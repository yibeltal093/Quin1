import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ProductDetailsTest extends AmpegTests{
  @Test
  public void ensureArtistIsDiplayedOnProductDetailsPage() {
	  var expectedArtistName = "Bootsy Collins";
	  
	  var artistName = new HomePage(this.driver)
			  .clickProductsLink()
			  .clickClassicBassHeadsAndEnclosuresLink()
			  .clickProductDetailLink()
			  .getArtistName();
	  assertEquals(artistName, expectedArtistName, "Product details should contain artist name");
  }
}
