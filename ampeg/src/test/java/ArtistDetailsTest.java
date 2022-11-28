import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ArtistDetailsTest extends AmpegTests{
  @Test
  public void ensureTheArtistBandNameDesplayed() {
	var expectedBandName = "Miranda Lambert / Pistol Annies / John Fogerty";
		  
	  var bandName = new ArtistHomePage(this.driver)
			  .clickArtistsLink()
			  .clickOnAdenBubeck()
			  .getBandName();;
	  assertEquals(bandName, expectedBandName, "Product details should contain artist name");
  }
}
